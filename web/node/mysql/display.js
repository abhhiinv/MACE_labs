const con = require('./connect.js');
const sql="SELECT * FROM T_db.students";
con.query(sql,(err,result)=>{
    if(err) throw err;
    console.log('Students Records:');
    console.tables(result);
    con.end();
});