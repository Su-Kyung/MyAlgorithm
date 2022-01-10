#include <iostream>
#include <stdio.h>
using namespace std;

int main()
{
	int a, b = 1, gap = 0;

	cin >> a;

	while (a > b) {
		b += ++gap * 6;
	}

	cout << gap + 1;

	return 0;
}