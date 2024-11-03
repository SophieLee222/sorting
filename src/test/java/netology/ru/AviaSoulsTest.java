package netology.ru;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.AviaSouls;
import ru.netology.Ticket;
import ru.netology.TicketTimeComparator;

public class AviaSoulsTest {

    @Test
    public void shouldComparePriceIfFirstMore() {
        Ticket ticket1 = new Ticket("Dubai", "Istanbul", 30_000, 17, 23);
        Ticket ticket2 = new Ticket("Moscow", "Erevan", 10_000, 10, 13);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePriceIfFirstLess() {
        Ticket ticket1 = new Ticket("Moscow", "Erevan", 10_000, 10, 13);
        Ticket ticket2 = new Ticket("Dubai", "Istanbul", 30_000, 17, 23);

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSort() {
        AviaSouls manager = new AviaSouls();

        Ticket t1 = new Ticket("Moscow", "Erevan", 10_000, 10, 13);
        Ticket t2 = new Ticket("Moscow", "Erevan", 7_000, 14, 17);
        Ticket t3 = new Ticket("Erevan", "Moscow", 20_000, 6, 12);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);

        Ticket[] expected = {t2, t1};
        Ticket[] actual = manager.search("Moscow", "Erevan");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareFlightTimeIfFirstMore() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket t1 = new Ticket("Moscow", "Erevan", 10_000, 10, 14);
        Ticket t2 = new Ticket("Moscow", "Erevan", 13_000, 14, 17);

        int expected = 1;
        int actual = comparator.compare(t1, t2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareFlightTimeIfFirstLess() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket t1 = new Ticket("Moscow", "Erevan", 10_000, 13, 15);
        Ticket t2 = new Ticket("Moscow", "Erevan", 13_000, 12, 17);

        int expected = -1;
        int actual = comparator.compare(t1, t2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortBy() {
        AviaSouls manager = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket t1 = new Ticket("Moscow", "Erevan", 10_000, 10, 17);
        Ticket t2 = new Ticket("Dubai", "Istanbul", 30_000, 17, 23);
        Ticket t3 = new Ticket("Erevan", "Moscow", 7_000, 14, 17);
        Ticket t4 = new Ticket("Moscow", "Erevan", 20_000, 6, 10);
        Ticket t5 = new Ticket("Moscow", "Erevan", 12_000, 14, 17);
        Ticket t6 = new Ticket("Moscow", "Istanbul", 15_000, 14, 17);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);

        Ticket[] expected = {t5, t4, t1};
        Ticket[] actual = manager.searchAndSortBy("Moscow", "Erevan", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
