class HashTable {

    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    int size;
    Pair[] map;

    public HashTable(int capacity) throws Exception {
        if (capacity < 2) throw new Exception("HashTable Capacity Error: capacity > 1");
        this.capacity = capacity;
        this.size = 0;
        this.map = new Pair[this.capacity];
    }

    public void insert(int key, int value) {
        int index = this.hash(key);
        while (true) {
            if (this.map[index] == null) {
                this.map[index] = new Pair(key, value);
                this.size += 1;
                if (this.size >= this.capacity / 2) {
                    this.resize();
                }
                return;
            }
            else if (this.map[index].key == key) {
                this.map[index].value = value;
                return;
            }
            index += 1;
            index = index % this.capacity;
        }
    }

    public int get(int key) {
        int index = this.hash(key);
        while (this.map[index] != null) {
            if (this.map[index].key == key) {
                return this.map[index].value;
            }
            index += 1;
            index = index % this.capacity;
        }
        return -1;
    }

    public boolean remove(int key) {
        if (this.get(key) == -1) return false;
        int index = this.hash(key);
        while (true) {
            if (this.map[index].key == key) {
                this.map[index] = null;
                this.size -= 1;
                return true;
            }
            index += 1;
            index = index % this.capacity;
        }
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    private int hash(int key) {
        return key % this.capacity;
    }

    public void resize() {
       this.capacity = this.capacity * 2;
       Pair[] oldMap = this.map;
       this.map = new Pair[this.capacity];
       this.size = 0;
       for (Pair pair : oldMap) {
           if (pair != null) {
               this.insert(pair.key, pair.value);
           }
       }
    }
}

