use Organization

db.createCollection("Employee")

// a) Insert Records
db.Employee.insertMany([
    { EmpId: 101, EmpName: "Ram",   Salary: 15000, Designation: "Clerk"         },
    { EmpId: 102, EmpName: "Shyam", Salary: 20000, Designation: "Administrator" },
    { EmpId: 103, EmpName: "Hari",  Salary: 10000, Designation: "Supervisor"    },
    { EmpId: 104, EmpName: "Sita",  Salary: 15000, Designation: "Clerk"         },
    { EmpId: 105, EmpName: "Rose",  Salary: 20000, Designation: "Administrator" },
    { EmpId: 106, EmpName: "Maria", Salary: 25000, Designation: "Manager"       }
])

// b) List all employee details in neat format
db.Employee.find().forEach(function(e) {
    print("-----------------------------")
    print("EmpId       : " + e.EmpId)
    print("EmpName     : " + e.EmpName)
    print("Salary      : " + e.Salary)
    print("Designation : " + e.Designation)
    print("-----------------------------")
})

// c) Find employees whose name begins with "S"
db.Employee.find({
    EmpName: { $regex: "^S" }
}).forEach(function(e) {
    print("EmpId: " + e.EmpId + " | Name: " + e.EmpName)
})

// d) Update salary of "Sita" by +1000
db.Employee.updateOne(
    { EmpName: "Sita" },
    { $inc: { Salary: 1000 } }
)
print("Salary of Sita updated by +1000")

// e) Add DOJ field to all documents
db.Employee.updateMany(
    {},
    { $set: { DOJ: "2018-06-01" } }
)
print("DOJ field added to all employees")

// f) Sum of salaries of employees with designation "Clerk"
db.Employee.aggregate([
    { $match: { Designation: "Clerk" } },
    { $group: { _id: "Clerk", TotalSalary: { $sum: "$Salary" } } }
]).forEach(function(r) {
    print("Total Salary of Clerks: " + r.TotalSalary)
})

// g) Delete employee with EmpId 106
db.Employee.deleteOne({ EmpId: 106 })
print("Deleted employee with EmpId: 106")

// h) Create user Mohan with readWrite role
db.createUser({
    user: "Mohan",
    pwd: "mohan123",
    roles: [{ role: "readWrite", db: "Organization" }]
})