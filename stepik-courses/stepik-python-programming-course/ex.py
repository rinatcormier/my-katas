n = int(input())

spiral = [[0] * n for _ in range(n)]
direction = "right"
currentValue = 1
lastValue = n ** 2
i, j = 0, 0
while currentValue <= lastValue:
    if direction == "right":
        while j < n and spiral[i][j] == 0:
            spiral[i][j] = currentValue
            j += 1
            currentValue += 1
        i += 1
        j -= 1
        direction = "down"
    elif direction == "down":
        while i < n and spiral[i][j] == 0:
            spiral[i][j] = currentValue
            i += 1
            currentValue += 1
        i -= 1
        j -= 1
        direction = "left"
    elif direction == "left":
        while j >= 0 and spiral[i][j] == 0:
            spiral[i][j] = currentValue
            j -= 1
            currentValue += 1
        i -= 1
        j += 1
        direction = "up"
    elif direction == "up":
        while i >= 0 and spiral[i][j] == 0:
            spiral[i][j] = currentValue
            i -= 1
            currentValue += 1
        i += 1
        j += 1
        direction = "right"

for i in range(0, len(spiral)):
    for j in range(0, len(spiral[i])):
        print(spiral[i][j], end=' ')
    print()
