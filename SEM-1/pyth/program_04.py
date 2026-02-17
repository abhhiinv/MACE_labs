colors = input("Enter colors separated by commas: ")

# Split into list
color_list = colors.split(",")

# Remove extra spaces
color_list = [c.strip() for c in color_list]

# Print alternate colors
print("Result (b):", color_list[::2])
