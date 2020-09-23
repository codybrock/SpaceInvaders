import java.awt.*;

public class Ship implements Drawable {
    private int positionX;
    private int positionY;

    Ship(int x, int y) {
        positionX = x;
        positionY = y;
    }

    // sprite 26x16
    public void draw(Graphics go) {
        if(positionX > 430) positionX = 430;
        if(positionY > 430) positionY = 430;
        if(positionX < 50) positionX = 50;
        if(positionY < 50) positionY = 50;

        go.setColor(new Color(0, 240, 0));
        int pixels[][] = {  {6,0,6,0}, {5,1,7,1}, {5,2,7,2}, {1,3,11,3},
                            {0,4,12,4}, {0,5,12,5}, {0,5,12,5}, {0,5,12,5} };
        for (int i = 0; i < pixels.length; i++) {
            go.drawLine(positionX + 2*pixels[i][0], positionY + 2*pixels[i][1],
                    positionX + 2*pixels[i][2]+1, positionY + 2*pixels[i][3]);

            go.drawLine(positionX + 2*pixels[i][0], positionY + 2*pixels[i][1]+1,
                    positionX + 2*pixels[i][2]+1, positionY + 2*pixels[i][3]+1);
        }
    }

    public void left() {
        positionX -= 10;
    }

    public void right() {
        positionX += 10;
    }
}