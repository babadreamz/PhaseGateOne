function calculateCycleDates(startingDateStr, cycleLength) {
	const startDate = new Date(startingDateStr);
	if (isNaN(startDate)) {
	throw new Error("Invalid date format. Use YYYY-MM-DD format");
	}

	const ovulationDay = new Date(startDate);
	ovulationDay.setDate(ovulationDay.getDate() + (cycleLength - 14));
	const fertileStart = new Date(ovulationDay);
	fertileStart.setDate(fertileStart.getDate() - 4);
	
	const fertileEnd = new Date(ovulationDay);
	fertileEnd.setDate(fertileEnd.getDate() + 1);

	const nextPeriod = new Date(startDate);
	nextPeriod.setDate(nextPeriod.getDate() + cycleLength);
	
	return {
	startDate,
	ovulationDay,
	fertileWindow: [fertileStart, fertileEnd],
	nextPeriod
	};
}

module.exports = {
	calculateCycleDates
	};



