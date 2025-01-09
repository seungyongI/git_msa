const doA = () => {
  const promise = new Promise((resolve, reject) => {
    setTimeout(() => {
      // resolve("Success!");
      reject("Failed!");
    }, 3000);
  });
  return promise;
};

// console.log(promise);

doA()
  .then((result) => console.log(result))
  .catch((result2) => console.log(result2));
