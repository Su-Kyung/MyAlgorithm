#include <stdio.h>
using namespace std;

int main() {

	int T;
	scanf("%d", &T);

	int memo[15][15];
	memo[0][0] = 0;
	
	for (int i = 1; i < 15; i++) {
		memo[i][0] = 0;
		memo[0][i] = i;
	}
	for (int i = 1; i < 15; i++) {
		for (int j = 1; j < 15; j++) {
			memo[i][j] = memo[i][j - 1] + memo[i - 1][j];
			//printf("%d ", memo[i][j]);
		}
		//printf("\n");
	}

	for (int tc = 0; tc < T; tc++) {
		int k, n;
		scanf("%d\n%d", &k, &n);

		printf("%d\n", memo[k][n]);
	}

	return 0;
}