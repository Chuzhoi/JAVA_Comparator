import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Казань", "Уфа", 4000, 10, 11);
    Ticket ticket2 = new Ticket("Казань", "Москва", 8000, 10, 13);
    Ticket ticket3 = new Ticket("Казань", "Самара", 4000, 10, 12);
    Ticket ticket4 = new Ticket("Казань", "Воронеж", 6000, 10, 15);
    Ticket ticket5 = new Ticket("Казань", "Уфа", 5000, 10, 13);
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
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = new Ticket[]{ticket1, ticket6, ticket5};
        Ticket[] actual = manager.search("Казань", "Уфа");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestForSearchAndSortIfNoTickets() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.search("Казань", "Санкт-Петербург");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void TestIfTimeFirstTicketOver() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket4);
        manager.add(ticket5);
        int expected = 1;
        int actual = ticketTimeComparator.compare(ticket4, ticket5);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void TestIfTimeFirstTicketUnder() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket5);
        int expected = -1;
        int actual = ticketTimeComparator.compare(ticket1, ticket5);
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void TestIfTimeEquals() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket6);
        manager.add(ticket3);
        int expected = 0;
        int actual = ticketTimeComparator.compare(ticket6, ticket3);
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void TestForSearchAndSortByTickets() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = new Ticket[]{ticket1, ticket6, ticket5};
        Ticket[] actual = manager.searchAndSortBy("Казань", "Уфа", ticketTimeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestForSearchAndSortByIfNoTickets() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchAndSortBy("Казань", "Санкт-Петербург", ticketTimeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

}
