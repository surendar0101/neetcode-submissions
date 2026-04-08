class DynamicArray {

    int[] array;
    int length;
    int capacity;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.array = new int[capacity];
    }

    public int get(int i) {
        return this.array[i];
    }

    public void set(int i, int n) {
        this.array[i] = n;
    }

    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }
        this.array[length] = n;
        length++;
    }

    public int popback() {
        if (length > 0) {
            length--;
        }
        return this.array[length];
    }

    private void resize() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        for(int i=0; i<length; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public int getSize() {
        return this.length;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
