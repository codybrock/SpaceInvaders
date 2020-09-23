import java.awt.*;

public class Bunker implements Drawable {
    private int positionX;
    private int positionY;

    public Bunker(int x, int y) {
        positionX = x;
        positionY = y;
    }

    // sprite 48x24
    public void draw(Graphics g) {
        //main body
        g.setColor(new Color(0, 240, 0));
        g.fillRect(positionX+6, positionY, 36, 16);
        //arms
        g.fillRect(positionX, positionY+6, 10, 18);
        g.fillRect(positionX+38, positionY+6, 10, 18);
        //corners
        g.fillRect(positionX+4, positionY+2, 10, 16);
        g.fillRect(positionX+2, positionY+4, 10, 16);
        g.fillRect(positionX+34, positionY+2, 10, 16);
        g.fillRect(positionX+36, positionY+4, 10, 16);
    }
}