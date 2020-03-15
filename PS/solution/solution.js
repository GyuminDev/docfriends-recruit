const solution = (q) => {
  let array = q.split("");

  const number = [];
  let temp = '';

  array.forEach(ele => {
    if (!isNaN(ele)) {
      temp += ele + '';
    } else {
      if (temp) {
        number.push(temp);
      }
      temp = '';
    }
  });

  let sortedNumber = number.slice().sort((prev, next) =>  prev-next);

  const a = number.indexOf(sortedNumber[0]);
  const b = number.indexOf(sortedNumber[sortedNumber.length-1]);

  return a + b;
}


const q = "ab23c4d56e78f9g12h34i5j12k45l67n89m99o1k123p456q567r768s890t67u456v345w234x23y239z";

console.log(solution(q));
