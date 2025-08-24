import unittest
import QuickSort

class QuickSortTest(unittest.TestCase):

    def test_quick_sort_with_empty_list(self):
        self.assertListEqual(QuickSort.quick_sort([]), [])

    def test_quick_sort_with_one_item_list(self):
        self.assertListEqual(QuickSort.quick_sort([5]), [5])

    def test_quick_sort_with_two_ordered_items_list(self):
        self.assertListEqual(QuickSort.quick_sort([2, 5]), [2, 5])

    def test_quick_sort_with_two_unordered_items_list(self):
        self.assertListEqual(QuickSort.quick_sort([5, 2]), [2, 5])

    def test_quick_sort_with_a_few_ordered_items_list(self):
        self.assertListEqual(QuickSort.quick_sort([2, 3, 5, 6, 6, 10]), [2, 3, 5, 6, 6, 10])

    def test_quick_sort_with_a_few_unordered_items_list(self):
        self.assertListEqual(QuickSort.quick_sort([6, 3, 10, 2, 6, 5]), [2, 3, 5, 6, 6, 10])

if __name__ == '__main__':
    unittest.main()
