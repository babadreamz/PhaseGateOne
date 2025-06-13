from unittest import TestCase
import checkout_app

class TestCheckoutApp(TestCase):
	def setUp(self):
		checkout_app.items.clear()
		checkout_app.quantity_bought.clear()
		checkout_app.prices.clear()

	def test_that_add_item_and_calculate_total_works(self):
		checkout_app.add_item("Bread", 4, 1500)
		checkout_app.add_item("Beans", 5, 900)
		total = checkout_app.calculate_total()
		self.assertEqual(total, 10500)

	def test_that_discount_calculation_works(self):
		total = 10500
		discount = checkout_app.calculate_discount(total, 9)
		self.assertAlmostEqual(discount, 945)

	def test_that_vat_calculation_works(self):
		total = 10500
		vat = checkout_app.calculate_vat(total)
		self.assertAlmostEqual(vat, 1837.5)

	def test_that_get_bill_total_works(self):
		total = 10500
		discount = checkout_app.calculate_discount(total, 9)
		vat = checkout_app.calculate_vat(total)
		bill_total = checkout_app.get_bill_total(total, discount, vat)
		self.assertAlmostEqual(bill_total, 11392.5)