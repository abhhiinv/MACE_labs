import numpy as np
import matplotlib.pyplot as plt

# Sample Ndarray
data = np.array([25, 40, 15, 20])
labels = ['A', 'B', 'C', 'D']

# Bar chart
plt.bar(labels, data)
plt.title("Bar Chart")
plt.show()

# Horizontal bar chart
plt.barh(labels, data)
plt.title("Horizontal Bar Chart")
plt.show()

# Pie chart
plt.pie(data, labels=labels, autopct='%1.1f%%')
plt.title("Pie Chart")
plt.show()
