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

/**
*   Return the second largest number in the array.
*   @param {Number[]} nums - An array of numbers.
*   @return {Number} The second largest number in the array.
**/
function getSecondLargest(nums) {
    // Complete the function
    if(nums.length ===1)
        return nums[0];
    let max;
    nums.sort((a,b)=>(a-b));
    max = nums[nums.length-1];
    // console.log(nums);
    for(let i = nums.length -2; i > 0  ; i--)
    {
        
        if(max > nums[i])
        {
            // console.log(nums[i]);
            max = nums[i]; 
            break; 
        }
    } 
    return max;
    return max;
}


function main() {
    const n = +(readLine());
    const nums = readLine().split(' ').map(Number);
    
    console.log(getSecondLargest(nums));
}