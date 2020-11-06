// 'use strict';

// process.stdin.resume();
// process.stdin.setEncoding('utf-8');

// let inputString = '';
// let currentLine = 0;

// process.stdin.on('data', inputStdin => {
//     inputString += inputStdin;
// });

// process.stdin.on('end', _ => {
//     inputString = inputString.replace(/\s*$/, '')
//         .split('\n')
//         .map(str => str.replace(/\s*$/, ''));

//     main();
// });

// function readLine() {
//     return inputString[currentLine++];
// }
/*

* comglete the ‘commonsubstring’ functian below.
* The functien accepts follawing parameters:

* 1. STRING_ARRAY a

* 2. STRING_ARRAY b
*/
function haveCommonSubstring(a,b)
{
    let arr = [...a];
    let retval = false;
    for(let i = 0; i < b.length; i++)
    {
        if (b.includes(arr[i]))
            retval = true;   
    }
    return retval;
}

function commonsubstring(a, b) {
    // Write your code here
    for(let i = 0; i < a.length; i++)
    {
        if(haveCommonSubstring(a[i],b[i]))
            console. log('YES');
        else
            console.log('NO');
    }    
}

function main(){
    // const aCount = parseInt(readLine().trim(), 10);

    // let a = [];
    
    // for(let i = 0; i < aCount; i++){
    //     const aItem = readLine();
    //     a.push(aItem);
    // }

    // const bCount = parseInt(readLine().trim(), 10);

    // let b = [];
    
    // for(let i = 0; i < bCount; i++){
    //     const bItem = readLine();
    //     b.push(aItem);
    // }
    let a = ['hello','hi'];
    let b = ['world','bye'];
    commonsubstring(a,b);
}

main();