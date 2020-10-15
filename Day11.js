'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

function calcSum(arr) {
    let max = 0;
    let sum = 0;


    for (let i = 0; i < arr.length - 2; i++) {
        for (let j = 0; j < arr[i].length - 2; j++) {
            sum = calcHourGlassSum(arr, i, j);
            if ((i == 0 && j == 0) || sum > max) {
                max = sum;
            }
        }
    }

    return max;
}

function calcHourGlassSum(arr, row, col) {
    let sum = 0;

    for (let i = row; i < row + 3; i++) {
        for (let j = col; j < col + 3; j++) {
            if (i == row || i == row + 2 || (i == row + 1 && j == col + 1)) {
                sum += arr[i][j];
            }
        }
    }
    return sum;
}

function main() {
    let arr = Array(6);

    for (let i = 0; i < 6; i++) {
        arr[i] = readLine().split(' ').map(arrTemp => parseInt(arrTemp, 10));
    }

    console.log(calcSum(arr));
}
