import unittest
import SelectionSortAI

class SelectionSortAITest(unittest.TestCase):
    """
    Test cases for the SelectionSortAI implementation.
    """
    
    def test_sort_empty_list(self):
        """Test sorting an empty list."""
        self.assertListEqual(SelectionSortAI.selection_sort([]), [])
    
    def test_sort_one_item(self):
        """Test sorting a list with one item."""
        self.assertListEqual(SelectionSortAI.selection_sort([1]), [1])
    
    def test_sort_ordered_list(self):
        """Test sorting an already ordered list."""
        self.assertListEqual(SelectionSortAI.selection_sort([1, 2, 3, 4, 5]), [1, 2, 3, 4, 5])
    
    def test_sort_unordered_list(self):
        """Test sorting an unordered list."""
        self.assertListEqual(SelectionSortAI.selection_sort([3, 2, 5, 1, 4]), [1, 2, 3, 4, 5])
    
    def test_sort_reversed_list(self):
        """Test sorting a reversed list."""
        self.assertListEqual(SelectionSortAI.selection_sort([5, 4, 3, 2, 1]), [1, 2, 3, 4, 5])
    
    def test_sort_duplicate_values(self):
        """Test sorting a list with duplicate values."""
        self.assertListEqual(SelectionSortAI.selection_sort([3, 1, 3, 2, 1]), [1, 1, 2, 3, 3])
    
    def test_sort_negative_numbers(self):
        """Test sorting a list with negative numbers."""
        self.assertListEqual(SelectionSortAI.selection_sort([-3, 5, -1, 0, 2]), [-3, -1, 0, 2, 5])
    
    def test_sort_mixed_types(self):
        """Test sorting a list with mixed types (strings)."""
        self.assertListEqual(SelectionSortAI.selection_sort(["banana", "apple", "cherry"]), ["apple", "banana", "cherry"])
    
    def test_sort_large_list(self):
        """Test sorting a larger list."""
        input_list = list(range(100, 0, -1))  # [100, 99, ..., 1]
        expected = list(range(1, 101))  # [1, 2, ..., 100]
        self.assertListEqual(SelectionSortAI.selection_sort(input_list), expected)
    
    def test_original_list_unchanged(self):
        """Test that the original list is not modified."""
        original = [5, 3, 1, 4, 2]
        original_copy = original.copy()
        SelectionSortAI.selection_sort(original)
        self.assertListEqual(original, original_copy)

if __name__ == "__main__":
    unittest.main()