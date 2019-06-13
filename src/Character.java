import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Character {

    private String name;
    private String desc;
    private boolean powered;
    private String faction;
    private String group;

    private int strength;
    private int dexterity;
    private int constitution;
    private int maxap = 30;
    private int maxhealth;

    private String moves[];
    private String movname[];
    private String movdesc[];
    private String traits;
    private String weak;
    private String resist;

    private BufferedImage img[] = new BufferedImage[5];

    public Character(String nam, String descrip, boolean powers, String fac, String gro, int str, int dex, int con, String[] move, String[] movnames,String[] movdescrip, String trait, String weakness,String resistance) {
        //setup character stat values
        name = nam;
        desc = descrip;
        powered = powers;
        faction = fac;
        group = gro;

        strength = str;
        dexterity = dex;
        constitution = con;
        calcmaxhp();

        moves = move;
        movname = movnames;
        movdesc = movdescrip;
        traits = trait;
        weak = weakness;
        resist = resistance;

        getimg();
    }

    private void calcmaxhp() {
        maxhealth = 20 + (3 * constitution);
    }

    private void getimg() {
        //fetch the images from the resources folder. If there is an error it is caught so the image is blank
        try {
            img[0] = ImageIO.read(new File("Resources/" + name + "/Battle.png"));
        } catch (IOException e) {
        }
        for (int i = 0; i < 4; i++) {
            try {
                img[i+1] = ImageIO.read(new File("Resources/" + name + "/" + movname[i] + ".png"));
            } catch (IOException e) {
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getMaxap() {
        return maxap;
    }

    public int getMaxhealth() {
        return maxhealth;
    }

    public int getStrength() {
        return strength;
    }

    public BufferedImage getImg(int image) {
        return img[image];
    }

    public String getDesc() {
        return desc;
    }

    public String getFaction() {
        return faction;
    }

    public String getGroup() {
        return group;
    }

    public String getResist() {
        return resist;
    }

    public String getTraits() {
        return traits;
    }

    public String getWeak() {
        return weak;
    }

    public String getMovdesc(int move) {
        return movdesc[move];
    }

    public String getMoves(int move) {
        return moves[move];
    }

    public String getMovname(int move) {
        return movname[move];
    }
}
