const getData = async () => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      //   resolve({
      //     name: "홍길동",
      //     age: 20,
      //     gender: "남자",
      //   });
      reject({
        error: "데이터 로드 실패",
        code: 500,
      });
    }, 3000);
  });
};

const printData = async () => {
//   try {
//     const res = await getData();
//     console.log(res);
//   } catch (err) {
//     console.log(err);
//     alert("통신 실패");
//   }
    getData()
      .then((result) => {
        console.log(result);
      })
      .catch((err) => {
        console.log(err);
        alert("통신 실패");
      });
};

printData();
