items = []
quantity_bought = []
prices = []

def add_item(name, quantity, price):
	items.append(name)
	quantity_bought.append(quantity)
	prices.append(price)

def calculate_total():
	total = 0
	for item in range(len(items)):
		total += quantity_bought[item] * prices[item]
	return total

def calculate_discount(total, discount_rate):
	return (discount_rate / 100) * total

def calculate_vat(total):
	return 0.175 * total

def get_bill_total(total, discount, vat):
	return total - discount + vat
