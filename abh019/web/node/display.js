const con = require('./connection_1.js');
const sql="SELECT * FROM t_db.students";
con.query(sql,(err,result)=>{
    if(err) throw err;
    console.log('Students Records:');
    console.tables(result);
    con.end();
});