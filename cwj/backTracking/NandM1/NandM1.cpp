#include <iostream>

using namespace std;

void backTraking(int n, int m, int col);

int* numArr;
bool* visitArr;

int main() {
	int n = 0, m = 0;
	cin >> n >> m;
	numArr = new int[m];
	visitArr = new bool[n];

	for (int i = 0; i < n; i++) {
		visitArr[i] = false;
	}

	backTraking(n, m, 0);
	return 0;
}

void backTraking(int n, int m, int col) {
	for (int i = 0; i < n; i++) {
		if (!visitArr[i]) {
			visitArr[i] = true;
			numArr[col] = i + 1;

			backTraking(n, m, col + 1);
			visitArr[i] = false;

			if (col == m - 1) {
				for (int i = 0; i < m; i++) {
					cout << numArr[i] << " ";
				}
				cout << "\n";
			}
		}
	}
}