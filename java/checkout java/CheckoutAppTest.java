import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CheckoutAppTest{

    @BeforeEach
    void setUp() {
        CheckoutApp.items.clear();
        CheckoutApp.quantityBought.clear();
        CheckoutApp.prices.clear();

        // Add two sample products
        CheckoutApp.addItem("Parfait", 2, 2100); 
        CheckoutApp.addItem("Rice", 2, 550);     
    }

    @Test
    void testAddItemAndCalculateTotal() {
        double expectedTotal = 5300.0;
        assertEquals(expectedTotal, CheckoutApp.calculateTotal());
    }

    @Test
    void testCalculateDiscount() {
        double total = 5300.0;
        double discount = CheckoutApp.calculateDiscount(total, 8);
        assertEquals(424.0, discount);
    }

    @Test
    void testCalculateVAT() {
        double total = 10000;
        double vat = CheckoutApp.calculateVAT(total);
        assertEquals(1750, vat);
    }

    @Test
    void testGetBillTotal() {
        double total = 5300.0;
        double discount = 424.0;
        double vat = 927.5;
        double finalBill = CheckoutApp.getBillTotal(total, discount, vat);
        assertEquals(5803.5, finalBill);
    }

    @Test
    void testItemListSize() {
        assertEquals(2, CheckoutApp.items.size());
    }

    @Test
    void testFirstItemValues() {
        assertEquals("Parfait", CheckoutApp.items.get(0));
        assertEquals(2, CheckoutApp.quantityBought.get(0));
        assertEquals(2100.0, CheckoutApp.prices.get(0));
    }
}
