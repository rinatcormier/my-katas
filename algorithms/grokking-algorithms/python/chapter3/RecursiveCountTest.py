import unittest
import RecursiveCount

class RecursiveSumTest(unittest.TestCase):

    def test_count_empty_list(self):
        self.assertEqual(RecursiveCount.recursive_count([]), 0)

    def test_count_single_item_list(self):
        self.assertEqual(RecursiveCount.recursive_count([7]), 1)

    def test_count_multiple_item_list(self):
        self.assertEqual(RecursiveCount.recursive_count([7, 6, 7, 15]), 4)
