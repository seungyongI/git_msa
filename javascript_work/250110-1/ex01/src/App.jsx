import { useState } from "react";
import "./App.css";

function App() {
  // ref();
  const [aa, setAA] = useState(10);
  const [bb, bbb] = doA();

  const clickA = () => {
    setAA(aa + 1);
    console.log(aa);
  };

  const doA = () => {
    return [
      10,
      () => {
        console.log("doA");
      },
    ];
  };

  console.log("랜더링");
  console.log("bb = " + bb);
  console.log("bbb = " + bbb);

  return (
    <>
      <h1>Clean</h1>
      <h1>{aa}</h1>
      <button onClick={clickA}>Push</button>
    </>
  );
}

export default App;
