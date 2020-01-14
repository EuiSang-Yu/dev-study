#include <iostream>

using namespace std;

int max(int a, int b);
int main()
{
	int n;
	int numArr[100000] = { 0, };
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> numArr[i];
	}

	int result = -1000;

	for (int i = 1; i < n; i++) {
		numArr[i] = max(numArr[i - 1] + numArr[i], numArr[i]);
		result = max(numArr[i], result);
	}
	result = max(numArr[0], result);
	cout << result;
}

int max(int a, int b) {
	if(a > b){
		return a;
	}else{
		return b;
	}
}
