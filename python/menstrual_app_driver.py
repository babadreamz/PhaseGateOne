from menstrual_app import cycle_dates_calculation

while True:
	print("MENSTRUAL TRACKER APP")
	user_date = input("Enter the first day of your last period(YYYY-MM-DD): ")
	while True:
		try:
			cycle_length = int(input("Enter your cycle length in days: "))
			break
		except ValueError:
			print("Days must be a whole number ")

	try:
		info = cycle_dates_calculation(user_date, cycle_length)
		print("Menstrual Cycle information: ")
		print(f"start_date: {info['start_date']}")
		print(f"next_period_date: {info['next_period']}")
		print(f"ovulation_day: {info['ovulation_day']}")
		print(f"Fertile Window: {info['fertile_window'][0]} to {info['fertile_window'][1]}")
		break
	except ValueError:
		print("Invalid date format. Please try again using the YYYY-MM-DD format ")
