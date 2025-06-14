from card_validator import check_card

while True:
	print("Hello, Kindly Enter Card details to verify")
	card_number = input()
	
	result = check_card(card_number)
	print()
	print(result)
	print("Do you want to try again? yes or no")
	user_input = input()
	if user_input.lower() == "no":
		print("Thank you for using this service")
		break
	else:
		continue	