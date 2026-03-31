use Company

db.createCollection("Employee")

db.Employee.insertMany([
    { EmpId: 1, EmpName: "Arun Kumar",     DOB: "1990-05-15", Salary: 55000,  Designation: "Software Engineer" },
    { EmpId: 2, EmpName: "Priya Nair",     DOB: "1988-11-22", Salary: 72000,  Designation: "Senior Engineer"   },
    { EmpId: 3, EmpName: "Suresh Menon",   DOB: "1995-03-10", Salary: 45000,  Designation: "Junior Engineer"   },
    { EmpId: 4, EmpName: "Sneha Thomas",   DOB: "1992-07-30", Salary: 90000,  Designation: "Team Lead"         },
    { EmpId: 5, EmpName: "Santhosh Kumar", DOB: "1985-01-18", Salary: 120000, Designation: "Manager"           }
])

// a) Create multiple users with different roles
db.createUser({
    user: "adminUser",
    pwd: "admin123",
    roles: [{ role: "dbAdmin", db: "Company" }]
})

db.createUser({
    user: "readWriteUser",
    pwd: "rw123",
    roles: [{ role: "readWrite", db: "Company" }]
})

db.createUser({
    user: "readOnlyUser",
    pwd: "ro123",
    roles: [{ role: "read", db: "Company" }]
})

// b) Login as readWriteUser and perform insert and update
// mongosh -u readWriteUser -p rw123 --authenticationDatabase Company

db.Employee.insertOne({
    EmpId: 6,
    EmpName: "Neeraj Pillai",
    DOB: "2000-03-15",
    Salary: 35000,
    Designation: "Intern"
})

db.Employee.updateOne(
    { EmpId: 1 },
    { $set: { Salary: 60000 } }
)

print("Insert and Update successful as readWriteUser")
