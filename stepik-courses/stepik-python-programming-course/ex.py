# https://stepik.org/lesson/3369/step/11?unit=952
n = int(input())

if n == 1:
    print("1")

if n == 2:
    print("1 2")
    print("4 3")

spiral = [[0] * n for k in range(n)]
if n > 2:
    current = 1
    for j in range(n):
        spiral[0][j] = current
        current += 1
    for i in range(1, n):
        spiral[i][n - 1] = current
        current += 1
    for j in range(n - 2, 0, -1):
        spiral[n - 1][j] = current
        current += 1
    last = n * n + 1
    i = n - 1
    j = 0
    direction = "up"
    while current < last:
        pass # todo
