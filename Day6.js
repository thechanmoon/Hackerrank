function processData(input) {
    //Enter your code here
    let input_stdin_array = input.split("\n");

    for(let i = 1; i < input_stdin_array.length; i++)
    {
        // console.log(input_stdin_array[i])
        let chars = input_stdin_array[i].split('')
        let result = '';
        for(let j = 0; j < chars.length; j++)
        {
            if(j%2 === 0)
                result += (chars[j]);
        }

        result += ' ';
        
        for(let j = 0; j < chars.length; j++)
        {
            if(j%2 === 1)
                result += (chars[j]);
        }
        console.log(result); 
    } 
     
} 

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input);
});