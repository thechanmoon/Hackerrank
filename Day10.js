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

function printNumberOfOne(str)
{
    let result = 0;
    let sum = 0;

    let chars = str.split('');
    
    for (let i = 0; i < chars.length; i++) {
        if (chars[i] == '1')
            sum++;
        else {
            sum = 0;
        }                    
        if (sum > result) {
            result = sum;
        }
        // console.log("i = " + i);
        // console.log("sum = " + sum);
        // console.log("result = " + result);
    }
    
    console.log(result);
}


function main() {
    const n = parseInt(readLine(), 10);
    // console.log(n.toString(2));
    printNumberOfOne(n.toString(2));
}
