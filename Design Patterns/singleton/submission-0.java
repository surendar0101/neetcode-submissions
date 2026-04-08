static class Singleton {
    private String value;
    private static Singleton singletonClass;
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singletonClass == null) {
            singletonClass = new Singleton();
        }
        return singletonClass;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}