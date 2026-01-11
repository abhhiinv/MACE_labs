const mysql = require('mysql2');

const con = mysql.createConnection({
	host: 'localhost',
	user: 'root',
	password: 'Kichu@2004',
});

con.connect((err)=> {
	if (err) throw err;
	console.log("Connected");
	
	con.query("CREATE DATABASE IF NOT EXISTS StudentDB" , (err) => {
		if (err) throw err;
		console.log("Database created");
		
		con.changeUser({ database: "StudentDB" }, (err) => {
			if (err) throw err;
			
			const createTable = `
				CREATE TABLE IF NOT EXISTS students(
					rollno INT PRIMARY KEY,
					name VARCHAR(30),
					age INT
				)
			`;

			con.query(createTable, (err) => {
				if (err) throw err;
				console.log("Table created");
				
				const insert = "INSERT INTO students VALUES (1,'Abhi',21)";

				con.query(insert, (err) => {
					if (err) throw err;
					console.log("Record inserted");
					
					const update = "UPDATE students SET age=21 WHERE rollno=1";
					
					con.query(update, (err)=> {
						if (err) throw err;
						console.log("Record updated");
                        
                        con.query("SELECT * FROM students", (err , result) => {
                            if (err) throw err;
                            console.log("Records");
                            console.table(result);
                            
                            con.query("DELETE FROM students WHERE rollno=1", (err) => {
                                if (err) throw err;
                                console.log("Record deleted");

                                con.end();
                            });
                        });
                    });
                });
            });
        });
    });
});