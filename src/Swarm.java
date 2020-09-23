import java.awt.*;

public class Swarm implements Drawable {
    final int cols = 10;
    final int rows = 5;
    final int colSpace = 30;
    final int rowSpace = 22;
    final int topMargin = 50;
    final int leftMargin = 52;
    final int stepLimit = 10;
    final int waitLimitStart = 10;
    final int accelLimit = 1;

    private Alien[][] alien = new Alien[cols][rows];
    private boolean goingRight;
    private int stepCount;
    private int waitLimit;
    private int waitCount;
    private int accelCount;

    Swarm(){
        goingRight = true;      //track movement direction
        stepCount =  stepLimit;        //track how many steps the aliens take each direction before advancing and switching
        waitLimit = waitLimitStart;         //how long the aliens will wait to take a step (speed)
        waitCount = waitLimit;  //tracks how long aliens have waited between steps
        accelCount = accelLimit;         //tracks how many rows aliens go before speeding up (lowering the waitLimit)

        // set start positions for aliens
        int x = leftMargin;
        int y;
        for (int i = 0; i < alien.length; i++)
        {
            y = topMargin;
            for (int j = alien[i].length - 1; j >= 0; j--) {
                alien[i][j] = new Alien(x, y);
                y += rowSpace;
            }
            x += colSpace;
        }

    }


    public void draw(Graphics g) {
        // if we've waited long enough to take a step
        if (waitCount == 0) {
            // Advance a row if it's time
            if(stepCount == 0) {
                stepCount = 10;
                for (int i = 0; i < alien.length; i++)
                    for (int j = 0; j < alien[i].length; j++)
                        alien[i][j].advance();
                goingRight = !goingRight;
                accelCount--;
                // If aliens have advanced 4 times, increase speed
                if (accelCount == 0) {
                    accelCount = 4;
                    waitLimit--;
                    // Don't let waitLimit go lower than 1
                    if (waitLimit == 0)
                        waitLimit = 1;
                }
            }
            // If it's not time to advance, aliens take a step left or right
            else {
                stepCount--;
                for (int i = 0; i < alien.length; i++)
                    for (int j = 0; j < alien[i].length; j++) {
                        if (goingRight)
                            alien[i][j].right();
                        else
                            alien[i][j].left();
                    }
            }
            waitCount = waitLimit;
        }
        // If we haven't waited long enough for a step
        else
            waitCount--;

        // Regardless of what movement happens, draw the aliens.
        for (int i = 0; i < alien.length; i++)
            for (int j = 0; j < alien[i].length; j++)
                alien[i][j].draw(g);

    }



}

