#include <iostream>

using namespace std;

int min(int a, int b);

int main()
{
	int n;
	int r[1000] = { 0, }, g[1000] = { 0, }, b[1000] = { 0, };
	int r_cost[1000] = { 0, }, g_cost[1000] = { 0, }, b_cost[1000] = { 0, };
	int check = 0;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> r_cost[i] >> g_cost[i] >> b_cost[i];
	}

	r[0] = r_cost[0];
	g[0] = g_cost[0];
	b[0] = b_cost[0];
	
	for (int i = 1; i < n; i++) {
		r[i] = min(g[i - 1], b[i - 1]) + r_cost[i];
		g[i] = min(r[i - 1], b[i - 1]) + g_cost[i];
		b[i] = min(g[i - 1], r[i - 1]) + b_cost[i];
	}

	cout << min(r[n-1], min(g[n-1], b[n-1]));
}

int min(int a, int b) {
	if (a < b) {
		return a;
	}
	else {
		return b;
	}
}
