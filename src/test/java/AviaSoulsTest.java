import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Казань", "Уфа", 4000, 10, 11);
    Ticket ticket2 = new Ticket("Казань", "Москва", 8000, 10, 13);
    Ticket ticket3 = new Ticket("Казань", "Самара", 4000, 10, 14);
    Ticket ticket4 = new Ticket("Казань", "Воронеж", 6000, 10, 15);
    Ticket ticket5 = new Ticket("Казань", "Уфа", 5000, 10, 12);
    Ticket ticket6 = new Ticket("Казань", "Уфа", 4500, 10, 12);

    @Test
    public void TestIfPriceFirstTicketOver() {
        int expected = 1;
        int actual = ticket2.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestIfPriceFirstTicketUnder() {
        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestIfPricesEqual() {
        int expected = 0;
        int actual = ticket1.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestForSearchAndSortTickets() {
        AviaSouls meneger = new AviaSouls();
        meneger.add(ticket1);
        meneger.add(ticket2);
        meneger.add(ticket3);
        meneger.add(ticket4);
        meneger.add(ticket5);
        meneger.add(ticket6);
        Ticket[] expected = new Ticket[]{ticket1, ticket6, ticket5};
        Ticket[] actual = meneger.search("Казань", "Уфа");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestForSearchAndSortIfNoTickets() {
        AviaSouls meneger = new AviaSouls();
        meneger.add(ticket1);
        meneger.add(ticket2);
        meneger.add(ticket3);
        meneger.add(ticket4);
        meneger.add(ticket5);
        meneger.add(ticket6);
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = meneger.search("Казань", "Санкт-Петербург");
        Assertions.assertArrayEquals(expected, actual);
    }


}
