import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import minimize

# Function to minimize
def f(x):
    return x**2 + 4*x + 5

# To store path
path = []

def callback(x):
    path.append(x)

# Perform optimization
result = minimize(f, x0=5, callback=callback)

print("Minimum at x =", result.x[0])
print("Minimum value =", f(result.x[0]))

# Plot optimization path
x_vals = np.linspace(-10, 10, 400)
y_vals = f(x_vals)

plt.plot(x_vals, y_vals)
plt.scatter(path, [f(p) for p in path])
plt.title("Optimization Path")
plt.xlabel("x")
plt.ylabel("f(x)")
plt.show()
