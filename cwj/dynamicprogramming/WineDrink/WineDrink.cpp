#include <iostream>

using namespace std;
int max(int a, int b, int * check);
int maxArray(int glass[], int n);

/*

먹는경우
12x45x
1x24x6
x23x56
12x4x6

결론
1.  n-2 + n-1 + n+1 == >> n-3 + n-2 + n
-------------------------------------
2.  n-3 + n-1 + n

점화식
glass[i - 3] + max(cost[i - 2], cost[i - 1]) + cost[i];

--------------------------------------------------------

원호 : 먹지않는경우도 생각해줘야함
cost[i] < cost[i + 1] 현재의 포도주보다 다음 포도주가 더 많으면 이전 포도주만 계산해주고 넘김?
--실패

https://mygumi.tistory.com/98 << 포도주시식 올바른 점화식


https://www.leafcats.com/72 동적계획법 점화식 구현방법

동적계획법 점화식세우는법 : 분할정복처럼 작은부분으로 나눠 풀이한 문제의 해가 전체 문제의 해여야함

*/
int main()
{
    int n;
    int glass[10000] = {0, };
    int cost[10000] = {0, };
    int check = 1;
    cin >> n;   
    

    for (int i = 0; i < n; i++) {
        cin >> cost[i];
        glass[i] = 0;
    }

    glass[0] = cost[0];
    if (cost[1] >= cost[2]) {
        glass[1] = cost[0] + cost[1];
    }
    else {
        glass[1] = cost[0];
    }
    
    glass[2] = max(cost[1] + cost[2], cost[0] + cost[2], &check);
    if (glass[1] > glass[2]) {
        glass[2] = glass[1];
        check = 1;
    }
    cout << glass[0] << ", ";
    cout << glass[1] << ", ";
    cout << glass[2] << ", ";
    for (int i = 3; i < n; i++) {
        if (check == 2) {
            if (cost[i] < cost[i + 1]) {
                glass[i] = glass[i - 3] + cost[i - 1];
            }
            else {
                glass[i] = glass[i - 3] + cost[i - 1] + cost[i];
            }
            check = 1;
        }
        if (cost[i] < cost[i + 1]) {
            glass[i] = glass[i - 3] + max(cost[i - 2], cost[i - 1], &check);
        }
        else {
            glass[i] = glass[i - 3] + max(cost[i - 2], cost[i - 1], &check) + cost[i];
        }
        
        cout << glass[i] << ", ";
    }
    
}

int max(int a, int b, int * check) {
    if (a > b) {
        *check = 2;
        return a;
    }
    else {
        return b;
    }
}

int maxArray(int glass[],int n) {
    int max = 0;
    for (int i = 0; i < n; i++) {
        if (max < glass[i]) {
            max = glass[i];
        }
    }
    return max;
}