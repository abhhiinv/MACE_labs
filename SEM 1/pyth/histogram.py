import numpy as np
import matplotlib.pyplot as plt

# Generate random samples
samples = np.random.normal(loc=10, scale=3, size=1000)

# Plot histogram
plt.hist(samples, bins=30)     # no color/style specified
plt.title("Normal Distribution (Mean=10, SD=3)")
plt.xlabel("Value")
plt.ylabel("Frequency")
plt.show()
