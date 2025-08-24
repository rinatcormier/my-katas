def selection_sort(lst: list):
    """
    Implementation of selection sort algorithm.
    This algorithm sorts a list by repeatedly finding the minimum element
    from the unsorted part and putting it at the beginning.
    
    Args:
        lst: A list to be sorted
        
    Returns:
        A new sorted list

    PROMPT to Junie:
    1. "Implement selection sort in python at current directory (chapter2). Do not use and do
       not modify my files (SelectionSort.py and SelectionSortTest.py). Use your own files with suffix AI.
       Also implement all reasonable test cases to your selection sort implementation."
    2. "remove redundant comments from code (under redundant I mean those which explain obvious things)"
    """
    input_list = lst.copy()
    result = []
    
    while input_list:
        min_index = find_min_index(input_list)
        result.append(input_list.pop(min_index))
    
    return result

def find_min_index(lst: list):
    """
    Find the index of the minimum element in a list.
    
    Args:
        lst: A list to search in
        
    Returns:
        The index of the minimum element
    """
    if not lst:
        return None
    
    min_index = 0
    min_value = lst[0]
    
    for i in range(1, len(lst)):
        if lst[i] < min_value:
            min_value = lst[i]
            min_index = i
            
    return min_index