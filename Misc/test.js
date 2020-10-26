function processData(input) {
    let input_array = input.split('\n');
    let number = parseInt(input_array[0],10);
    let hash = {}

    for(let i = 1; i < 1+number; i++){
        let temp_arr = input_array[i].split(' ');
        // console.log(input_array[i]);
        hash[temp_arr[0]]=temp_arr[1];
    }
    
    for(let i = 1+number; i < 1+number+number; i++){   
        let num = (hash[input_array[i]]);
        if (num !== undefined){
            console.log(input_array[i]+'='+hash[input_array[i]]);
        }else{
            console.log("Not found");
        }
    }
} 