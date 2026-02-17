text = input("Enter a string: ").split()
max_len = max(len(w) for w in text)
longest = [w for w in text if len(w) == max_len]
print("Longest word length:", max_len)
if len(longest) > 1:
    print("BINGO")