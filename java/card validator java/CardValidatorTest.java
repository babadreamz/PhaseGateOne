import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardValidatorTest{

    @Test
    public void testForValidMasterCard(){
        String cardNumber = "5399831619690403";
        String result = CardValidator.checkCard(cardNumber);
        assertTrue(result.contains("MasterCard"));
        assertTrue(result.contains("Valid"));
    }

    @Test
    public void testForInvalidMasterCard(){
        String cardNumber = "5399831619690404";
        String result = CardValidator.checkCard(cardNumber);
        assertTrue(result.contains("MasterCard"));
        assertTrue(result.contains("Invalid"));
    }

    @Test
    public void testForAmericanExpressCard(){
        String cardNumber = "371449635398431";
        String result = CardValidator.checkCard(cardNumber);
        assertTrue(result.contains("American Express Card"));
        assertTrue(result.contains("Valid"));
    }

    @Test
    public void testForInvalidCharacters(){
        String cardNumber = "1234abcd5678"; 
        String result = CardValidator.checkCard(cardNumber);
        assertEquals("Invalid input: Card must contain only numbers.", result);
    }

    @Test
    public void testForInvalidLength(){
        String cardNumber = "123456"; 
        String result = CardValidator.checkCard(cardNumber);
        assertEquals("Invalid card: Card number must be between 13 and 16 digits.", result);
    }
}
