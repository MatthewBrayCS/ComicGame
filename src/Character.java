import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Character {

    private String name;
    private String desc;
    private String faction;
    private String group;

    private int strength;
    private int dexterity;
    private int constitution;
    private int maxhealth;

    private String[] moves = new String[4];
    private String[] movname = new String[4];
    private String[] movdesc = new String[4];
    private int healFactor;
    private boolean flying = false;
    private String[] weaknessNames;
    private String[] weaknessCodes;
    private String[] resistanceNames;
    private String[] resistanceCodes;

    private BufferedImage img[] = new BufferedImage[5];

    Character(String nam, String descrip, String fac, String gro, int str, int dex, int con, String[] move, String[] movnames, String[] movdescrip, String traits, String weakness, String resistance) {
        //setup character stat values
        name = nam;
        desc = descrip;
        faction = fac;
        group = gro;

        strength = str;
        dexterity = dex;
        constitution = con;
        calcmaxhp();

        readMoves(move, movnames, movdescrip);
        readTraits(traits);
        readWeakness(weakness);
        readResistance(resistance);

        getimg();
    }

    private void readMoves(String[] move, String[] movnames, String[] movdescrip) {
        for (int i = 0; i < 4; i++) {
            moves[i] = move[i];
            movname[i] = movnames[i];
            movdesc[i] = movdescrip[i];
        }
    }

    private void readResistance(String resistance) {
        resistanceCodes = new String[resistance.length() / 3];
        resistanceNames = new String[resistance.length() / 3];

        for (int i = 0; i < resistance.length(); i += 3) {
            resistanceCodes[i/3] = resistance.substring(i, i+3);
            resistanceNames[i/3] = readCodeName(resistance.substring(i, i+3));
        }
    }

    //read the weaknesses from the character set
    private void readWeakness(String weakness) {
        weaknessCodes = new String[weakness.length() / 3];
        weaknessNames = new String[weakness.length() / 3];

        for (int i = 0; i < weakness.length(); i += 3) {
            weaknessCodes[i/3] = weakness.substring(i, i+3);
            weaknessNames[i/3] = readCodeName(weakness.substring(i, i+3));
        }
    }

    private String readCodeName(String code) {
        switch (code) {
            case "PHY":
                return "Physical";
            case "BUL":
                return "Bullet";
            case "ELE":
                return "Electric";
            case "GRO":
                return "Ground";
            case "LAS":
                return "Laser";
            case "BLA":
                return "Blade";
            case "VIB":
                return "Vibranium";
            case "ADA":
                return "Adamantium";
            case "AVE":
                return "Anti-Venom";
            case "PSY":
                return "Psychic";
            case "ANT":
                return "Size-Changer";
            case "EMP":
                return "EMP";
            case "FIR":
                return "Fire";
            case "EXP":
                return "Explosive";
            case "POI":
                return "Poison";
            case "MAG":
                return "Magic";
            case "RAD":
                return "Radiation";
            case "WAT":
                return "Water";
            case "AIR":
                return "Air";
            default:
                return "Error";
        }
    }

    //read the traits from the character set
    private void readTraits(String traits) {
        if (traits.length() > 0) {
            switch (traits.substring(0, 3)) {
                case "HEL":
                    healFactor = Integer.parseInt("" + traits.charAt(3));
                    if (traits.length() > 4) {
                        readTraits(traits.substring(4));
                    }
                    break;

                case "FLI":
                    flying = true;
                    if (traits.length() > 3) {
                        readTraits(traits.substring(3));
                    }
                    break;
            }
        }
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
        return 30;
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

    public String[] getResistanceCodes() {
        return resistanceCodes;
    }

    public String[] getResistanceNames() {
        return resistanceNames;
    }

    public int getHealFactor() {
        return healFactor;
    }

    public boolean isFlying() {
        return flying;
    }

    public String[] getWeaknessCodes() {
        return weaknessCodes;
    }

    public String[] getWeaknessNames() {
        return weaknessNames;
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
