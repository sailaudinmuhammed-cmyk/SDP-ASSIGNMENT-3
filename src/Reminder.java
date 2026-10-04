public class Reminder extends Notification {

    public Reminder(String text, MesseageChannel channel) {
        super(text, channel);
    }

    @Override
    public String execute() {
        return implementation.send(text);
    }
}