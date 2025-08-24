a = [int(i) for i in (input().split())]
if len(a) == 1:
    print(a[0])
    exit(0)
b = []
a.insert(0, a[len(a) - 1])
a.append(a[1])
for i in range(1, len(a) - 1):
    b.append(a[i - 1] + a[i + 1])
print(' '.join([str(i) for i in b]))
