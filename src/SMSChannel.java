public class SMSChannel implements MesseageChannel {

    @Override
    public String send(String text) {
        return "SMS " + text;
    }
}