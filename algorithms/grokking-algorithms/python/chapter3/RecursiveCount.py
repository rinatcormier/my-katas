"""
Divide & Conquer demonstration
"""
def recursive_count(arr: list) -> int:
    if not arr:
        return 0
    else:
        return 1 + recursive_count(arr[1:])
