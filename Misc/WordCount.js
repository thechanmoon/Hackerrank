const mod = 1000000007;

const countWord = (wordLen, maxVowels) =>
{
    let dp = new Array(wordLen+1);;
    for (let i = 0; i < dp.length; i++) { 
        dp[i] = new Array(2); 
    } 

    dp[0][1] = dp[0][0] = 1;
    dp[1][1] = 21;
    dp[1][0] = 5;

    for (let i = 2; i <= wordLen; i++)
    {

        dp[i][1] = (21 * (dp[i - 1][1] + dp[i - 1][0]) % mod) % mod;

        let k = i, j = 1, p = 5;
        dp[i][0] = 0;

        while (k > 0 && j <= maxVowels)
        {
            dp[i][0] = (dp[i][0] + (p * dp[i - j][1]) % mod) % mod;
            p = (p * 5) % mod;
            k--;
            j++;
        }
    }

    return (dp[wordLen][0] + dp[wordLen][1]) % mod;
}

console.log(countWord(5, 2));