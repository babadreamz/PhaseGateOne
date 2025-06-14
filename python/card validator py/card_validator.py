def check_card(card_number):
	length = len(card_number)
	if not card_number.isdigit():
		return "Invalid input: Card must contain only numbers."

	if length < 13 or length > 16:
		return "Invalid card: Card number must be between 13 and 16 digits."

	if card_number[0] == "4":
		card_type = "Visa Card"
	elif card_number[0] == "5":
		card_type = "MasterCard"
	elif card_number[0] == "3" and card_number[1] == "7":
		card_type = "American Express Card"
	elif card_number[0] == "6":
		card_type = "Discover Card"
	else:
		card_type = "Invalid Card"

	reverse_number = ""
	index = length - 1
	while index >= 0:
		reverse_number = reverse_number + card_number[index]
		index = index - 1
	
	total = 0
	position = 0

	while position < length:
		digit = int(reverse_number[position])

		if position % 2 == 1:
			digit = digit * 2
		if digit > 9:
			digit = digit - 9
		total = total + digit
		position = position + 1

	if total % 10 == 0:
		validity = "Valid"
	else:
		validity = "Invalid"


	result = ""
	result += "*Credit Card Type: " + card_type + "\n"
	result += "**Credit Card Number: " + card_number + "\n"
	result += "**Credit Card Digit Length: " + str(length) + "\n"
	result += "**Credit Card Validity Status: " + validity
	return result
