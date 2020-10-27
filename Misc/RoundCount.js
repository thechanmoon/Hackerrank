
let dp;// = new int[100][100];

const initDP = (row, col, num) =>{
    dp = new Array(row).fill(0).map(() => new Array(row).fill(num));
}

const dfs = (fuel, pos,  arr, lastpos) =>{
    if (fuel < 0)
        return 0;
    if (pos == arr.length) {
        return 1;
    }
    if (dp[fuel][pos] != -1)
        return dp[fuel][pos];
    let ans = 0;
    for (let i = pos; i < arr.length; i++) {
        let curfuel = Math.abs(arr[i] - arr[lastpos]);
        ans += dfs(fuel - curfuel, i + 1, arr, i);
    }
    return dp[fuel][pos] = ans;
}

let array = [ 1, 3, 6, 2, 4 ];
let fuel = 7;

// Arrays.stream(dp).forEach(a -> {
// Arrays.fill(a, -1);
// });
// dp = new int[fuel + 1][array.length + 1];

initDP(fuel + 1, array.length + 1, -1);

console.log(dfs(fuel, 1, array, 0));

