const con = require('./connection_1.js');
const cr_TB =`
CREATE TABLE IF NOT EXISTS t_db.students(
    rollno INT PRIMARY KEY,
    name VARCHAR(15)
)
`;
con.query(cr_TB,(err)=>{
    if(err) throw err;
    console.log('Table students created');
});