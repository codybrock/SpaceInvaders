import javax.swing.*;
import java.io.*;

public class ScoreTable {
    private final String FILE = "INVADERS_File.txt";
    private Score score, savedScore;

    public ScoreTable(Score score) { this.score = score; }

    public void save(Score s) {
        if (savedScore.getScore() < score.getScore())
            try {
                File f = new File(FILE);
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                oos.writeObject(score);
                oos.close();
            } catch (Exception ioe) { }
    }

    public void load() {
        try {
            File f = new File(FILE);
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            savedScore = (Score) ois.readObject();
            ois.close();
        } catch (Exception ioe) { }
    }

    public void show (JFrame frame) {
        load();
        JOptionPane.showMessageDialog(frame, "" + savedScore.getScore(), "HALL OF FAME", JOptionPane.PLAIN_MESSAGE);
    }
}