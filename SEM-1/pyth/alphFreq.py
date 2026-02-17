word = input("Enter a word: ")
freq = {}
for ch in word:
    freq[ch] = freq.get(ch, 0) + 1
print("Frequency:", freq)
