const con=require('./connect.js');
const sql="UPDATE T_db.students set age=21 , course='Btech' where rollno=1 ";
con.query(sql,(err,result)=>{
    if(err) throw err;
    console.log('Row updated successfully');
    //con.end();
});