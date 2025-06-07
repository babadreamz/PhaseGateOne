from datetime import datetime, timedelta
def cycle_dates_calculation(starting_date, cycle_length):
	start_date = datetime.strptime(starting_date, "%Y-%m-%d").date()
	ovulation_day = start_date + timedelta(days=cycle_length - 14)
	fertile_window_open = ovulation_day - timedelta(days=4)
	fertile_window_close = ovulation_day + timedelta(days=1)
	next_period = start_date + timedelta(days=cycle_length)
	return{
		"start_date": start_date,
		"ovulation_day": ovulation_day,
		"fertile_window": (fertile_window_open, fertile_window_close),
		"next_period": next_period
	}