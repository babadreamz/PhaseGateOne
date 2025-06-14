const prompt = require('prompt-sync')(); 
const{ checkCard } = require('./CardValidator');

while(true){
    console.log("Hello, Kindly Enter Card details to verify");
    let cardNumber = prompt();

    let result = checkCard(cardNumber);
    console.log();
    console.log(result);

    console.log("Do you want to try again? yes or no");
    let userInput = prompt();

    if(userInput.toLowerCase() === "no"){
        console.log("Thank you for using this service");
        break;
    }else{
        continue;
    }
}
