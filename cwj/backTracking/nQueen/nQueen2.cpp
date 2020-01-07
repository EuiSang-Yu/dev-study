#include <iostream>
#include <math.h>

using namespace std;

void backTraking(int col);
bool check(int col);

int row[15] = {0,};
int cnt;
int n;

int main()
{
	n = 0;
	cin >> n;
	cnt = 0;

	for (int i = 0; i < n; i++) {
		row[0] = i;
		backTraking(1);
	}
	if (n == 1) { cnt++; }
	cout << cnt;
	return 0;
}

void backTraking(int col) {
	for (int i = 0; i < n; i++) {
		row[col] = i;
		if (check(col)) {
			backTraking(col + 1);
			if (col == n - 1) {
				cnt++;
				return;
			}
		}
	}
}

bool check(int col) {
	for (int i = 0; i < col; i++) {
		if (row[i] == row[col]) {
			return false;
		}
		if (abs(row[i] - row[col]) == abs(i - col)) {
			return false;
		}
	}
	return true;
}