from menstrual_app import cycle_dates_calculation
from datetime import date
from unittest import TestCase
class TestMenstrualApp(TestCase):
	def test_that_start_dates_gives_default_length(self):
		actual = cycle_dates_calculation("2025-02-15", 30)
		expected_period_start = date(2025, 2, 15)
		self.assertEqual(actual["start_date"], expected_period_start)
		
	def test_that_fertile_start_gives_default_length(self):
		actual = cycle_dates_calculation("2025-02-15", 30)
		expected_fertile_start = date(2025, 2, 27)
		self.assertEqual(actual["fertile_window"][0], expected_fertile_start)

	def test_that_fertile_end_gives_default_length(self):
		actual = cycle_dates_calculation("2025-02-15", 30)
		expected_fertile_end = date(2025, 3, 4)
		self.assertEqual(actual["fertile_window"][1], expected_fertile_end)

	def test_that_next_period_gives_default_length(self):
		actual = cycle_dates_calculation("2025-02-15", 30)
		expected_next_period = date(2025, 3, 17)
		self.assertEqual(actual["next_period"], expected_next_period)

	def test_that_next_ovulation_day_default_length(self):
		actual = cycle_dates_calculation("2025-02-15", 30)
		expected_ovulation = date(2025, 3, 3)
		self.assertEqual(actual["ovulation_day"], expected_ovulation)



'''
expected_ovulation = date(2025, 3, 15)
		expected_fertile_start = date(2025, 3, 11)
		expected_fertile_end = date(2025, 3, 16)
		expected_next_period = date(2025, 03, 17)
		self.assertEqual(actual["start_date"], expected_period_start)
		self.assertEqual(actual["ovul_day"], expected_ovulation)
		self.assertEqual(actual["fertile_window"][0], expected_fertile_start)
		self.assertEqual(actual["fertile_window"][1], expected_fertile_end)
		self.assertEqual(actual["next_period"], expected_next_period)
'''