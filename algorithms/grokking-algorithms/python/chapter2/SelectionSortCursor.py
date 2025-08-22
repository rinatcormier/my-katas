def selection_sort(arr: list[int | float]) -> list[int | float]:
    """
    Sorts a list of numbers (integers or floats) using the selection sort algorithm.
    Returns a new sorted list (does not modify the input).
    PROMPT to Cursor Pro:
    1. "Implement selection sort in python at current directory (chapter2). Use your own files for implementation
       with suffix Cursor. Also implement all reasonable test cases."
    2. "In test case with mixed numbers use integer and float numbers. Also add test case which asserts
       that original list isn't modified."
    """
    n = len(arr)
    result = arr.copy()
    for i in range(n):
        min_idx = i
        for j in range(i+1, n):
            if result[j] < result[min_idx]:
                min_idx = j
        result[i], result[min_idx] = result[min_idx], result[i]
    return result 