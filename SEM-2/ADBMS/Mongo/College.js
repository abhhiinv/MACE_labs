// Create Database and Insert Records
use CollegeDB

db.createCollection("Student")

db.Student.insertMany([
    { _Id: 1, Name: "Arun Kumar",    Age: 21, Gender: "Male",   Department: "Computer Science", Sub1: 85, Sub2: 90, Attendance: 88 },
    { _Id: 2, Name: "Priya Nair",    Age: 23, Gender: "Female", Department: "Electronics",      Sub1: 72, Sub2: 68, Attendance: 76 },
    { _Id: 3, Name: "Rahul Menon",   Age: 22, Gender: "Male",   Department: "Mechanical",       Sub1: 91, Sub2: 88, Attendance: 92 },
    { _Id: 4, Name: "Sneha Thomas",  Age: 20, Gender: "Female", Department: "Civil",            Sub1: 60, Sub2: 75, Attendance: 80 },
    { _Id: 5, Name: "Vijay Krishna", Age: 24, Gender: "Male",   Department: "Computer Science", Sub1: 83, Sub2: 79, Attendance: 70 }
])

// 1. Students who scored more than 80 in BOTH subjects
db.Student.find({
    Sub1: { $gt: 80 },
    Sub2: { $gt: 80 }
}).pretty()

// 2. Students in "Computer Science" OR older than 22
db.Student.find({
    $or: [
        { Department: "Computer Science" },
        { Age: { $gt: 22 } }
    ]
}).pretty()

// 3. Students NOT in "Electronics" department
db.Student.find({
    Department: { $ne: "Electronics" }
}).forEach(function(s) {
    print("Name: " + s.Name + " | Dept: " + s.Department)
})

// 4. Students who neither scored above 80 in Sub1 nor have attendance more than 85
db.Student.find({
    $nor: [
        { Sub1: { $gt: 80 } },
        { Attendance: { $gt: 85 } }
    ]
}).forEach(function(s) {
    print("Name: " + s.Name + " | Sub1: " + s.Sub1 + " | Attendance: " + s.Attendance)
})

// 5. Students neither in "Mechanical" nor in "Civil"
db.Student.find({
    Department: { $nin: ["Mechanical", "Civil"] }
}).forEach(function(s) {
    print("Name: " + s.Name + " | Dept: " + s.Department)
})