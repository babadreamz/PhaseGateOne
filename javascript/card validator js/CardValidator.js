function checkCard(cardNumber){
    let length = cardNumber.length;

    for(let index = 0; index < length; index++){
        let c = cardNumber[index];
        if(c < '0' || c > '9') {
            return "Invalid input: Card must contain only numbers.";
        }
    }

    if(length < 13 || length > 16){
        return "Invalid card: Card number must be between 13 and 16 digits.";
    }

    let cardType;
    if(cardNumber[0] === '4'){
        cardType = "Visa Card";
    }else if(cardNumber[0] === '5'){
        cardType = "MasterCard";
    }else if(cardNumber[0] === '3' && cardNumber[1] === '7'){
        cardType = "American Express Card";
    }else if(cardNumber[0] === '6'){
        cardType = "Discover Card";
    }else{
        cardType = "Invalid Card";
    }

    let reverseNumber = "";
    let index = length - 1;
    while (index >= 0){
        reverseNumber = reverseNumber + cardNumber[index];
        index = index - 1;
    }

    let total = 0;
    let position = 0;

    while(position < length){
        let digit = parseInt(reverseNumber[position]);

        if(position % 2 === 1){
            digit = digit * 2;
        }
        if(digit > 9){
            digit = digit - 9;
        }

        total = total + digit;
        position = position + 1;
    }

    let validity;
    if(total % 10 === 0){
        validity = "Valid";
    }else{
        validity = "Invalid";
    }

    let result = "";
    result += "*Credit Card Type: " + cardType + "\n";
    result += "**Credit Card Number: " + cardNumber + "\n";
    result += "**Credit Card Digit Length: " + length + "\n";
    result += "**Credit Card Validity Status: " + validity;

    return result;
}
module.exports = {
	checkCard
	};