import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashLinearProbingTest {
    private char[] A = {'B', 'O', 'E', 'P', 'V', 'L', 'X', 'N', 'K', 'M'};
    private HashLinearProbing hlp = new HashLinearProbing();

    @Test
    void putAndGetAll() {
        for (int i = 0; i< A.length ; i++)
            Assertions.assertNotEquals(-1, this.hlp.put(A[i], i));

        this.hlp.print();

        for (int i = 0; i<A.length; i++)
            Assertions.assertEquals(i, this.hlp.get(A[i]));
    }

    @Test
    void getNonExisting() {
        for (int i = 0; i< A.length ; i++)
            this.hlp.put(A[i], i);

        Assertions.assertEquals(-1, this.hlp.get('Y'));
    }

    @Test
    void removeNonExisting() {
        for (int i = 0; i< A.length ; i++)
            this.hlp.put(A[i], i);

        Assertions.assertFalse(this.hlp.remove('Y'));
        this.hlp.print();
    }
}