const solution = (q) => {
  // 문자열을 배열로 바꿈
  let array = q.split("");

  const number = [];
  let temp = '';

  // 숫자인 경우 number 배열에 push
  array.forEach(ele => {
    if (!isNaN(ele)) {
      // 숫자를 붙이기 위함
      temp += ele + '';
    } else {
      if (temp) { // 비어있지 않을 때만 push
        number.push(temp);
      }
      temp = '';
    }
  });

  // 복사하여 정렬 - 원본 배열 바뀌지 않음.
  let sortedNumber = number.slice().sort((prev, next) =>  prev-next);

  // 최대값, 최소값 index get
  const a = number.indexOf(sortedNumber[0]);
  const b = number.indexOf(sortedNumber[sortedNumber.length-1]);

  return a + b;
}


const q = "ab23c4d56e78f9g12h34i5j12k45l67n89m99o1k123p456q567r768s890t67u456v345w234x23y239z";

console.log(solution(q));
