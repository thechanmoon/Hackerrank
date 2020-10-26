'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

function getGrade(score) {
    let grade;
    // Write your code here
    
    if( 25 < score && 30 >= score)
    {
        grade = 'A';
    }else if( 20 < score && 25 >= score)
    {
        grade = 'B';
    }else if( 15 < score && 20 >= score)
    {
        grade = 'C';
    }else if( 10 < score && 15 >= score)
    {
        grade = 'D';
    }else if( 5 < score && 10 >= score)
    {
        grade = 'E';
    }else if( 0 <= score && 5 >= score)
    {
        grade = 'F';
    }

    // Ascii
    // let num = Math.ceil(score/5);
    // if(num === 0)
    // {
    //     //grade = String.fromCharCode(70); 
    //     num = 1;
    // }

    // let ascii = "F".charCodeAt(0)+1;

    // grade = String.fromCharCode(ascii-num) 
    
    // switch (Math.ceil(score/5))
    // {
    //     case 6:
    //     grade = 'A';
    //     break;

    //     case 5:
    //     grade = 'B';
    //     break;

    //     case 4:
    //     grade = 'C';
    //     break;

    //     case 3:
    //     grade = 'D';
    //     break;

    //     case 2:
    //     grade = 'E';
    //     break;

    //     case 1:
    //     case 0:
    //     grade = 'F';
    //     break;

    //     default:
    //     break;
    // }
    return grade;
}


function main() {
    const score = +(readLine());
    
    console.log(getGrade(score));
}