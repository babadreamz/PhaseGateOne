from unittest import TestCase
from card_validator import check_card

class TestCardValidator(TestCase):

	def test_for_valid_mastercard(self):
		card_number = "5399831619690403"
		result = check_card(card_number)
		self.assertIn("MasterCard", result)
		self.assertIn("Valid", result)

	def test_for_invalid_card_length(self):
		card_number = "123456" 
		result = check_card(card_number)
		self.assertIn("Invalid card", result)

	def test_invalid_characters(self):
		card_number = "1234abcd5678"
		result = check_card(card_number)
		self.assertIn("only numbers", result)

	def test_for_valid_visa_card(self):
		card_number = "4111111111111111"
		result = check_card(card_number)
		self.assertIn("Visa Card", result)
		self.assertIn("Valid", result)

	def test_for_luhn_check_validity(self):
		card_number = "5399831619690404" 
		result = check_card(card_number)
		self.assertIn("MasterCard", result)
		self.assertIn("Invalid", result)

	def test_invalid_prefix(self):
		card_number = "234319283049582"
		result = check_card(card_number)
		self.assertIn("Invalid Card", result)
		self.assertIn("Invalid", result)
