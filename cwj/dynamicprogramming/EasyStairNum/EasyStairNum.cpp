#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;

    int dp[10][100] = { {0,}, };
    int result = 0;
    dp[0][0] = 0;
    for (int i = 1; i <= 9; i++) {
        dp[i][0] = 1;
    }
    result = 9;
    for (int i = 1; i < n; i++) {
        result = 0;
        for (int j = 0; j <= 9; j++) {
            if (j == 0) {
                dp[j][i] = (dp[j + 1][i - 1]) % 1000000000;
            }
            else if (j == 9) {
                dp[j][i] = (dp[j - 1][i - 1]) % 1000000000;
            }
            else {
                dp[j][i] = (dp[j - 1][i - 1] + dp[j + 1][i - 1]) % 1000000000;
            }
            result = (result + dp[j][i])%1000000000;
        }
    }
    cout << result;
}