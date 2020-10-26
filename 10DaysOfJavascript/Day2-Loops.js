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

/*
 * Complete the vowelsAndConsonants function.
 * Print your output using 'console.log()'.
 */
// function isVowel(char) {
//   if (char.length == 1) {
//     return /[aeiou]/.test(char);
//   }
// }

var isVowel = (function() {
  var re = /^[aeiou]$/i;
  return function(c) {
    return re.test(c);
  }
})();

function vowelsAndConsonants(s) {
    for(let i=0; i< s.length; i++)
    {
        let c = s.charAt(i);
        // if(c==='a'||c==='e'||c==='i'||c==='o'||c==='u')
        if(isVowel(c)==true)
        {
            console.log(c);
        }
    }

    for(let i=0; i< s.length; i++)
    {
        let c = s.charAt(i);
        // if(c!=='a'&&c!=='e'&&c!=='i'&&c!=='o'&&c!=='u')
        if(isVowel(c)==false)
        {
            console.log(c);
        }
    }       
}


function main() {
    const s = readLine();
    
    vowelsAndConsonants(s);
}