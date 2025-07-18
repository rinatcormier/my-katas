"""
Divide & Conquer demonstration
"""
def recursive_max(arr: list):
    if not arr:
        return None
    if len(arr) == 1:
        return arr[0]
    else:
        guess_max = recursive_max(arr[1:])
        if arr[0] > guess_max:
            return arr[0]
        else:
            return guess_max
