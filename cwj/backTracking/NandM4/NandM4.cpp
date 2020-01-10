#include <iostream>
using namespace std;

void backTraking(int n, int m, int col);

int* numArr;

int main() {
	int n = 0, m = 0;
	cin >> n >> m;
	numArr = new int[m];

	backTraking(n, m, 0);
	return 0;
}

void backTraking(int n, int m, int col) {
	for (int i = 0; i < n; i++) {
		if (col < m && (col == 0 || numArr[col - 1] <= i + 1)) {
			numArr[col] = i + 1;

			backTraking(n, m, col + 1);

			if (col == m - 1) {
				for (int i = 0; i < m; i++) {
					cout << numArr[i] << " ";
				}
				cout << "\n";
			}
		}
	}
}