public class CardValidator{

    public static String checkCard(String cardNumber){
        int length = cardNumber.length();

            for(int index = 0; index < length; index++){
            char c = cardNumber.charAt(index);
            if(c < '0' || c > '9') {
                return "Invalid input: Card must contain only numbers.";
            }
        }

        if(length < 13 || length > 16){
            return "Invalid card: Card number must be between 13 and 16 digits.";
        }

        String cardType;
        if(cardNumber.charAt(0) == '4'){
            cardType = "Visa Card";
        }else if (cardNumber.charAt(0) == '5'){
            cardType = "MasterCard";
        }else if(cardNumber.charAt(0) == '3' && cardNumber.charAt(1) == '7'){
            cardType = "American Express Card";
        }else if (cardNumber.charAt(0) == '6'){
            cardType = "Discover Card";
        }else{
            cardType = "Invalid Card";
        }

        String reverseNumber = "";
        int index = length - 1;
        while(index >= 0){
            reverseNumber = reverseNumber + cardNumber.charAt(index);
            index = index - 1;
        }

        int total = 0;
        int position = 0;

        while(position < length){
            int digit = reverseNumber.charAt(position) - '0';

            if(position % 2 == 1){
                digit = digit * 2;
            }
            if(digit > 9){
                digit = digit - 9;
            }

            total = total + digit;
            position = position + 1;
        }

        String validity;
        if(total % 10 == 0){
            validity = "Valid";
        }else {
            validity = "Invalid";
        }

        String result = "";
        result += "*Credit Card Type: " + cardType + "\n";
        result += "**Credit Card Number: " + cardNumber + "\n";
        result += "**Credit Card Digit Length: " + length + "\n";
        result += "**Credit Card Validity Status: " + validity;

        return result;
    }
}
