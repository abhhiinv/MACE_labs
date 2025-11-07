import React, { useState } from "react";
import Input from "./input";

const StudentList = () => {
  const [students, setStudents] = useState([
    { id: 1, name: "Abhijith" },
    { id: 2, name: "Abhinav" },
    { id: 3, name: "Abhirami" },
    { id: 4, name: "Adish" },
    { id: 5, name: "Adithya" },
  ]);

  const addStudent = (name) => {
    const newStudent = {
      id: students.length + 1,
      name,
    };
    setStudents([...students, newStudent]);
  };

  return (
    <center>
    <div className="StudentList">
      
        <h2>Student List</h2>
        <Input onAddStudent={addStudent} />
        <ul>
          {students.map((student) => (
            <table key={student.id}>
              <tbody>
                <tr>
                  <td>ID: {student.id}</td>
                  <td>NAME: {student.name}</td>
                </tr>
              </tbody>
            </table>
          ))}
        </ul>

    </div>
    </center>
  );
};

export default StudentList;
