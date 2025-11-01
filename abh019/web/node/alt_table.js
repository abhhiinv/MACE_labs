const con = require('./connect.js');
const al_TB =`
ALTER TABLE T_db.students
    ADD age INT,
    ADD course VARCHAR(30)
`;
con.query(al_TB,(err)=>{
    if(err) throw err;
    console.log('Table altered');
});