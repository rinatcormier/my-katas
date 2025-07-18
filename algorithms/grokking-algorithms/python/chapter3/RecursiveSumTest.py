import unittest
import RecursiveSum

class RecursiveSumTest(unittest.TestCase):

    def test_sum_empty_list(self):
        self.assertEqual(RecursiveSum.recursive_sum([]), 0)

    def test_sum_single_item_list(self):
        self.assertEqual(RecursiveSum.recursive_sum([7]), 7)

    def test_sum_multiple_item_list(self):
        self.assertEqual(RecursiveSum.recursive_sum([7, 6, 7, 15]), 35)
