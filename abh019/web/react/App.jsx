import StudentList from "./student";
import Counter from "./counter";
import List from "./itemlist";
import Button from "./btn";
import blast from "./blast";
import DispGrid from "./grid";
import { useState } from "react";

function App() {
    const [rows, setRows] = useState(3);  // <-- you NEED these
    const [cols, setCols] = useState(3);
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
  /*<div >
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
  </div>*/
<div style={{ display: "flex", alignItems: "flex-start", gap: "20px" }}>
      
      {/* Control Panel Div */}
      <div  style={{ flexShrink: 0 }}>
        {/*
          *** FIX: REMOVE the className="control-panel" ***
          The inline styles already handle the layout perfectly.
        */}
        <div style={{ display: "flex", alignItems: "center", gap: "20px" }}>
          {/* Rows Label */}
          <label style={{ display: "flex", alignItems: "center", gap: "5px" }}> 
            Rows: 
            <input
              type="number"
              min="1"
              value={rows}
              onChange={(e) => setRows(Number(e.target.value))}
            />
          </label>

          {/* Cols Label */}
          <label style={{ display: "flex", alignItems: "center", gap: "5px" }}> 
            Cols: 
            <input
              type="number"
              min="1"
              value={cols}
              onChange={(e) => setCols(Number(e.target.value))}
            />
          </label>
        </div>
      </div>
      
      {/* Grid Display Div */}
      <div>
        <DispGrid rows={rows} cols={cols} />
      </div>
    </div>
  );
}

export default App;
