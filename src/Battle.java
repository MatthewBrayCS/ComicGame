import javax.swing.*;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Battle extends JFrame {
    public double width;
    public double height;

    public CharacterInstance[] player = new CharacterInstance[4];
    public CharacterInstance[] enemy = new CharacterInstance[4];

    public BufferedImage bg;

    Random rand = new Random();

    JPanel pane;

    JPanel playerboxes[] = new JPanel[4];
    JLabel pname[] = new JLabel[4];
    JLabel phealth[] = new JLabel[4];
    JLabel pap[] = new JLabel[4];
    JLabel pstr[] = new JLabel[4];
    JLabel pdex[] = new JLabel[4];
    JLabel pcon[] = new JLabel[4];
    JPanel pimage[] = new JPanel[4];

    JPanel enemyboxes[] = new JPanel[4];
    JLabel ename[] = new JLabel[4];
    JLabel ehealth[] = new JLabel[4];
    JLabel eap[] = new JLabel[4];
    JLabel estr[] = new JLabel[4];
    JLabel edex[] = new JLabel[4];
    JLabel econ[] = new JLabel[4];
    JPanel eimage[] = new JPanel[4];

    JTextArea moveinfo = new JTextArea("move info");
    JButton movebutton[] = new JButton[4];
    JButton moveconfirm = new JButton("Confirm");
    JLabel moveap = new JLabel("Action Points to spend: " + "");
    JPanel movebox = new JPanel();
    JTextArea infolab = new JTextArea("");
    JPanel infobox = new JPanel();
    JButton defend = new JButton("Defend");
    JButton fight = new JButton("Fight");
    JLabel turnap = new JLabel("Action Points to spend: " + "");
    JPanel turnbox = new JPanel();

    JLabel effective[][] = new JLabel[2][4];
    JLabel ineffective[][] = new JLabel[2][4];

    public int curchar;
    public int curmove;

    public String initiative[] = new String[8];
    public int inipointer = 7;
    public boolean playerturn;
    public boolean targetfriendly = false;
    public boolean targetenemy = false;

    public Character attacker;
    public Character target[];

//    public ActionListener movelistener = new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.out.println(width);
//            for (int i = 0; i < 4; i++) {
//                if (e.getSource() == movebutton[i]) {
//                    curmove = i;
//                    attacker = player[curchar];
//                    moveinfo.setText(player[curchar].movdesc[curmove]);
//                    moveinfo.setVisible(true);
//                    moveconfirm.setVisible(true);
//                }
//            }
//            if (e.getSource() == moveconfirm) {
//                attacker.currap += 5;
//                final BufferedImage pic = player[curchar].img[curmove+1];
//                pimage[curchar].setVisible(false);
//                pimage[curchar] = new JPanel() {
//                    @Override
//                    protected void paintComponent(Graphics g) {
//                        super.paintComponent(g);
//                        g.drawImage(pic, 0, 0, 230, 460, null);
//                    }
//                };
//                pimage[curchar].setLayout(null);
//                pimage[curchar].setOpaque(false);
//                pane.add(pimage[curchar]);
//                pimage[curchar].addMouseListener(imglistener);
//                pimage[curchar].setBounds(10 + (240 * curchar), 350, 230, 460);
//                pimage[curchar].setVisible(true);
//                switch (curmove) {
//                    case 1:
//                        attacker.currap -= 10;
//                        break;
//                    case 2:
//                        attacker.currap -= 15;
//                        break;
//                    case 3:
//                        attacker.currap -= 20;
//                        break;
//                }
//                moveinfo.setVisible(false);
//                moveconfirm.setVisible(false);
//                movebox.setVisible(false);
//                readmove();
//            }
//        }
//    };
//
//    public ActionListener action = new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            turnbox.setVisible(false);
//            if (defend == e.getSource()) {
//                infobox.setVisible(true);
//                infolab.setText(player[curchar].name + " is blocking");
//                player[curchar].blocking++;
//                player[curchar].currap += 10;
//                updatestats();
//                turnwait wait = new turnwait();
//                wait.start();
//            } else {
//                for (int i = 0; i < 4; i++) {
//                    movebutton[i].setText(player[curchar].movname[i]);
//                }
//                moveap.setText("Action Points to spend: " + player[curchar].currap);
//                movebox.setVisible(true);
//            }
//        }
//    };
//
//    public MouseListener imglistener = new MouseListener() {
//        @Override
//        public void mouseClicked(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//
//        }
//    };

    public Battle(CharacterInstance a, CharacterInstance b, CharacterInstance c, CharacterInstance d, CharacterInstance e, CharacterInstance f, CharacterInstance g, CharacterInstance h, BufferedImage background) {
        bg = background;
        player[0] = a;
        player[1] = b;
        player[2] = c;
        player[3] = d;
        enemy[0] = e;
        enemy[1] = f;
        enemy[2] = g;
        enemy[3] = h;

        this.setLayout(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(Toolkit.getDefaultToolkit().getScreenResolution());
        //attempts to scale the resolution to the screen
        width = screensize.width / 1920;
        height = screensize.height / 1080;

        //set background image
        final BufferedImage back = bg;
        pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(back, 0, 0, (int)(width * 1920), 1080, null);
            }
        };
        pane.setBounds(0, 0, (int)(width * 1920), 1080);
        pane.setLayout(null);
        this.add(pane);
        pane.setVisible(true);

        //player statbox and image
        int x = (int)(width * 10);
        int y = (int)(height * 820);
        for (int i = 0; i < 4; i++) {
            playerboxes[i] = new JPanel();
            playerboxes[i].setLayout(null);
            pane.add(playerboxes[i]);
            playerboxes[i].setBounds((int)(width * x), (int)(height * y), (int)(width * 230), (int)(height * 180));
            playerboxes[i].setVisible(true);

            pname[i] = new JLabel(player[i].getStats().getName());
            pname[i].setHorizontalAlignment(SwingConstants.CENTER);
            playerboxes[i].add(pname[i]);
            pname[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
            pname[i].setBounds(0, 0, (int)(width * 230), (int)(height * 30));
            pname[i].setVisible(true);

            phealth[i] = new JLabel("Health: " + player[i].getCurrentHealth() + "/" + player[i].getStats().getMaxhealth());
            phealth[i].setHorizontalAlignment(SwingConstants.CENTER);
            playerboxes[i].add(phealth[i]);
            phealth[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
            phealth[i].setBounds(0, (int)(height * 30), (int)(width * 230), (int)(height * 30));
            phealth[i].setVisible(true);

            pap[i] = new JLabel("Action Points: " + player[i].getCurrentAP() + "/" + player[i].getStats().getMaxap());
            pap[i].setHorizontalAlignment(SwingConstants.CENTER);
            playerboxes[i].add(pap[i]);
            pap[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
            pap[i].setBounds(0, (int)(height * 60), (int)(width * 230), (int)(height * 30));
            pap[i].setVisible(true);

            pstr[i] = new JLabel("Strength: " + player[i].getStats().getStrength());
            pstr[i].setHorizontalAlignment(SwingConstants.CENTER);
            playerboxes[i].add(pstr[i]);
            pstr[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
            pstr[i].setBounds(0, (int)(height * 90), (int)(width * 230), (int)(height * 30));
            pstr[i].setVisible(true);

            pdex[i] = new JLabel("Dexterity: " + player[i].getStats().getDexterity());
            pdex[i].setHorizontalAlignment(SwingConstants.CENTER);
            playerboxes[i].add(pdex[i]);
            pdex[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
            pdex[i].setBounds(0, (int)(height * 120), (int)(width * 230), (int)(height * 30));
            pdex[i].setVisible(true);

            pcon[i] = new JLabel("Constitution: " + player[i].getStats().getConstitution());
            pcon[i].setHorizontalAlignment(SwingConstants.CENTER);
            playerboxes[i].add(pcon[i]);
            pcon[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
            pcon[i].setBounds(0, (int)(height * 150), (int)(width * 230), (int)(height * 30));
            pcon[i].setVisible(true);

            final BufferedImage pic = player[i].getStats().getImg()[0];
            pimage[i] = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(pic, 0, 0, (int)(width * 230), (int)(height * 460), null);
                }
            };
            pimage[i].setLayout(null);
            pimage[i].setOpaque(false);
            //pimage[i].addMouseListener(imglistener);                                                      LISTENER
            pane.add(pimage[i]);
            pimage[i].setBounds((int)(width * x), (int)(height * (y - 470)), (int)(width * 230), (int)(height * 460));
            pimage[i].setVisible(true);

            x += (int)(width * 240);
        }

        //enemy stat box and image
        x = (int)(width * 960);
        y = 10;
        for (int i = 0; i < 4; i++) {
            enemyboxes[i] = new JPanel();
            enemyboxes[i].setLayout(null);
            pane.add(enemyboxes[i]);
            enemyboxes[i].setBounds((int)(width * x), (int)(height * y), (int)(width * 230), (int)(height * 180));
            enemyboxes[i].setVisible(true);

            ename[i] = new JLabel(enemy[i].getStats().getName());
            ename[i].setHorizontalAlignment(SwingConstants.CENTER);
            enemyboxes[i].add(ename[i]);
            ename[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
            ename[i].setBounds(0, 0, (int)(width * 230), (int)(height * 30));
            ename[i].setVisible(true);

            ehealth[i] = new JLabel("Health: " + enemy[i].getCurrentHealth() + "/" + enemy[i].getStats().getMaxhealth());
            ehealth[i].setHorizontalAlignment(SwingConstants.CENTER);
            enemyboxes[i].add(ehealth[i]);
            ehealth[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
            ehealth[i].setBounds(0, (int)(height * 30), (int)(width * 230), (int)(height * 30));
            ehealth[i].setVisible(true);

            eap[i] = new JLabel("Action Points: " + enemy[i].getCurrentAP() + "/" + enemy[i].getStats().getMaxap());
            eap[i].setHorizontalAlignment(SwingConstants.CENTER);
            enemyboxes[i].add(eap[i]);
            eap[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
            eap[i].setBounds(0, (int)(height * 60), (int)(width * 230), (int)(height * 30));
            eap[i].setVisible(true);

            estr[i] = new JLabel("Strength: " + enemy[i].getStats().getStrength());
            estr[i].setHorizontalAlignment(SwingConstants.CENTER);
            enemyboxes[i].add(estr[i]);
            estr[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
            estr[i].setBounds(0, (int)(height * 90), (int)(width * 230), (int)(height * 30));
            estr[i].setVisible(true);

            edex[i] = new JLabel("Dexterity: " + enemy[i].getStats().getDexterity());
            edex[i].setHorizontalAlignment(SwingConstants.CENTER);
            enemyboxes[i].add(edex[i]);
            edex[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
            edex[i].setBounds(0, (int)(height * 120), (int)(width * 230), (int)(height * 30));
            edex[i].setVisible(true);

            econ[i] = new JLabel("Constitution: " + enemy[i].getStats().getConstitution());
            econ[i].setHorizontalAlignment(SwingConstants.CENTER);
            enemyboxes[i].add(econ[i]);
            econ[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
            econ[i].setBounds(0, (int)(height * 150), (int)(width * 230), (int)(height * 30));
            econ[i].setVisible(true);

            final BufferedImage pic = enemy[i].getStats().getImg()[0];
            eimage[i] = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(pic, (int)(width * 230), 0, (int)(width * -230), (int)(height * 460), null);
                }
            };
            eimage[i].setLayout(null);
            eimage[i].setOpaque(false);
            //eimage[i].addMouseListener(imglistener);                                                              LISTENER
            pane.add(eimage[i]);
            eimage[i].setBounds((int)(width * x), (int)(height * (y + 190)), (int)(width * 230), (int)(height * 460));
            eimage[i].setVisible(true);

            x += (int)(width * 240);
        }

        //box for player to take their turn and the options within
        turnbox.setLayout(null);
        pane.add(turnbox);
        turnbox.setBounds((int)(width * 1150), (int)(height * 725), (int)(width * 600), (int)(height * 250));
        turnbox.setVisible(false);

        turnap.setHorizontalAlignment(SwingConstants.CENTER);
        turnbox.add(turnap);
        turnap.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        turnap.setBounds(0, 0, (int)(width * 600), (int)(height * 30));
        turnap.setVisible(true);

        turnbox.add(fight);
        //fight.addActionListener(action);                                                      LISTENER
        fight.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 26));
        fight.setBounds((int)(width * 50), (int)(height * 50), (int)(width * 250), (int)(height * 150));
        fight.setVisible(true);

        turnbox.add(defend);
        //defend.addActionListener(action);                                                     LISTENER
        defend.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 26));
        defend.setBounds((int)(width * 310), (int)(height * 50), (int)(width * 250), (int)(height * 150));
        defend.setVisible(true);

        infobox.setLayout(null);
        pane.add(infobox);
        infobox.setBounds((int)(width * 1150), (int)(height * 725), (int)(width * 600), (int)(height * 250));
        infobox.setVisible(false);

        infolab.setAlignmentX(SwingConstants.CENTER);
        infolab.setAlignmentY(SwingConstants.CENTER);
        infolab.setOpaque(false);
        infolab.setLineWrap(true);
        infolab.setWrapStyleWord(true);
        infolab.setEditable(false);
        infobox.add(infolab);
        infolab.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        infolab.setBounds((int)(width * 10), (int)(height * 100), (int)(width * 600), (int)(height * 100));
        infolab.setVisible(true);

        movebox.setLayout(null);
        pane.add(movebox);
        movebox.setBounds((int)(width * 1150), (int)(height * 725), (int)(width * 600), (int)(height * 250));
        movebox.setVisible(false);


        moveap.setHorizontalAlignment(SwingConstants.CENTER);
        movebox.add(moveap);
        moveap.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        moveap.setBounds(0, 0, (int)(width * 600), (int)(height * 30));
        moveap.setVisible(true);

        x = (int)(width * 10);
        y = (int)(height * 30);
        for (int i = 0; i < 4; i++) {
            movebutton[i] = new JButton("");
            movebox.add(movebutton[i]);
            movebutton[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
            movebutton[i].setBounds((int)(width * x), (int)(height * y), (int)(width * 140), (int)(height * 100));
            //movebutton[i].addActionListener(movelistener);                                                    LISTENER
            movebutton[i].setMargin(new Insets(0,0,0,0));
            movebutton[i].setVisible(true);
            movebutton[i].setLayout(null);
            x += (int)(width * 150);
            if (i == 1) {
                x = (int)(width * 10);
                y += (int)(height * 110);
            }
        }

        y += 50;
        movebox.add(moveconfirm);
        moveconfirm.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        //moveconfirm.addActionListener(movelistener);                                                          LISTENER
        moveconfirm.setBounds((int)(width * x), (int)(height * y), (int)(width * 280), (int)(height * 50));
        moveconfirm.setVisible(false);

        moveinfo.setAlignmentX(SwingConstants.CENTER);
        moveinfo.setAlignmentY(SwingConstants.CENTER);
        moveinfo.setOpaque(false);
        moveinfo.setLineWrap(true);
        moveinfo.setWrapStyleWord(true);
        moveinfo.setEditable(false);
        movebox.add(moveinfo);
        moveinfo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        moveinfo.setBounds((int)(width * 310), (int)(height * 30), (int)(width * 290), (int)(height * 140));
        moveinfo.setVisible(false);

        //labels about effectiveness to be displayed from threads
        x = (int)(width * 10);
        y = (int)(height * 895);
        for (int i = 0; i < 4; i++) {
            effective[0][i] = new JLabel("Very Effective");
            effective[0][i].setHorizontalAlignment(SwingConstants.CENTER);
            pimage[i].add(effective[0][i]);
            effective[0][i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
            effective[0][i].setBounds(0, (int)(height * 120), (int)(width * 230), (int)(height * 30));
            effective[0][i].setBackground(Color.white);
            effective[0][i].setOpaque(true);
            effective[0][i].setVisible(false);

            ineffective[0][i] = new JLabel("Not Very Effective");
            ineffective[0][i].setHorizontalAlignment(SwingConstants.CENTER);
            pimage[i].add(ineffective[0][i]);
            ineffective[0][i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
            ineffective[0][i].setBounds(0, (int)(height * 120), (int)(width * 230), (int)(height * 30));
            ineffective[0][i].setBackground(Color.white);
            ineffective[0][i].setOpaque(true);
            ineffective[0][i].setVisible(false);

            effective[1][i] = new JLabel("Very Effective");
            effective[1][i].setHorizontalAlignment(SwingConstants.CENTER);
            eimage[i].add(effective[1][i]);
            effective[1][i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
            effective[1][i].setBounds(0, (int)(height * 120), (int)(width * 230), (int)(height * 30));
            effective[1][i].setBackground(Color.white);
            effective[1][i].setOpaque(true);
            effective[1][i].setVisible(false);

            ineffective[1][i] = new JLabel("Not Very Effective");
            ineffective[1][i].setHorizontalAlignment(SwingConstants.CENTER);
            eimage[i].add(ineffective[1][i]);
            ineffective[1][i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
            ineffective[1][i].setBounds(0, (int)(height * 120), (int)(width * 230), (int)(height * 30));
            ineffective[1][i].setBackground(Color.white);
            ineffective[1][i].setOpaque(true);
            ineffective[1][i].setVisible(false);
        }

        //simulates a standard Role-playing game initiative roll to see what order characters take their turn
        int rolls[] = new int[8];
        for (int i = 0; i < 8; i++) {
            rolls[i] = (int)(rand.nextInt(20)+1);
            if (i < 4) {
                rolls[i] += player[i].getStats().getDexterity();
            } else {
                rolls[i] += enemy[i-4].getStats().getDexterity();
            }
        }
        int selected;
        //stores strings in an array indicating the order for the characters
        for (int i = 0; i < 8; i++) {
            selected = 0;
            for (int j = 1; j < 8; j++) {
                if (rolls[j] > rolls[selected]) {
                    selected = j;
                }
            }
            if (selected < 4) {
                initiative[i] = "p" + selected;
            } else {
                initiative[i] = "e" + (selected - 4);
            }
            rolls[selected] = -1;
        }

        //nextturn(); TODO

    }

//    public void enemyturn(Character curr) {
//        System.out.println(curr.name);
//        playerturn = false;
//    }
//
//    public void taketurn(Character curr) {
//        playerturn = true;
//        System.out.println(curr.name);
//        playerboxes[curchar].setBackground(Color.ORANGE);
//        if (curr.stunned > 0) {
//            curr.stunned--;
//            infobox.setVisible(true);
//            infolab.setText(curr.name + " is stunned and misses a turn");
//            turnwait wait = new turnwait();
//            wait.start();
//        } else {
//            turnbox.setVisible(true);
//            turnap.setText("Action Points to spend: " + player[curchar].currap);
//        }
//    }
//
//    public void nextturn() {
//        movebox.setVisible(false);
//        infobox.setVisible(false);
//        for(int i = 0; i < 4; i++) {
//            playerboxes[i].setBackground(Color.white);
//        }
//        if (inipointer == 7) {
//            inipointer = 0;
//        } else {
//            inipointer++;
//        }
//        if (initiative[inipointer].charAt(0) == 'p') {
//            curchar = Integer.parseInt("" + initiative[inipointer].charAt(1));
//            taketurn(player[curchar]);
//        } else {
//            curchar = Integer.parseInt("" + initiative[inipointer].charAt(1));
//            enemyturn(enemy[curchar]);
//       }
//
//       /* for (int i = 0; i < 4; i++) {
//            if (initiative[inipointer] == player[i].name) {
//                curchar = i;
//                taketurn(player[i]);
//            }
//            if (initiative[inipointer] == enemy[i].name) {
//                curchar = i;
//                enemyturn(enemy[i]);
//            }
//
//        }
//            */
//    }
//
//    public void updatestats() {
//        for (int i = 0; i < 4; i++) {
//            phealth[i].setText("Health: " + player[i].currhealth + "/" + player[i].maxhealth);
//            pap[i].setText("Action Points: " + player[i].currap + "/" + player[i].maxap);
//            ehealth[i].setText("Health: " + enemy[i].currhealth + "/" + enemy[i].maxhealth);
//            eap[i].setText("Action Points: " + enemy[i].currap + "/" + enemy[i].maxap);
//        }
//    }
//
//    public void readmove() {
//        int pointer = 0;
//        String move = attacker.moves[curmove];
//        switch (move.substring(pointer, pointer + 3)) {
//            case "SEL":
//                pointer += 3;
//                switch (move.substring(pointer, pointer + 3)) {
//                    case "HEL":
//                        pointer += 3;
//                        double amount = Integer.parseInt(move.substring(pointer, pointer + 3)) / 100.0;
//                        char stun = move.charAt(9);
//                        amount = amount * attacker.maxhealth;
//                        attacker.currhealth += amount;
//                        if (attacker.currhealth > attacker.maxhealth) {
//                            attacker.currhealth = attacker.maxhealth;
//                        }
//                        updatestats();
//                        if (stun == '0') {
//                            infobox.setVisible(true);
//                            infolab.setText(attacker.name + " used " + attacker.movname[curmove]);
//                            turnwait wait = new turnwait();
//                            wait.start();
//                        } else {
//                            attacker.stunned += 1;
//                            infobox.setVisible(true);
//                            infolab.setText(attacker.name + " used " + attacker.movname[curmove] + " and is now stunned");
//                            turnwait wait = new turnwait();
//                            wait.start();
//                        }
//                        break;
//                    case "DEF":
//                        pointer += 3;
//                        int turns = Integer.parseInt("" + move.charAt(pointer));
//                        attacker.blocking += turns;
//                        infobox.setVisible(true);
//                        infolab.setText(attacker.name + " used " + attacker.movname[curmove] + " and takes reduced damage for " + turns + " turns");
//                        updatestats();
//                        turnwait wait = new turnwait();
//                        wait.start();
//                }
//                break;
//            case "SUP":
//                pointer += 4;
//                switch (move.substring(pointer, pointer + 3)) {
//                    case "STU":
//
//                        break;
//                }
//                break;
//        }
//    }
//
//    class turnwait extends Thread {
//
//        public void run() {
//            try {
//                Thread.sleep(2500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            nextturn();
//        }
//    }
//
//
//
//    class Effective extends Thread {
//        boolean good;
//        int team;
//        int who;
//        public Effective(boolean a, int b, int c) {
//            good = a;
//            team = b;
//            who = c;
//        }
//
//        public void run() {
//            if (good) {
//                effective[team][who].setVisible(true);
//                try {
//                    Thread.sleep(2500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                effective[team][who].setVisible(false);
//            } else {
//                ineffective[team][who].setVisible(true);
//                try {
//                    Thread.sleep(2500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                ineffective[team][who].setVisible(false);
//            }
//        }
//    }
}
