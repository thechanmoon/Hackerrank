function processData(input) {
    //Enter your code here
    let input_array = input.split('\n');
    let number = parseInt(input_array[0],10);
    let hash_map = {}
    // console.log(number);
    
    if( number === undefined || number < 1 )
        return
    
    for(let i = 1; i < 1+number; i++)
    {
        let temp_arr = input_array[i].split(' ');
        // console.log(input_array[i]);
        hash_map[temp_arr[0]]=temp_arr[1];
    }
    // console.log(hash_map);
    for(let i = 1+number; i < 1+number+number; i++)
    {   
        // console.log(input_array[i]);
        // if( hash_map[input_array[i]] === undefined || hash_map[input_array[i]] === null
        // || input_array[i] === undefined || input_array[i] === null
        // )
        // if(input_array[i] in hash_map)
        // if(input_array[i] in hash_map)
        // if(hash_map.hasOwnProperty(input_array[i]))
        let num = (hash_map[input_array[i]]);
        if (num !== undefined)
        {
            //console.log("Not found");
            console.log(input_array[i]+'='+hash_map[input_array[i]]);
        }else
        {
            //console.log(input_array[i]+'='+hash_map[input_array[i]]);
            console.log("Not found");
        }
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
