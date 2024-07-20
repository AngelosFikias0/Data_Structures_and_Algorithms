//Class for hash table
import java.util.LinkedList;
public class Hashtable<K, V> {
    private LinkedList<Entry<K, V>>[] table;
    private int capacity;
    private int size;

    // Constructor to initialize the hash table with a given capacity
    public Hashtable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Method to put a key-value pair into the hash table
    public void put(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("Null key not allowed");

        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Check if key already exists, update value if so
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.value = value; // Update value if key exists
                return;
            }
        }

        // If key does not exist, add new Entry to the bucket
        bucket.add(new Entry<>(key, value));
        size++;
    }

    // Method to get the value associated with a key from the hash table
    public V get(K key) {
        if (key == null)
            throw new IllegalArgumentException("Null key not allowed");

        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Iterate through the bucket to find the key
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue(); // Return value if key found
            }
        }

        return null; // Return null if key not found
    }

    // Method to remove a key-value pair from the hash table
    public void remove(K key) {
        if (key == null)
            throw new IllegalArgumentException("Null key not allowed");

        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Iterate through the bucket to find and remove the key
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                bucket.remove(entry); // Remove entry from bucket
                size--;
                return;
            }
        }
    }

    // Method to check if the hash table contains a key
    public boolean containsKey(K key) {
        if (key == null)
            throw new IllegalArgumentException("Null key not allowed");

        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Iterate through the bucket to check if key exists
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return true; // Key found
            }
        }

        return false; // Key not found
    }

    // Method to traverse the hash table and print all key-value pairs
    public void traverse() {
        for (LinkedList<Entry<K, V>> bucket : table) {
            for (Entry<K, V> entry : bucket) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        }
    }

    // Method to compute the hash code and get index in the internal array
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}
