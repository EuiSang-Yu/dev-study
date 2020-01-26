#include <iostream>
using namespace std;
int max(int a, int b);

int main()
{
    int n;
    cin >> n;

    int dp[500][500] = { 0, };
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            cin >> dp[i][j];
        }
    }

    for (int i = n - 2; i >= 0; i--) {
        for (int j = 0; j <= i; j++) {
            dp[i][j] = max(dp[i + 1][j], dp[i + 1][j + 1]) + dp[i][j];
        }
    }
    cout << dp[0][0];
}

int max(int a, int b) {
    if (a > b) {
        return a;
    }
    return b;
}