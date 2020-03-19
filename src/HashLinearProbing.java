/**
 * Author Fahde Sorgho
 */
public class HashLinearProbing {
    private final int  M = 11;

    private char[] keys = new char[M];
    private int[] values = new int[M];

    /**
     * @param k
     * @param v
     *
     * @return int
     */
    public int put(char k, int v)
    {
        int i = this.hash(k);

        if (this.keys.length == (M-1))
            return -1;

        while (this.keys[i] != 0) {
            i = (i+1) % M;
        }

        this.keys[i] = k;
        this.values[i] = v;

        return i;
    }

    /**
     * @param k
     *
     * @return int
     */
    public int get(char k)
    {
        int i = this.hash(k);
        int toReturn = -1;

        while (this.keys[i] != k && this.keys[i] != 0)
        {
            i = (i+1) % M;
        }

        if(this.keys[i] == k)
            toReturn = this.values[i];

        return toReturn;
    }

    /**
     * @param k
     *
     * @return boolean
     */
    public boolean remove(char k)
    {
        int i = this.hash(k);

        while (this.keys[i] != k && this.keys[i] != 0)
        {
            i = (i+1) % M;
        }

        if (this.keys[i] != k)
            return false;

        this.keys[i] = 0; this.values[i] = 0;
        i = (i+1) % M;

        while (this.keys[i] != 0) {
           char savedKey = this.keys[i]; int savedValue = this.values[i];
           this.keys[i] = 0; this.values[i] = 0;
           this.put(savedKey, savedValue);
            i = (i+1) % M;
        }

        return true;
    }

    /**
     * @return void
     */
    public void print() {
        for (int i=0; i<M; i++)
            System.out.println("Key : " + keys[i] + " Value : " +values[i]);
    }

    /**
     * @param k
     *
     * @return int
     */
    private int hash(char k)
    {
        return ((int)k % M);
    }
}
