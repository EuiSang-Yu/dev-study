#include <iostream>
using namespace std;
int div3(int x);
int div2(int x);
int min(int a, int b);

int dp[1000000] = { 0, };
int main()
{
    int n;
    cin >> n;
   
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;

    for (int i = 3; i < n; i++) {
        dp[i] = min(min(dp[div3(i + 1) - 1], dp[div2(i + 1) - 1]), dp[i - 1]) + 1;
    }
    cout << dp[n - 1];
}

int div3(int x) {
    if (x % 3 == 0) {
        return x / 3;
    }
    return x - 1;
}

int div2(int x) {
    if (x % 2 == 0) {
        return x / 2;
    }
    return x - 1;
}

int min(int a, int b) {
    if (a < b) {
        return a;
    }
    else {
        return b;
    }
}

//X가 3으로 나누어떨어지는경우 3으로나눔 
//X가 2로 나누어 떨어지면, 2로 나눈다.
//1을 뺀다

//실패1
//int main()
//{
//    int n;
//    cin >> n;
//    int dp[2][1000] = { 0, };
//
//    
//    dp[0][0] = div3(n);
//    dp[1][0] = div2(n);
//    int cnt = 0;
//    while (!min(dp[0][cnt], dp[1][cnt])==1) {
//        cnt++;
//        dp[0][cnt] = div3(min(dp[0][cnt - 1],dp[1][cnt-1]));
//        dp[1][cnt] = div2(min(dp[0][cnt - 1],dp[1][cnt-1]));
//        if (dp[0][cnt] == 1 || dp[1][cnt] == 1) {
//            break;
//        }
//    }
//    cout << min(dp[0][cnt], dp[1][cnt]);
//}

//실패2
//int main()
//{
//    int n;
//    cin >> n;
//    int dp[3][1000] = { 0, };
//    int i = 1;
//    dp[0][0] = div2(n);
//    dp[1][0] = div3(n);
//    dp[2][0] = n - 1;
//
//    while (true) {
//        
//        dp[0][i] = div2(min(dp[0][i - 1], dp[1][i - 1]));
//        dp[1][i] = div3(min(dp[0][i - 1], dp[1][i - 1]));
//        
//
//        if (min(dp[0][i], dp[1][i]) == 0) {
//            break;
//        }
//        i++;
//    }
//    cout << i;
//}
