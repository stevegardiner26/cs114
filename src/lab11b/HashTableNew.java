package lab11b;
import java.util.Map;
import java.util.Objects;

public class HashTableNew<E>
{

    static int countCollision=0;
    private int M = 0;
    private int count = 0;
    @SuppressWarnings("rawtypes")
    private KVpair[] HT;
    private int loading = 0;

    // Generic array allocation
    public HashTableNew(int m)
    {
        M = m;
        HT = new KVpair[m];
    }

    boolean isFull() {
        loading = (count * 100) / M;
        return (loading >= 60) ? true : false;
    }

    void hashInsert(E k)
    {
        hashInsert(k, k);
    }

    void hashInsert(E k, E r)
    {

        // (e)Add those data names to the table
        //start with empty table until the
        // table is 40% full.

        // Make sure the value is not null
        if (r == null)
        {
            throw new NullPointerException();
        }

        // Makes sure the key is not already in the hashtable.
        KVpair[] tab = HT;
        int hash = new HashFunction().sfold((String) k, M);


        // int hash = hash(k);
        // int index = (hash & 0x7FFFFFFF) % tab.length;
        for (KVpair<E, E> e = tab[hash]; e != null; e = e.next)
        {
            countCollision++;
            if ((e.hash == hash) && e.key.equals(k))
            {
                E old = e.value;
                e.value = r;
                return;
            }
        }

        // Creates the new entry.
        @SuppressWarnings("unchecked")
        KVpair<E, E> e = tab[hash];
        tab[hash] = new KVpair<>(hash, k, r, e);
        count++;
    }

    E search(E k)
    {
        @SuppressWarnings("rawtypes")
        KVpair tab[] = HT;
        int home = new HashFunction().sfold((String) k, M);
        int index = (home & 0x7FFFFFFF) % tab.length;
        for (@SuppressWarnings("unchecked")
             KVpair<E, E> e = tab[index]; e != null; e = e.next)
        {
            if ((e.hash == home) && e.key.equals(k))
            {
                return e.value;
            }
        }
        return null;
    }

    void printTable()
    {
        System.out.println("Hashtable Contents : ");
        for (int indx = 0; indx < HT.length; indx++)
        {
            System.out.println(HT[indx]);
        }
    }

    public static void main(String[] args)
    {

        // (a)A table size is 128 slots.
        // Configure the slot size using tableSize
        //variable and HashTable class
        // constructor
        int tableSize = 128;
        HashTableNew<String> hashFunction = new HashTableNew<String>(tableSize);

        // (b)The input data are randomly generated UNIQUE upper case data names
        // with eight characters in length (Each name has to be unique).
        RandomStringGenerator msr = new RandomStringGenerator();
        for (int indx = 0; indx < tableSize; indx++)
        {

            // (c)Use the generated name for both key and Element value
            // (KVpair.) you can use different key and value pair, in that case
            // you have
            // to invoke hashInsert(E k, E v) method.

            if (!hashFunction.isFull())
            {
                hashFunction.hashInsert(msr.getRandomString());
                // (f)Display the percentage of table
                //had been occupied during the insertion.
                if(hashFunction.loading == 40) {
                    System.out.print("Key count is " + hashFunction.count + " table is " + hashFunction.loading + "% full.");
                    System.out.println(" Number of collision: "+countCollision);
                }
            } else
            {
                // (e)Add those data names to the table start
                //with empty table until the table is 40% full.
                System.out.print("Table is " + hashFunction.loading + "% full.");
                System.out.println(" Total collision: "+countCollision);
                break;
            }
        }

/*
        hashFunction.printTable();
*/
    }

    private static class KVpair<K, V> implements Map.Entry<K, V>
    {
        int hash;
        final K key;
        V value;
        KVpair<K, V> next;

        protected KVpair(int hash, K key, V value, KVpair<K, V> next)
        {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @SuppressWarnings("unchecked")
        protected Object clone() {
            return new KVpair<>(hash, key, value, (next == null ? null
                    : (KVpair<K, V>) next.clone()));
        }

        // Map.Entry Ops

        public K getKey()
        {
            return key;
        }

        public V getValue()
        {
            return value;
        }

        public V setValue(V value)
        {
            if (value == null)
                throw new NullPointerException();

            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @SuppressWarnings("rawtypes")
        public boolean equals(Object o)
        {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?, ?> e = (Map.Entry) o;

            return key.equals(e.getKey()) && value.equals(e.getValue());
        }

        public int hashCode() {
            return (Objects.hashCode(key) ^ Objects.hashCode(value));
        }

        public String toString() {
            return key.toString() + "=" + value.toString();
        }
    }

}