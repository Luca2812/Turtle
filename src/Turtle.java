import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Turtle {
    private double x;
    private double y;
    private double dx;
    private double dy;

    private int delay;

    private final Graphics2D graphics;

    public Turtle(int width, int height) {
        JFrame frame = new JFrame("Turtle");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel=new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        graphics=(Graphics2D)panel.getGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        sleep(50);

        x = width/2.0;
        y = height/2.0;
        dx = 1;
        dy = 0;

        delay=0;
    }

    public Turtle() {
        this(800, 800);
    }

    public void setDelay(int millis) {
        delay=Math.max(0, millis);
    }

    public void forward(double length) {
        double toX = x+dx*length;
        double toY = y+dy*length;
        graphics.drawLine((int)x, (int)y, (int)toX, (int)toY);
        x=toX;
        y=toY;
        sleep(delay);
    }

    public void backward(double length) {
        double toX = x-dx*length;
        double toY = y-dy*length;
        graphics.drawLine((int)x, (int)y, (int)toX, (int)toY);
        x=toX;
        y=toY;
        sleep(delay);
    }

    public void left(double angle) {
        angle=-toRadians(angle);
        double newDx=dx*Math.cos(angle)-dy*Math.sin(angle);
        double newDy=dx*Math.sin(angle)+dy*Math.cos(angle);
        dx=newDx;
        dy=newDy;
        sleep(delay);
    }

    public void right(double angle) {
        angle=toRadians(angle);
        double newDx=dx*Math.cos(angle)-dy*Math.sin(angle);
        double newDy=dx*Math.sin(angle)+dy*Math.cos(angle);
        dx=newDx;
        dy=newDy;
        sleep(delay);
    }
    
    private double toRadians(double degrees) {
        return degrees/180*Math.PI;
    }
    private void sleep(int delay) {
        if(delay>0) {
            try {
                Thread.sleep(delay);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}