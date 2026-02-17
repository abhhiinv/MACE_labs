items = input("Enter items (space separated): ").split()
x = input("Enter item to search: ")
print("Available" if x in items else "Not Available")