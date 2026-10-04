public abstract class Notification {
    static int nextId = 0;
    protected int id;
    protected String text;
    protected MesseageChannel implementation;

    public Notification(String text, MesseageChannel channel){
        id = ++nextId;
        this.text = text;
        this.implementation = channel;
    }

    public void setImplementation(MesseageChannel implementation){
        this.implementation = implementation;
    }

    public abstract String execute();
}

