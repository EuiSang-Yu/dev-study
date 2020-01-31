#include <iostream>
using namespace std;
int max(int a, int b);
int main()
{
	int n;
	cin >> n;
	int cost[300] = { 0, };
	int dp[300] = { 0, };
	for (int i = 0; i < n; i++) {
		cin >> cost[i];
	}

	dp[0] = cost[0];
	dp[1] = cost[0] + cost[1];
	dp[2] = max(cost[0],cost[1])+cost[2];

	for (int i = 3; i < n; i++) {
		dp[i] = max(cost[i - 1] + dp[i - 3], dp[i - 2]) + cost[i];
	}
	cout << dp[n-1];
}


int max(int a, int b) {
	if (a > b) {
		return a;
	}
		return b;
}