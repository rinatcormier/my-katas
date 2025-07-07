def binary_search(sorted_items: list, seeking_item: int):
    low = 0
    high = len(sorted_items) - 1
    while low <= high:
        mid = (low + high) // 2
        guess = sorted_items[mid]
        if guess == seeking_item:
            return mid
        if guess < seeking_item:
            low = mid + 1
        else:
            high = mid - 1
    return None
