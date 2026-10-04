public class EmailChannel implements MesseageChannel {

    @Override
    public String send(String text) {
        return "Email envelope\n" + text + "\n\nEnd of the envelope";
    }
}