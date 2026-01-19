const con=require('./connect.js');
const sql="DELETE FROM T_db.students where rollno=5 ";
con.query(sql,(err,result)=>{
    if(err) throw err;
    console.log('Row deleted successfully');
    //con.end();
});