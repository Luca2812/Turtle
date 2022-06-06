public class Main {
    public static void main(String[] args) {
        Turtle t=new Turtle();
        t.setDelay(10);
        for(int i = 0; i<360; i++) {
            t.forward(1);
            t.left(1);
        }
    }
}