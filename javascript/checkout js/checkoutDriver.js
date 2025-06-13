const prompt = require("prompt-sync")();
const Checkout = require("./checkout");

console.log("What is the customer's name?");
const customerName = prompt();

while (true) {
  console.log("What did the user buy?");
  const item = prompt();

  console.log("How many pieces?");
  const quantity = parseInt(prompt());

  console.log("How much per unit?");
  const price = parseFloat(prompt());
  checkout.addItem(item, quantity, price);

  console.log("Add more items? (yes/no)");
  const more = prompt().toLowerCase();
  if (more !== "yes") break;
}

console.log("What is your name?");
const cashierName = prompt();

console.log("How much discount will they get?");
const discountRate = parseFloat(prompt());

const subtotal = checkout.calculateTotal();
const discount = checkout.calculateDiscount(subtotal, discountRate);
const vat = checkout.calculateVAT(subtotal);
const billTotal = checkout.getBillTotal(subtotal, discount, vat);

const now = new Date();
console.log("\nSEMICOLON STORES");
console.log("MAIN BRANCH");
console.log("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
console.log("TEL: 03293828343");
console.log("Date:", now.toLocaleString());
console.log("Cashier:", cashierName);
console.log("Customer Name:", customerName);
console.log("\nITEM\tQTY\tPRICE\tTOTAL");

for (let item = 0; item < checkout.items.length; item++) {
  const itemTotal = checkout.quantityBought[item] * checkout.prices[item];
  console.log(`${checkout.items[item]}\t${checkout.quantityBought[item]}\t${checkout.prices[item].toFixed(2)}\t${itemTotal.toFixed(2)}`);
}

console.log("\nSub Total:\t", subtotal.toFixed(2));
console.log("Discount:\t", discount.toFixed(2));
console.log("VAT @ 17.50%:\t", vat.toFixed(2));
console.log("Bill Total:\t", billTotal.toFixed(2));
console.log("\nTHIS IS NOT A RECEIPT. KINDLY PAY", billTotal.toFixed(2));

console.log("\nHow much did the customer give to you?");
const amountPaid = parseFloat(prompt());
const balance = amountPaid - billTotal;

console.log("\n--- Final Receipt ---");
console.log("Amount Paid:\t", amountPaid.toFixed(2));
console.log("Balance:\t", balance.toFixed(2));
console.log("THANK YOU FOR YOUR PATRONAGE");
