const con=require('./connect.js');
const sql="INSERT INTO t_db.students(rollno,name)VALUES (5,'Ram')";
con.query(sql,(err,result)=>{
    if(err) throw err;
    console.log('Record inserted successfully');
    con.end();
});
