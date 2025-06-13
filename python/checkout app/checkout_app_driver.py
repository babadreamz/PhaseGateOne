import checkout_app
import datetime

print("What is the customer's Name")
customer_name = input()

while True:
	print("What did the user buy?")
	item = input()
	
	print("How many pieces?")
	while True:
		try:
			quantity = int(input())
			break
		except ValueError:
			print("Enter a valid number")
	print("How much per unit?")
	while True:
		try:
			price = float(input())
			break
		except ValueError:
			print("Enter a valid number")
	checkout_app.add_item(item, quantity, price)

	print("Add more Items? (yes/no)")
	answer = input().lower()
	if answer != "yes":
		break

print("What is your name?")
cashier_name = input("")

print("How much discount will they get?")
while True:
	try:
		discount_rate = float(input())
		break
	except ValueError:
		print("enter a valid number")
subtotal = checkout_app.calculate_total()
discount = checkout_app.calculate_discount(subtotal, discount_rate)
vat = checkout_app.calculate_vat(subtotal)
bill_total = checkout_app.get_bill_total(subtotal, discount, vat)

print()
print("SEMICOLON STORES")
print("MAIN BRANCH")
print("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.")
print("TEL: 03293828343")
print("Date:", datetime.datetime.now().strftime("%d-%b-%y %I:%M:%S %p"))
print("Cashier:", cashier_name)
print("Customer Name:", customer_name)
print()
print("ITEM\tQTY\tPRICE\tTOTAL (NGN)")

for item in range(len(checkout_app.items)):
	item_total = checkout_app.quantity_bought[item] * checkout_app.prices[item]
	print(f"{checkout_app.items[item]}\t{checkout_app.quantity_bought[item]}\t{checkout_app.prices[item]:.2f}\t{item_total:.2f}")

print()
print("Sub Total:\t\t", f"{subtotal:.2f}")
print("Discount:\t\t", f"{discount:.2f}")
print("VAT @ 17.50%:\t\t", f"{vat:.2f}")
print()
print("Bill Total:\t\t", f"{bill_total:.2f}")
print()
print("THIS IS NOT A RECEIPT. KINDLY PAY", f"{bill_total:.2f}")
print()

print("How much did the customer give to you?")
while True:
	try:
		amount_paid = float(input())
		break
	except ValueError:
		print("Enter a valid number")
balance = amount_paid - bill_total

print()
print("SEMICOLON STORES")
print("MAIN BRANCH")
print("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.")
print("TEL: 03293828343")
print("Date:", datetime.datetime.now().strftime("%d-%b-%y %I:%M:%S %p"))
print("Cashier:", cashier_name)
print("Customer Name:", customer_name)
print()
print("ITEM\tQTY\tPRICE\tTOTAL (NGN)")

for item in range(len(checkout_app.items)):
	item_total = checkout_app.quantity_bought[item] * checkout_app.prices[item]
	print(f"{checkout_app.items[item]}\t{checkout_app.quantity_bought[item]}\t{checkout_app.prices[item]:.2f}\t{item_total:.2f}")

print()
print("Sub Total:\t\t", f"{subtotal:.2f}")
print("Discount:\t\t", f"{discount:.2f}")
print("VAT @ 17.50%:\t\t", f"{vat:.2f}")
print("Bill Total:\t\t", f"{bill_total:.2f}")
print("Amount Paid:\t\t", f"{amount_paid:.2f}")
print("Balance:\t\t", f"{balance:.2f}")
print()
print("THANK YOU FOR YOUR PATRONAGE")
