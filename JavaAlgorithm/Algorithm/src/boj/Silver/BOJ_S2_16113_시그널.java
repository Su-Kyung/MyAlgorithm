package boj.Silver;
// S2 시그널 (구현,문자열)
// solved
// 범위 확인 잘 하자... N이 5인경우를 간과함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S2_16113_시그널 {
	static final String ZERO 	= "####.##.##.####";
	static final String ONE 	= ".#..#..#..#..#.";
	static final String TWO 	= "###..#####..###";
	static final String THREE 	= "###..####..####";
	static final String FOUR 	= "#.##.####..#..#";
	static final String FIVE 	= "####..###..####";
	static final String SIX 	= "####..####.####";
	static final String SEVEN 	= "###..#..#..#..#";
	static final String EIGHT 	= "####.#####.####";
	static final String NINE 	= "####.####..####";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine().trim()); // 시그널의 길이
		int W = N / 5;

		String str = br.readLine().trim();
		if(N == 5) {
			System.out.println(1);
			return;
		}
		
		char[][] signal = new char[5][W];
		for (int i = 0, j = 0; i < 5; i++, j += W) {
			signal[i] = str.substring(j, j + W).toCharArray();
		}

		int start = 0;
		if (signal[0][0] == '#' && signal[1][0] == '#' && signal[2][0] == '#' && signal[3][0] == '#' && signal[4][0] == '#'
				&& signal[0][1] == '.' && signal[1][1] == '.' && signal[2][1] == '.' && signal[3][1] == '.' && signal[4][1] == '.') {
			start = 1;
			sb.append(1);
		}

		for (int i = start; i < W - 2;) {
			StringBuilder s = new StringBuilder();
			for(int j = 0; j < 5; j++) {
				s.append(signal[j][i]).append(signal[j][i + 1]).append(signal[j][i + 2]);
			}
			
			switch(s.toString()) {
			case ZERO:
				i+=3;
				sb.append(0);
				break;
			case ONE:
				i+=2;
				sb.append(1);
				break;
			case TWO:
				i+=3;
				sb.append(2);
				break;
			case THREE:
				i+=3;
				sb.append(3);
				break;
			case FOUR:
				i+=3;
				sb.append(4);
				break;
			case FIVE:
				i+=3;
				sb.append(5);
				break;
			case SIX:
				i+=3;
				sb.append(6);
				break;
			case SEVEN:
				i+=3;
				sb.append(7);
				break;
			case EIGHT:
				i+=3;
				sb.append(8);
				break;
			case NINE:
				i+=3;
				sb.append(9);
				break;
			default:
				i++;
				break;
			}
			start = i;
		}

		if(start == W - 2) {
			if(signal[0][++start] == '#' && signal[1][start] == '#' && signal[2][start] == '#' && signal[3][start] == '#' && signal[4][start] == '#'
					&& signal[0][--start] == '.' && signal[1][start] == '.' && signal[2][start] == '.' && signal[3][start] == '.' && signal[4][start] == '.')
				sb.append(1);
		} else if(start == W - 1) {
			if(signal[0][start] == '#' && signal[1][start] == '#' && signal[2][start] == '#' && signal[3][start] == '#' && signal[4][start] == '#'
					&& signal[0][--start] == '.' && signal[1][start] == '.' && signal[2][start] == '.' && signal[3][start] == '.' && signal[4][start] == '.')
				sb.append(1);
		}

		System.out.println(sb.toString());
	}
}

/*
30
###.#.#.#.#.###.#.#.#.#.###.#.

25
###.##.#.####.##.#.####.#

35
###.#.##.#.#.####.#.##.#.#.####.#.#

40
###..#..#.#..#..###..#..#.#..#..###..#..

30
###..##.#..####..##.#..####..#

35
###..#.#.#..#.###..#.#.#..#.###..#.

30
#..####..#.##..####..#.##..###

35
#.#.####.#.#..###.###..#...#..#.###

185
###.#.###.###.#.#.###.###.###.###.####.#.#...#...#.#.#.#...#.....#.#.#.#.##.#.#.###.###.###.###.###...#.###.####.#.#.#.....#...#...#.#.#...#.#.#...####.#.###.###...#.###.###...#.###.###

190
###.#.###.###.#.#.###.###.###.###.###.#.#.#...#...#.#.#.#...#.....#.#.#.#.#.#.#.#.###.###.###.###.###...#.###.###.#.#.#.#.....#...#...#.#.#...#.#.#...#.###.#.###.###...#.###.###...#.###.###.

 */