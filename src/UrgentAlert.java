public class UrgentAlert extends Notification{
    public UrgentAlert(String text, MesseageChannel channel) {
        super(text, channel);
    }

    @Override
    public String execute() {
        return implementation.send("URGENT "+text);
    }
}
