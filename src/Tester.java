import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        CharacterSet chars = new CharacterSet();
        Random rand = new Random();
        int bgnum = rand.nextInt(3) + 1;
        BufferedImage bg = null;
        try {
            bg = ImageIO.read(new File("Resources/Backgrounds/Background" + bgnum + ".png"));
        } catch (IOException e) {
        }

        CharacterInstance[] fightCharacters = new CharacterInstance[8];
        fightCharacters[0] = new CharacterInstance(chars.getAvengers()[6]);
        fightCharacters[1] = new CharacterInstance( chars.getAvengers()[18]);
        fightCharacters[2] = new CharacterInstance( chars.getAvengers()[23]);
        fightCharacters[3] = new CharacterInstance( chars.getAvengers()[9]);
        fightCharacters[4] = new CharacterInstance( chars.getAvengers()[15]);
        fightCharacters[5] = new CharacterInstance( chars.getAvengers()[5]);
        fightCharacters[6] = new CharacterInstance( chars.getAvengers()[30]);
        fightCharacters[7] = new CharacterInstance( chars.getAvengers()[7]);

        String[] weak = fightCharacters[1].getStats().getResistanceCodes();
        String[] weak2 = fightCharacters[1].getStats().getResistanceNames();
        for (int i = 0; i < weak.length; i++) {
            System.out.println(weak[i]);
            System.out.println(weak2[i]);
        }

        Battle fight = new Battle(fightCharacters[0],fightCharacters[1],fightCharacters[2],fightCharacters[3],fightCharacters[4],fightCharacters[5],fightCharacters[6],fightCharacters[7], bg);
        fight.setDefaultCloseOperation(3);
        fight.setLayout(null);
        fight.setBounds(0,0,1920,1080);
        fight.setVisible(true);
        fight.setExtendedState(Frame.MAXIMIZED_BOTH);
    }

}
