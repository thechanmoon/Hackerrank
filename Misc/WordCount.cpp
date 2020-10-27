// #include<bits/stdc++.h>
// using namespace std;
// #define int long long
// #define mod 1000000007
// int solve(int n,int k){
//     int dp[n+1][k+1];
//     memset(dp,sizeof(dp),0);
//     dp[0][0]=1;

//     for(int i=1;i<=n;i++){
//         for(int j=0;j<=min(i-1,k);j++){
//             dp[i][0]+=(dp[i-1][j]*21)%mod;
//         }
//         for(int j=1;j<=min(i,k);j++){
//             dp[i][j]=(dp[i-1][j-1]*5)%mod;
//         }
//     }
//     int ans=0;
//     for(int j=0;j<=k;j++) {
//         ans+=(dp[n][j]%mod);
//     }
//     // for(int i=0; i<=n; i++) {
//     //     for(int j=0; j<=min(i,k);j++){
//     //         cout<<(dp[i][j])%mod;
//     //         cout<<" | ";
//     //     }
//     //     cout <<"\n";
//     // }

//     return ans%mod;
// }
// int32_t main(){
//     //int t;
//     //cin>>t;
//     //while(t--){
//         cout<<solve(5,2)<<endl;
//     //}
// }

// #include <iostream>
// #include <string.h>
// using namespace std;

// #define n 5
// #define k 2

// int arr[n][k + 1];

// int fill(int index, int currK){
//     if(arr[n][currK] != 0) return arr[n][currK];  //if already calculated
//     if(index == n - 1) {                          //base case
//         arr[index][currK] = 21 + (currK ? 5 : 0);
//         return arr[index][currK];
//     }

//     //recursive condition and step
//     if(currK == 0) arr[n][currK] = 21 * fill(index + 1, k);
//     else arr[n][currK] = 5 * fill(index + 1, currK - 1) + 21 * fill(index + 1, k);
//     return arr[n][currK];
// }

// int main(){
//     memset(arr, 0, sizeof(arr));
//     cout<<fill(0, k)<<endl;

//     return 0;
// }

// #include <bits/stdc++.h>

// using namespace std;

// //implementing function calculateWays

// int calculateWays(int wordlen, int maxvowels)

// {

//     //if max vowels = 0 calculating ways

//     if (maxvowels == 0)

//     {

//         int ways = 1;

//         //loop for calculating ways

//         for (int i = 0; i < wordlen; i++)

//         {

//             ways = ways * 21;
//         }

//         return ways;
//     }

//     else

//     {

//         if (wordlen == 1) //if word length is 1

//         {

//             int c = 1, v = 1;

//             int ways = c * 21 + v * 5; //calculating ways

//             return ways;
//         }

//         else // if max vowels and world length both are greater then 1

//         {

//             int ways = 0;

//             //loop to calculating

//             for (int i = 0; i < wordlen; i++)

//             {

//                 int c = 1, v = 1;

//                 for (int j = 0; j < wordlen - maxvowels; j++)

//                 {

//                     c = c * 21;
//                 }

//                 for (int k = 0; k < maxvowels; k++)

//                 {

//                     v = v * 5;
//                 }

//                 ways = ways + (v * c); // calculating ways with vowels
//             }

//             int ways1 = 1;

//             for (int i = 0; i < wordlen; i++)

//             {

//                 ways1 = ways1 * 21; //calculating ways without vowels
//             }

//             return ways + ways1; //return total ways
//         }
//     }
// }

// int main()

// {

//     int wordlen = 5, maxvowels = 2; // declaring variables

//     // cin >> wordlen >> maxvowels; // reading inputs from user

//     int ways = calculateWays(wordlen, maxvowels); //passing values to function calculateWays

//     cout << ways; //printing ways

//     return 0;
// }

#include <bits/stdc++.h>
#define mod 1000000007
using namespace std;

int countWord(int wordLen, int maxVowels)
{
    long long dp[wordLen + 1][2];

    dp[0][1] = dp[0][0] = 1;
    dp[1][1] = 21;
    dp[1][0] = 5;

    for (int i = 2; i <= wordLen; i++)
    {

        dp[i][1] = (21 * (dp[i - 1][1] + dp[i - 1][0]) % mod) % mod;

        int k = i, j = 1, p = 5;
        dp[i][0] = 0;

        while (k > 0 && j <= maxVowels)
        {
            dp[i][0] = (dp[i][0] + (p * dp[i - j][1]) % mod) % mod;
            p = (p * 5) % mod;
            k--;
            j++;
        }
    }

    return (int)(dp[wordLen][0] + dp[wordLen][1]) % mod;
}

int main()
{
    cout << countWord(5, 2);
    return 0;
}