// backTracking.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>

using namespace std;

void backTraking(int n, int cnt);
void setX(int n, int y, bool visit);
void setY(int n, int x, bool visit);
void setXY(int n, int x, int y, bool visit);

bool** board;
int totalcnt;

int main()
{
    int n = 0;
    cin >> n;
	totalcnt = 0;
    board = new bool*[n];
    for (int i = 0; i < n; i++) {
        board[i] = new bool[n];
    }

	for (int x = 0; x < n; x++) {
		for (int y = 0; y < n; y++) {
			board[x][y] = false;
		}
	}
	backTraking(n, 0);

    return 0;
}

void backTraking(int n, int cnt) {
	for (int x = 0; x < n; x++) {
		for (int y = 0; y < n; y++) {
			if (!board[x][y]) {
				setX(n, y, true);
				setY(n, x, true);
				setXY(n, x, y, true);

				backTraking(n, cnt+1);
				setX(n, y, false);
				setY(n, x, false);
				setXY(n, x, y, false);

				if (cnt == n - 1) {
					totalcnt++;
					cout << totalcnt;
				}
			}
		}
	}
}

void setX(int n, int y, bool visit) {
	for (int x = 0; x < n; x++) {
		board[x][y] = visit;
	}
}

void setY(int n, int x, bool visit) {
	for (int y = 0; y < n; y++) {
		board[x][y] = visit;
	}
}

void setXY(int n, int x, int y, bool visit) {
	while (!((x == 0) || (y == 0))) {
		x--;
		y--;
	}
	while (x<n-1&&y<n-1){
		y++;
		x++;
		board[x][y] = visit;
	}
}