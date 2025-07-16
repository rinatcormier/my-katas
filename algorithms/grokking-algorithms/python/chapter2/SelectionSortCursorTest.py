import unittest
from SelectionSortCursor import selection_sort

class TestSelectionSortCursor(unittest.TestCase):
    def test_empty_list(self):
        self.assertEqual(selection_sort([]), [])

    def test_single_element(self):
        self.assertEqual(selection_sort([1]), [1])

    def test_sorted_list(self):
        self.assertEqual(selection_sort([1, 2, 3, 4]), [1, 2, 3, 4])

    def test_reverse_sorted_list(self):
        self.assertEqual(selection_sort([4, 3, 2, 1]), [1, 2, 3, 4])

    def test_duplicates(self):
        self.assertEqual(selection_sort([3, 1, 2, 3, 1]), [1, 1, 2, 3, 3])

    def test_negative_numbers(self):
        self.assertEqual(selection_sort([-2, -5, 0, 3, 1]), [-5, -2, 0, 1, 3])

    def test_mixed_numbers(self):
        self.assertEqual(selection_sort([0, -1.5, 5, 3.2, -2]), [-2, -1.5, 0, 3.2, 5])

    def test_large_numbers(self):
        self.assertEqual(selection_sort([1000, 500, 10000, 1]), [1, 500, 1000, 10000])

    def test_all_equal(self):
        self.assertEqual(selection_sort([7, 7, 7, 7]), [7, 7, 7, 7])

    def test_original_list_not_modified(self):
        original = [3, 1, 4, 1, 5]
        copy = original.copy()
        selection_sort(original)
        self.assertEqual(original, copy)

if __name__ == "__main__":
    unittest.main() 