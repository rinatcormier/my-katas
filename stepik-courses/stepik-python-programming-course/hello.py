s = input()
current = s[0]
counter = 0
result = ''
for c in s:
    if current == c:
        counter += 1
    else:
        result += (current + str(counter))
        current = c
        counter = 1
result += (current + str(counter))
print(result)
