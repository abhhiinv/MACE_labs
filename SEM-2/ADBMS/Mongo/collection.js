// 1. Create Database and Collection, Insert Records

use CompanyDB

db.createCollection("Employee")

db.Employee.insertMany([
    {
        EmpId: 1,
        EmpName: "Arun Kumar",
        DOB: "1990-05-15",
        Salary: 55000,
        Designation: "Software Engineer"
    },
    {
        EmpId: 2,
        EmpName: "Priya Nair",
        DOB: "1988-11-22",
        Salary: 72000,
        Designation: "Senior Engineer"
    },
    {
        EmpId: 3,
        EmpName: "Rahul Menon",
        DOB: "1995-03-10",
        Salary: 45000,
        Designation: "Junior Engineer"
    },
    {
        EmpId: 4,
        EmpName: "Sneha Thomas",
        DOB: "1992-07-30",
        Salary: 90000,
        Designation: "Team Lead"
    },
    {
        EmpId: 5,
        EmpName: "Vijay Krishnan",
        DOB: "1985-01-18",
        Salary: 120000,
        Designation: "Manager"
    }
])

// 2. Fetch All Records

db.Employee.find()

// 3. List All Details in Neat Format

db.Employee.find().pretty()

// 4. List Details of a Specific Employee (Search by Name)

db.Employee.find({ EmpName: "Priya Nair" }).pretty()