const prompt = require("prompt-sync")();
const { calculateCycleDates } = require("./menstrualApp");

console.log("MENSTRUAL TRACKER APP");

let startDateStr;
let cycleLength;

while (true) {
    startDateStr = prompt("Enter the first day of your last period (YYYY-MM-DD): ");
    const date = new Date(startDateStr);

    if (!isNaN(date)) {
        break;
    } else {
        console.log("Invalid date format. Please use YYYY-MM-DD.");
    }
}

while (true) {
    const input = prompt("Enter your cycle length in days: ");
    cycleLength = parseInt(input);

    if (!isNaN(cycleLength)) {
        break;
    } else {
        console.log("Number of Days must be a whole number.");
    }
}

try {
    const info = calculateCycleDates(startDateStr, cycleLength);

    console.log("Menstrual Cycle Information:");
    console.log("Start Date:", info.startDate.toDateString());
    console.log("Next Period:", info.nextPeriod.toDateString());
    console.log("Ovulation Day:", info.ovulationDay.toDateString());
    console.log("Fertile Window:", info.fertileWindow[0].toDateString(), "to", info.fertileWindow[1].toDateString());
} catch (error) {
    console.log("Error:", error.message);
}
