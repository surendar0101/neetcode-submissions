class DynamicArray {
    private int[] arr;
    private int capacity;
    private int length;
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[this.capacity];
        this.length = 0;
    }

    public int get(int i) {
        return this.arr[i];
    }

    public void set(int i, int n) {
        this.arr[i] = n;
    }

    public void pushback(int n) {
        if (this.capacity == this.length) {
            resize();
        }
        this.arr[this.length] = n;
        this.length++;
    }

    public int popback() {
        if (this.length > 0) {
            this.length--;
        }
        return this.arr[this.length];
    }

    private void resize() {
        this.capacity *= 2;
        int[] newArray = new int[capacity];
        for(int i=0; i < this.length ; i++) {
            newArray[i] = this.arr[i];
        }
        this.arr = newArray;
    }

    public int getSize() {
        return this.length;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
