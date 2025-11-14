import StudentList from "./student";
import Counter from "./counter";
import List from "./itemlist";
import Button from "./btn";
import blast from "./blast";

function App() {
  return (
    /*<div>
      <h1 style={{textAlign:"center",marginLeft:"39.5rem"}}>React counter App</h1>
      <Counter />
    </div>*/
    /*<div style={{marginLeft:"50rem"}}>
      <StudList />
    </div>*/
    /*<div>
      <List />
    </div>*/
  <div >
   <Button text="Click Me" onClick={() => alert("Button clicked!")} />

   <Button text="Don't Click" onClick={() => alert("You never listen :/")} />

   <Button text="Never Click" onClick={blast} />
   <div
        id="output"
        style={{
          marginTop: "30px",
          fontSize: "2rem",
          textAlign: "center"
        }}
      ></div>
  </div>
  );
}

export default App;
