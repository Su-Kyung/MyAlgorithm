/*
출처: 프로그래머스 월간 코드 챌린지 시즌 1
문제: 두 개 뽑아서 더하기
난이도: Level 1
소요 시간: 00.46.54
결과: 44.4 / 100.0
*/

var numbers = [2,1,3,4,1];

function solution(numbers) {
    var answer = [];

    // 주어진 배열을 작은 수부터 정렬
    numbers.sort(function(a, b) {
        return a-b;
    });

    for (var i = 0; i < numbers.length-1; i++) {
        for(var j = i+1; j < numbers.length; j++) {
            var sum = numbers[i] + numbers[j];
            
            // 처음꺼는 무조건 추가
            if (answer.length == 0) answer[0] = sum;
            // 결과가 answer의 마지막 원소보다 큰 경우만 배열에 추가
            else if (sum > answer[answer.length-1]) answer.push(sum); 
        }
    }
    
    return answer;
}

console.log(solution([2,1,3,4,1]));