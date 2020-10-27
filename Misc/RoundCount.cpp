#include <bits/stdc++.h>
using namespace std;
vector<vector<int>> ans;
///I am assuming while finding number of paths we will not move backward pos that is from ith to i-1,i-2....i-k
void backtrack(vector<int> &path, int pos, int fuel, vector<int> &arr)
{
    if (fuel < 0)
        return;
    if (pos > arr.size())
        return;
    if (pos == arr.size())
    {
        ans.push_back(path);
        return;
    }
    for (int i = pos; i < arr.size(); i++)
    {
        int prevpos = path.back();
        path.push_back(i);
        int curfuel = abs(arr[i] - arr[prevpos]);
        backtrack(path, i + 1, fuel - curfuel, arr);
        path.pop_back();
    }
}
/// dfs using memoization to print number of paths

int dp[100][100];
int dfs(int fuel, int pos, vector<int> &arr, int lastpos)
{
    if (fuel < 0)
        return 0;
    if (pos == arr.size())
    {
        return 1;
    }
    if (dp[fuel][pos] != -1)
        return dp[fuel][pos];
    int ans = 0;
    for (int i = pos; i < arr.size(); i++)
    {
        int curfuel = abs(arr[i] - arr[lastpos]);
        ans += dfs(fuel - curfuel, i + 1, arr, i);
    }
    return dp[fuel][pos] = ans;
}
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        vector<int> a(n);
        for (int i = 0; i < n; i++)
        {
            cin >> a[i];
        }
        ///to print paths
        int fuel;
        cin >> fuel;
        vector<int> path = {0};
        backtrack(path, 1, fuel, a);
        for (auto b : ans)
        {
            for (auto val : b)
            {
                cout << val << " ";
            }
            cout << endl;
        }
        ///to print number of paths
        memset(dp, -1, sizeof(dp));

        cout << dfs(fuel, 1, a, 0) << endl;
    }
}