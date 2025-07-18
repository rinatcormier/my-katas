"""
Divide & Conquer demonstration
"""
def recursive_sum(arr: list) -> int:
    if not arr:
        return 0
    else:
        return arr[0] + recursive_sum(arr[1:])
