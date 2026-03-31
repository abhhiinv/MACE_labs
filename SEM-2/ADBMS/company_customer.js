use Company

db.createCollection("Customer")

db.Customer.insertMany([
    { id: "C121", name: "Alice Johnson", email: "alice@gmail.com",   phone: "9876543210", address: "Kochi",     order_id: "ORD001", order_date: new Date("2024-06-15") },
    { id: "C122", name: "Bob Mathew",    email: "bob@gmail.com",     phone: "9876543211", address: "Thrissur",  order_id: "ORD002", order_date: new Date("2023-03-10") },
    { id: "C123", name: "Anoop Nair",    email: "anoop@gmail.com",   phone: "9876543212", address: "Kollam",    order_id: "ORD003", order_date: new Date("2024-11-20") },
    { id: "C124", name: "Divya Menon",   email: "divya@gmail.com",   phone: "9876543213", address: "Kozhikode", order_id: null,     order_date: null },
    { id: "C125", name: "Arjun Pillai",  email: "arjun@gmail.com",   phone: "9876543214", address: "Kannur",    order_id: "ORD005", order_date: new Date("2024-08-05") },
    { id: "C126", name: "Arya Thomas",   email: "arya@gmail.com",    phone: "9876543215", address: "Palakkad",  order_id: "ORD006", order_date: new Date("2022-01-10") },
    { id: "C127", name: "Anjali Dev",    email: "anjali@gmail.com",  phone: "9876543216", address: "Alappuzha", order_id: "ORD007", order_date: new Date("2024-09-01") }
])

// a) Update email where id is "C123"
db.Customer.updateOne(
    { id: "C123" },
    { $set: { email: "anoop.updated@gmail.com" } }
)

// b) Delete customers who have not placed an order in the last year
db.Customer.deleteMany({
    $or: [
        { order_date: null },
        { order_date: { $lt: new Date(new Date().setFullYear(new Date().getFullYear() - 1)) } }
    ]
})

// c) Find customers whose name starts with "A" and have placed more than 5 orders
db.Customer.find({
    name: { $regex: "^A" },
    order_id: { $exists: true, $ne: null }
}).forEach(function(c) {
    print("ID: " + c.id + " | Name: " + c.name + " | Email: " + c.email)
})