import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class Level extends JPanel {

    private Drawable[] items = new Drawable[6];

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawLine(4, 4, 4, 495);
        g.drawLine(5, 4, 5, 495);

        g.drawLine( 495, 4,495, 495);
        g.drawLine( 494, 4,494, 495);


        g.drawLine(4, 4, 495, 4);
        g.drawLine(4, 5, 495, 5);

        g.drawLine( 4, 495,495, 495);
        g.drawLine( 4, 494,495, 494);

        g.drawLine( 4, 30,495, 30);
        //g.drawLine( 4, 31,495, 31);



        for (int i = 0; i < items.length; i++)
            items[i].draw(g);


        /*test draw edges
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, 20, 20);
        g.fillRect(480, 0, 20, 20);

        g.setColor(Color.BLUE);
        g.fillRect(20, 0, 5, 40);

         */

    }

    Level(Ship ship, Bunker bunker[], Swarm swarm, Score score) {
        super.setBackground(Color.BLACK);
        items[0] = ship;
        items[1] = bunker[0];
        items[2] = bunker[1];
        items[3] = bunker[2];
        items[4] = swarm;
        items[5] = score;
    }
}