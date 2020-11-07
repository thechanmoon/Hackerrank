'use strict';

const fs = require('fs');

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

// Complete the stringConstruction function below.
function stringConstruction(s) {

        if(s.length == 0)
            return 0;
            
        let count = 0;
        let sb ="";

        let ch = s.split('');  
        
        for(let i = 0; i < s.length; i++)
        {     
             if(sb.includes(ch[i])== false)
             {
                sb = sb+ch[i];
                count++;
                continue;
             }
        }
        return count;
}

function stringConstructionUsingArray(s) {
    
    if(s.length == 0)
        return 0;
        
    let count = 0;
    let ascii = new Array(26).fill(0);
    
    for(let i = 0; i < s.length; i++)
    {     
            let index = s.charCodeAt(i)-"a".charCodeAt(0);
            if(ascii[index] === 0)
            {
            ascii[index]++;
            count++;
            continue;
            }
    }
    return count;
}

function  stringConstructionUsingBitVector(s) {
    
    if(s.length == 0)
        return 0;
        
    let count = 0;
    let BitVector = 0;
    
    for(let i = 0; i < s.length; i++)
    {     
            let index = s.charCodeAt(i)-"a".charCodeAt(0); 
            if((BitVector & (1 << index)) == 0)
            {
                BitVector |= (1 << index);
                count++;
                continue;
            }
    }
    return count;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const q = parseInt(readLine(), 10);

    for (let qItr = 0; qItr < q; qItr++) {
        const s = readLine();

        // let result = stringConstruction(s);
        // let result = stringConstructionUsingArray(s);
        let result = stringConstructionUsingBitVector(s);
        ws.write(result + "\n");
    }

    ws.end();
}
