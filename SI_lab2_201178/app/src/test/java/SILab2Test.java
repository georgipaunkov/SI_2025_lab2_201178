import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void testEveryStatement() {
		//Validen item , validna kartica
        Item item1 = new Item("Soap", 2, 100, 0.1);
        Item item2 = new Item("Brush", 5, 50, 0.0);
        List<Item> items = Arrays.asList(item1, item2);
        String cardNumber = "1234567890123456";
        double result = SILab2.checkCart(items, cardNumber);
        assertEquals(100 * 0.9 * 2 + 50 * 5 - 30,result); 

		//Nevaliden item
        Item item3 = new Item(null, 1, 100, 0);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(Arrays.asList(item3), cardNumber));
		
		//Nevalidna kartica
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, "abcd123"));
    }

    @Test
    public void testMultipleCondition() {
        String cardNumber = "1234567890123456";
		//0,0,0-->0
        Item item1 = new Item("Pen", 2, 100, 0);
        double result1 = SILab2.checkCart(List.of(item1), cardNumber);
        assertEquals(200, result1);
		
		//1,0,0 -->1
        Item item2 = new Item("Monitor", 1, 350, 0);
        double result2 = SILab2.checkCart(List.of(item2), cardNumber);
        assertEquals(320, result2); // 350 - 30

		//0,1,0 -->1
        Item item3 = new Item("Phone Case", 1, 100, 0.2);
        double result3 = SILab2.checkCart(List.of(item3), cardNumber);
        assertEquals(100 * 0.8 - 30, result3);
		
		//0,0,1 -->1
        Item item4 = new Item("USB", 11, 10, 0);
        double result4 = SILab2.checkCart(List.of(item4), cardNumber);
        assertEquals(110 - 30, result4);
    }
}
