import unittest
import example

class ExampleTest(unittest.TestCase):

    def test_example(self):
        self.assertEqual('example', example.example('EXAMPLE'))

if __name__ == '__main__':
    unittest.main()
