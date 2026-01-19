import React from "react";
function Stud({ name, age, course }) {
    return (
        <div >
            <h3>Name:{name}</h3>
            <p>Age:{age}</p>
            <p>Course:{course}</p>
        </div>
    );
}
export default Stud;