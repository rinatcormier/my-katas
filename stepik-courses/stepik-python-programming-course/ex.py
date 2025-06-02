line = input()
matrix = list()
while line != 'end':
    matrix.append([int(i) for i in (line.split())])
    line = input()
result = list()
for i in range(0, len(matrix)):
    result.append(list())
    for j in range(0, len(matrix[i])):
        s = 0

        if j == 0:
            s += matrix[i][len(matrix[j]) -1]
        else:
            s += matrix[i][j - 1]

        if i == 0:
            s += matrix[len(matrix) - 1][j]
        else:
            s += matrix[i - 1][j]

        if j == len(matrix[i]) - 1:
            s += matrix[i][0]
        else:
            s += matrix[i][j + 1]

        if i == len(matrix) - 1:
            s += matrix[0][j]
        else:
            s += matrix[i + 1][j]

        result[i].append(s)

for i in range(0, len(result)):
    for j in range(0, len(result[i])):
        print(result[i][j], end=' ')
    print()
