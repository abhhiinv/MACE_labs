use Company

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

// b) Try insert as readOnlyUser — will fail
// Login as readOnlyUser in terminal:
// mongosh -u readOnlyUser -p ro123 --authenticationDatabase Company

db.Employee.insertOne({
    EmpId: 6,
    EmpName: "Test User",
    DOB: "2000-01-01",
    Salary: 30000,
    Designation: "Intern"
})

// Try update as readOnlyUser — will also fail
db.Employee.updateOne(
    { EmpId: 1 },
    { $set: { Salary: 60000 } }
)