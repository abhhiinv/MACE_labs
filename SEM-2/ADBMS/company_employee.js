use Company

db.createCollection("Employee")

db.Employee.insertMany([
    { EmpId: 1, EmpName: "Arun Kumar",    DOB: "1990-05-15", Salary: 55000,  Designation: "Software Engineer" },
    { EmpId: 2, EmpName: "Priya Nair",    DOB: "1988-11-22", Salary: 72000,  Designation: "Senior Engineer"   },
    { EmpId: 3, EmpName: "Suresh Menon",  DOB: "1995-03-10", Salary: 45000,  Designation: "Junior Engineer"   },
    { EmpId: 4, EmpName: "Sneha Thomas",  DOB: "1992-07-30", Salary: 90000,  Designation: "Team Lead"         },
    { EmpId: 5, EmpName: "Santhosh Kumar",DOB: "1985-01-18", Salary: 120000, Designation: "Manager"           }
])

// a) Find employees whose EmpName starts with "S"
db.Employee.find({
    EmpName: { $regex: "^S" }
}).forEach(function(e) {
    print("EmpId: " + e.EmpId + " | Name: " + e.EmpName + " | Designation: " + e.Designation)
})

// b) Increase salary by 1000 for user-specified EmpName
var empName = "Sneha Thomas"
db.Employee.updateOne(
    { EmpName: empName },
    { $inc: { Salary: 1000 } }
)
print("Salary updated for: " + empName)

// c) Add new field DOJ to all documents
db.Employee.updateMany(
    {},
    { $set: { DOJ: "2020-01-01" } }
)
print("DOJ field added to all documents")

// d) Fetch all records
db.Employee.find().forEach(function(e) {
    print("-----------------------------")
    print("EmpId       : " + e.EmpId)
    print("EmpName     : " + e.EmpName)
    print("DOB         : " + e.DOB)
    print("Salary      : " + e.Salary)
    print("Designation : " + e.Designation)
    print("DOJ         : " + e.DOJ)
    print("-----------------------------")
})

// e) Delete document by user-specified EmpId
var empId = 3
db.Employee.deleteOne({ EmpId: empId })
print("Deleted employee with EmpId: " + empId)