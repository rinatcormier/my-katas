import unittest
import RecursiveMax

class RecursiveMaxTest(unittest.TestCase):

    def test_max_empty_list(self):
        self.assertEqual(RecursiveMax.recursive_max([]), None)

    def test_max_single_item_list(self):
        self.assertEqual(RecursiveMax.recursive_max([7]), 7)

    def test_max_multiple_item_list(self):
        self.assertEqual(RecursiveMax.recursive_max([7, 6, 7, 15]), 15)
