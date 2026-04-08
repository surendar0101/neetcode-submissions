class DynamicArray {

    private int[] array;
    private int capacity;
    private int length;
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.array = new int[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }
        array[length] = n;
        length++;
    }

    public int popback() {
        if(length > 0) {
            length--;
        }
        return array[length];
    }

    private void resize() {
        capacity *= 2;
        int[] newLength = new int[capacity];
        for(int i = 0; i < length; i++) {
            newLength[i] = array[i];
        }
        array = newLength;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
