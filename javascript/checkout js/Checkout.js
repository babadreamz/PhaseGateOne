const items = [];
const quantityBought = [];
const prices = [];

function addItem(name, quantity, price) {
  items.push(name);
  quantityBought.push(quantity);
  prices.push(price);
}

function calculateTotal() {
  let total = 0;
  for (let item = 0; item < items.length; item++) {
    total += quantityBought[item] * prices[item];
  }
  return total;
}

function calculateDiscount(total, discountRate) {
  return (discountRate / 100) * total;
}

function calculateVAT(total) {
  return 0.175 * total;
}

function getBillTotal(total, discount, vat) {
  return total - discount + vat;
}

module.exports = {
  items,
  quantityBought,
  prices,
  addItem,
  calculateTotal,
  calculateDiscount,
  calculateVAT,
  getBillTotal
};
