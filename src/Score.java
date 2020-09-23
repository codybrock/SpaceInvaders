import java.awt.*;
import java.io.Serializable;

public class Score implements Drawable, Serializable {
    private int positionX = 10;
    private int positionY = 30;
    private static int score = 0;

    public Score () {
    }

    public Score(int x, int y) {
        positionX = x;
        positionY = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        Font myFont = new Font ("Consolas", 1, 24);
        g.setFont(myFont);
        g.drawString("SCORE: " + score, positionX, positionY);
    }

    public void increment() {
        score++;
    }

    public int getScore() {
        return score;
    }
}