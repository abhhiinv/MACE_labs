use Student

db.createCollection("StudentDetails")

// a) Insert Records
db.StudentDetails.insertMany([
    { RollNo: 101, Name: "Anna",     Age: 20, Course: "MCA"   },
    { RollNo: 102, Name: "Catherine",Age: 21, Course: "MTECH" },
    { RollNo: 103, Name: "Denna",    Age: 22, Course: "BTECH" },
    { RollNo: 104, Name: "Sam",      Age: 25, Course: "MCA"   },
    { RollNo: 105, Name: "Karthik",  Age: 24, Course: "MCA"   },
    { RollNo: 106, Name: "Aravind",  Age: 20, Course: "MCA"   }
])

// b) List all student details in neat format
db.StudentDetails.find().forEach(function(s) {
    print("-----------------------------")
    print("RollNo : " + s.RollNo)
    print("Name   : " + s.Name)
    print("Age    : " + s.Age)
    print("Course : " + s.Course)
    print("-----------------------------")
})

// c) Find students whose name begins with "A"
db.StudentDetails.find({
    Name: { $regex: "^A" }
}).forEach(function(s) {
    print("RollNo: " + s.RollNo + " | Name: " + s.Name)
})

// d) Update course of RollNo 106 to MTECH
db.StudentDetails.updateOne(
    { RollNo: 106 },
    { $set: { Course: "MTECH" } }
)
print("Course of RollNo 106 updated to MTECH")

// e) Add DOJ field to all documents
db.StudentDetails.updateMany(
    {},
    { $set: { DOJ: "2023-08-01" } }
)
print("DOJ field added to all students")

// f) Count students who opted MCA
db.StudentDetails.aggregate([
    { $match: { Course: "MCA" } },
    { $count: "MCA_Students" }
]).forEach(function(r) {
    print("Total MCA Students: " + r.MCA_Students)
})

// g) Delete student with RollNo 104
db.StudentDetails.deleteOne({ RollNo: 104 })
print("Deleted student with RollNo: 104")

// h) Create user Mohan with readWrite role
db.createUser({
    user: "Mohan",
    pwd: "mohan123",
    roles: [{ role: "readWrite", db: "Student" }]
})