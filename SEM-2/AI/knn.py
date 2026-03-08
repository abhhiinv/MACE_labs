import math
from collections import Counter

# Training data
training_data = [
    (4, 3, "Soccer"),
    (5, 4, "Soccer"),
    (6, 4, "Soccer"),
    (7, 3, "Soccer"),
    (4, 12, "Golf"),
    (5, 14, "Golf"),
    (6, 10, "Golf"),
    (7, 10, "Golf"),
    (4, 6, "Basketball"),
    (5, 7, "Basketball"),
    (6, 7, "Basketball"),
    (7, 6, "Basketball")
]

# Points to classify
test_points = [(5, 10), (7, 4), (5.5, 7)]

def euclidean_distance(p1, p2):
    return math.sqrt((p1[0] - p2[0])**2 + (p1[1] - p2[1])**2)

def knn_predict(train, point, k):
    # Step 2: Calculate distances
    distances = [(euclidean_distance(point, (x1, x2)), label)
                 for x1, x2, label in train]
    # Step 3: Find k nearest neighbors
    k_nearest = sorted(distances, key=lambda x: x[0])[:k]
    # Step 4: Majority vote
    labels = [label for _, label in k_nearest]
    return Counter(labels).most_common(1)[0][0]

# Run for k=3 and k=5
print(f"{'Height':<8} {'Speed':<8} {'k=3':<12} {'k=5':<12}")
print("-" * 40)
for (h, s) in test_points:
    pred3 = knn_predict(training_data, (h, s), k=3)
    pred5 = knn_predict(training_data, (h, s), k=5)
    print(f"{h:<8} {s:<8} {pred3:<12} {pred5:<12}")