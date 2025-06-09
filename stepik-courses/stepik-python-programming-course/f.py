def modify_list(lst):
    for i in range(len(lst) - 1, -1, -1):
        if lst[i] % 2 != 0:
            lst.pop(i)
    for i in range(len(lst)):
        lst[i] = int(lst[i] / 2)

l = [5, 4]
modify_list(l)
print(l)
