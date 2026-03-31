use Vehicle

db.createCollection("VehicleDetails")

// Insert Records
db.VehicleDetails.insertMany([
    { VehicleId: 1, Make: "Toyota",  Model: "Innova",  Year: 2020, Color: "White",  Price: 1800000 },
    { VehicleId: 2, Make: "Honda",   Model: "City",    Year: 2019, Color: "Silver", Price: 1200000 },
    { VehicleId: 3, Make: "Maruti",  Model: "Swift",   Year: 2021, Color: "Red",    Price: 750000  },
    { VehicleId: 4, Make: "Toyota",  Model: "Fortuner",Year: 2022, Color: "Black",  Price: 3500000 },
    { VehicleId: 5, Make: "Hyundai", Model: "Creta",   Year: 2021, Color: "Blue",   Price: 1500000 },
    { VehicleId: 6, Make: "Tata",    Model: "Nexon",   Year: 2023, Color: "White",  Price: 1000000 }
])

// b) List all vehicle details in neat format
db.VehicleDetails.find().forEach(function(v) {
    print("-----------------------------")
    print("VehicleId : " + v.VehicleId)
    print("Make      : " + v.Make)
    print("Model     : " + v.Model)
    print("Year      : " + v.Year)
    print("Color     : " + v.Color)
    print("Price     : " + v.Price)
    print("-----------------------------")
})

// c) Find vehicles whose Make begins with "T"
db.VehicleDetails.find({
    Make: { $regex: "^T" }
}).forEach(function(v) {
    print("VehicleId: " + v.VehicleId + " | Make: " + v.Make + " | Model: " + v.Model)
})