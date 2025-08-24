def selection_sort(lst: list):
    sorted_lst = []
    for i in range(len(lst)):
        sorted_lst.append(lst.pop(find_smallest(lst)))
    return sorted_lst

def find_smallest(lst: list):
    smallest_item = lst[0]
    smallest_item_index = 0
    for i in range(1, len(lst)):
        if lst[i] < smallest_item:
            smallest_item = lst[i]
            smallest_item_index = i
    return smallest_item_index
