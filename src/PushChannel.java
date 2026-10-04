public class PushChannel implements MesseageChannel{
    @Override
    public String send(String text) {
        return "Push" + text + "end of a Push";
    }
}



