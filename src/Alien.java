import java.awt.*;

public class Alien {
    private boolean isAlive;
    private int positionX;
    private int positionY;

    Alien(int x, int y) {
        isAlive = true;
        positionX = x;
        positionY = y;
    }

    // sprite 24x16
    public void draw(Graphics go) {
        go.setColor(Color.WHITE);
        int pixels[][] = {   {2,0,2,0}, {9,0,9,0}, {3,1,3,1}, {8,1,8,1}, {2,2,9,2}, {1,3,2,3},
                                    {4,3,7,3}, {9,3,10,3}, {0,4,11,4}, {0,5,0,5},{2,5,9,5}, {11,5,11,5},
                                    {0,6,0,6}, {2,6,2,6}, {9,6,9,6}, {11,6,11,6}, {3,7,4,7}, {7,7,8,7} };
        for (int i = 0; i < pixels.length; i++) {
            go.drawLine(positionX + 2*pixels[i][0], positionY + 2*pixels[i][1],
                        positionX + 2*pixels[i][2]+1, positionY + 2*pixels[i][3]);

            go.drawLine(positionX + 2*pixels[i][0], positionY + 2*pixels[i][1]+1,
                    positionX + 2*pixels[i][2]+1, positionY + 2*pixels[i][3]+1);
        }

    }

    public void left() { positionX -= 10; }

    public void right() { positionX += 10; }

    public void advance() {  positionY += 14; }
}