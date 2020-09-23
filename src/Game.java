import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements ActionListener, KeyListener {
    private Level level;
    private Ship ship;
    private Bunker bunker[] = new Bunker[3];
    private Swarm swarm;
    private Score score;
    private ScoreTable scoreTable;

    public Game() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem menuSave = new JMenuItem("Save");
        menu.add(menuSave);
        menuSave.addActionListener(this);
        JMenuItem menuShow = new JMenuItem("Show");
        menu.add(menuShow);
        menuShow.addActionListener(this);
        setJMenuBar(menuBar);

        ship = new Ship(237, 450);
        bunker[0] = new Bunker(90, 380);
        bunker[1] = new Bunker(226, 380);
        bunker[2] = new Bunker(362, 380);
        swarm = new Swarm();
        score = new Score(10, 25);
        level = new Level(ship, bunker, swarm, score);
        scoreTable = new ScoreTable(score);
        scoreTable.load();

        this.getContentPane().add(level);
        this.addKeyListener(this);
    }

    public void startTimer() {
        Timer timer = new Timer(100, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        level.repaint();
    }

    public static void main(String[] args) {
        Game win = new Game();
        win.setSize(516, 562);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.startTimer();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch(keyCode) {
            case KeyEvent.VK_LEFT:	ship.left(); break;
            case KeyEvent.VK_RIGHT: ship.right(); break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }

}