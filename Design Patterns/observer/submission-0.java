interface Observer {
    void notify(String itemName);
}

class Customer implements Observer {
    private String name;
    private int notifications;

    public Customer(String name) {
        this.name = name;
        this.notifications = 0;
    }

    public void notify(String itemName) {
        this.notifications += 1;
    }

    public int countNotifications() {
        return this.notifications;
    }
}

class OnlineStoreItem {
    private String itemName;
    private int stock;
    private List<Observer> observerList;

    public OnlineStoreItem(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
        this.observerList = new ArrayList<>();
    }

    public void subscribe(Observer observer) {
        this.observerList.add(observer);
    }

    public void unsubscribe(Observer observer) {
        this.observerList.remove(observer);
    }

    public void updateStock(int newStock) {
        int oldStock = this.stock;
        this.stock = newStock;
        if (oldStock < newStock)
            notifiyObservers();
    }

    private void notifiyObservers() {
        for (Observer observer: observerList)
            observer.notify(this.itemName);
    }
}
