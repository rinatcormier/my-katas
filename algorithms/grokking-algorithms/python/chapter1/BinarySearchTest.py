import unittest
import BinarySearch

class BinarySearchTest(unittest.TestCase):

    def test_when_seeking_number_found_at_first_position(self):
        self.assertEqual(BinarySearch.binary_search([3, 5, 13, 24, 56], 3), 0)

    def test_when_seeking_number_found_at_last_position(self):
        self.assertEqual(BinarySearch.binary_search([3, 5, 13, 24, 56], 56), 4)

    def test_when_seeking_number_found_at_mid_position(self):
        self.assertEqual(BinarySearch.binary_search([3, 5, 13, 18, 24, 56], 18), 3)

    def test_when_seeking_number_not_found(self):
        self.assertEqual(BinarySearch.binary_search([3, 5, 13, 18, 24, 56], 99), None)
