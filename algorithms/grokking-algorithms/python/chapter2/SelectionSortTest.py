import unittest
import SelectionSort

class SelectionSortTest(unittest.TestCase):

    def test_sort_empty_list(self):
        self.assertListEqual(SelectionSort.selection_sort([]), [])

    def test_sort_one_item(self):
        self.assertListEqual(SelectionSort.selection_sort([1]), [1])

    def test_sort_ordered_list(self):
        self.assertListEqual(SelectionSort.selection_sort([1, 2, 3, 4, 5]), [1, 2, 3, 4, 5])

    def test_sort_unordered_list(self):
        self.assertListEqual(SelectionSort.selection_sort([3, 2, 5, 1, 4]), [1, 2, 3, 4, 5])

    def test_sort_reversed_list(self):
        self.assertListEqual(SelectionSort.selection_sort([5, 4, 3, 2, 1]), [1, 2, 3, 4, 5])
