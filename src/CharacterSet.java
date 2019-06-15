import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class CharacterSet {

    private Character[] avengers = new Character[31];

    CharacterSet() {
    String[] moveset = new String[4];
    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0L2PHYVIB1HAP";
    moveset[2] = "DAM0M2PHYVIB0";
    moveset[3] = "SELDEF3";

    String[] movenam = new String[4];
    movenam[0] = "Punch";
    movenam[1] = "Shield Throw";
    movenam[2] = "Shield Bash";
    movenam[3] = "Shield Defence";

    String[] movebio = new String[4];
    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Throw your shield at an enemy, dealing low damage and hitting their AP. Types: Physical";
    movebio[2] = "Hit an enemy with your shield, dealing medium damage and stunning them for a turn. Types: Physical";
    movebio[3] = "Adopt a defensive position with your shield, allowing you to take reduced damage for 3 turns while still able to attack.";

    avengers[0] = new Character("Captain America","",
            "Avengers","S.H.I.E.L.D",5,6,6,  moveset, movenam,
            movebio, "HEL3","","EMP");
    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M1BUL0";
    moveset[2] = "DAM1M1BUL0";
    moveset[3] = "DAM0H1PHY0";

    movenam[0] = "Punch";
    movenam[1] = "Fire Pistol";
    movenam[2] = "Fire Rifle";
    movenam[3] = "Bionic Punch";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Fire your pistol at an enemy, dealing medium damage. Types: Bullet";
    movebio[2] = "Fire your assault rifle at the group of enemies dealing medium damage. Types: Bullet";
    movebio[3] = "Hit an enemy with your metal arm, dealing high damage to them. Types: Physical";

    avengers[1] = new Character("Winter Soldier","",
            "Avengers","S.H.I.E.L.D",5,5,6,  moveset, movenam,
            movebio, "HEL2","EMP","PHY");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM1L1PHY0";
    moveset[2] = "DAM0M1PHY0";
    moveset[3] = "DAM0H1PHY0";

    movenam[0] = "Punch";
    movenam[1] = "Bird Attack";
    movenam[2] = "Kick";
    movenam[3] = "Swoop";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Send a flock of birds to attack the enemies dealing low damage to them. Types: Physical";
    movebio[2] = "Kick an enemy to deal medium damage to them. Types: Physical";
    movebio[3] = "Swoop down on an enemy from the sky to deal high damage to them. Types: Physical";

    avengers[2] = new Character("Falcon","",
            "Avengers","S.H.I.E.L.D",3,6,5,  moveset, movenam,
            movebio, "FLI","EMP","");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M1PHY0";
    moveset[2] = "DAM0M1ELE1STU";
    moveset[3] = "DAM1M3PHYELEGRO0";

    movenam[0] = "Punch";
    movenam[1] = "Hammer Throw";
    movenam[2] = "Lightning Strike";
    movenam[3] = "Hammer Smash";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Throw your hammer at an enemy to deal medium damage. Types: Physical";
    movebio[2] = "Call a lightning strike down on an enemy, dealing medium damage and stunning them for a turn. Types: Electrical";
    movebio[3] = "Smash your hammer into the ground with your lightning powers dealing high damage to all enemies. Types: Physical, Electrical, Ground";

    avengers[3] = new Character("Thor","",
            "Avengers","Asgardians",10,6,8,  moveset, movenam,
            movebio, "HEL5","","ELEEMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M1BLA0";
    moveset[2] = "DAM0M1PHY1STU";
    moveset[3] = "DAM0H1BLA0";

    movenam[0] = "Punch";
    movenam[1] = "Slash";
    movenam[2] = "Takedown";
    movenam[3] = "Stab";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Slash at an enemy with your sword to deal medium damage. Types: Bladed";
    movebio[2] = "Use your spear to hit an enemy and take them off balance, dealing medium damage and stunning them for a turn. Types: Physical";
    movebio[3] = "Stab at an enemy with your spear and sword to deal high damage to them. Types: Bladed";

    avengers[4] = new Character("Valkyrie","",
            "Avengers","Asgardians",8,6,6,  moveset, movenam,
            movebio, "HEL3","","EMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M1BLA0";
    moveset[2] = "SELDEF2";
    moveset[3] = "DAM0H1BLA0";

    movenam[0] = "Punch";
    movenam[1] = "Slash";
    movenam[2] = "Precognition";
    movenam[3] = "Impale";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Slash at an enemy with your sword to deal medium damage. Types: Bladed";
    movebio[2] = "Use your all-seeing powers to predict the enemies moves and take less damage from them for 2 turns.";
    movebio[3] = "Stab at an enemy with your sword to deal high damage to them. Types: Bladed";

    avengers[5] = new Character("Heimdall","",
            "Avengers","Asgardians",8,7,6,  moveset, movenam,
            movebio, "HEL3","","EMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M1LAS0";
    moveset[2] = "DAM0H1LAS0";
    moveset[3] = "SELHEL0750";

    movenam[0] = "Punch";
    movenam[1] = "Repulsor Blast";
    movenam[2] = "Unibeam";
    movenam[3] = "Self Repair";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Blast an enemy with your repulsors to deal medium damage to them. Types: Laser";
    movebio[2] = "Blast an enemy with your Unibeam to deal high damage to them. Type: Laser";
    movebio[3] = "Use your self-repair technology to heal 75% of your health. (cannot go above max health)";

    avengers[6] = new Character("Iron Man","",
            "Avengers","Iron Man & War Machine",10,7,4,  moveset, movenam,
            movebio, "FLI","EMP","ELEBULBLAFIRLAS");

    moveset[0] = "DAM0L1LAS0";
    moveset[1] = "DAM1L1BUL0";
    moveset[2] = "DAM0M1FIR0";
    moveset[3] = "DAM1M1EXP0";

    movenam[0] = "Repulsor";
    movenam[1] = "Minigun";
    movenam[2] = "Flamethrower";
    movenam[3] = "Rocket";

    movebio[0] = "Blast an enemy with your repulsors to deal low damage to them. Types: Laser";
    movebio[1] = "Spray the enmies with your minigun to deal low damage to them all. Types: Bullet";
    movebio[2] = "Use your flamethrower on an enemy to deal medium damage to them. Types: Fire";
    movebio[3] = "Fire a rocket at the enemies dealing medium damage to them all. Types: Explosive";

    avengers[7] = new Character("War Machine","",
            "Avengers","Iron Man & War Machine",9,6,5,  moveset, movenam,
            movebio, "FLI","EMP","ELEBULBLAFIRLAS");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "SUP1STU2";
    moveset[2] = "DAM0M1PHY0";
    moveset[3] = "SELHEL0750";

    movenam[0] = "Punch";
    movenam[1] = "Density Manipulation";
    movenam[2] = "Flying Attack";
    movenam[3] = "Self Repair";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Manipulate the density of an enemy so that they are unable to attack or defend for 2 turns.";
    movebio[2] = "Use the momentum of your flight to deal medium damage to an enemy. Types: Physical";
    movebio[3] = "Use your powers to heal 75% of your health. (cannot go above max health)";

    avengers[8] = new Character("Vision","",
            "Avengers","S.H.I.E.L.D",8,6,5,  moveset, movenam,
            movebio, "FLI","EMP","ELEPOI");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "SUP1STU2";
    moveset[2] = "SELDEF2";
    moveset[3] = "DAM0H1PHY0";

    movenam[0] = "Pulled Punch";
    movenam[1] = "Web";
    movenam[2] = "Spider-Sense";
    movenam[3] = "Punch";

    movebio[0] = "A basic attack that deals low damage because Spider Man is holding back. Types: Physical";
    movebio[1] = "Web an enemy to render them unable to act for 2 turns.";
    movebio[2] = "Focus on your spider-senses to help avoid danger, halving damage for 2 turns.";
    movebio[3] = "Hit an enemy, without holding back, dealing high damage to the enemy. Types: Physical";

    avengers[9] = new Character("Spider Man","",
            "Avengers","Spider Totems",9,8,7,  moveset, movenam,
            movebio, "HEL4","","PHYEMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "SUP1STU2";
    moveset[2] = "DAM0M1POI0";
    moveset[3] = "DAM0H1PHY0";

    movenam[0] = "Pulled Punch";
    movenam[1] = "Web";
    movenam[2] = "Venom Blast";
    movenam[3] = "Punch";

    movebio[0] = "A basic attack that deals low damage because Spider Woman is holding back. Types: Physical";
    movebio[1] = "Web an enemy to render them unable to act for 2 turns.";
    movebio[2] = "Blast an enemy with your venom, dealing medium damage to them. Types: Poison";
    movebio[3] = "Hit an enemy, without holding back, dealing high damage to the enemy. Types: Physical";

    avengers[10] = new Character("Spider Woman","",
            "Avengers","Spider Totems",5,7,5,  moveset, movenam,
            movebio, "HEL3","","PHYEMPPOI");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "SUP1STU1";
    moveset[2] = "DAM0M1PHY0";
    moveset[3] = "DAM0H1BLA0";

    movenam[0] = "Punch";
    movenam[1] = "Grappling Hook";
    movenam[2] = "Swinging Kick";
    movenam[3] = "Claws";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Use your grappling hook to tie up an enemy, stunning them for a turn.";
    movebio[2] = "Swing with your grappling hook to kick an enemy, dealing medium damage. Types: Physical";
    movebio[3] = "Claw at an enemy to deal high damage to them. Types: Bladed";

    avengers[11] = new Character("Black Cat","",
            "Avengers","Cats",4,8,5,  moveset, movenam,
            movebio, "","","EMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M1PHY0";
    moveset[2] = "DAM0M1PHY1STU";
    moveset[3] = "DAM0H1LAS0";

    movenam[0] = "Punch";
    movenam[1] = "Kick";
    movenam[2] = "Flying Punch";
    movenam[3] = "Photon Blasts";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Kick an enemy to deal medium damage to them. Types: Physical";
    movebio[2] = "Use your momentum while flying to hit an enemy for medium damage and stun them for a turn. Types: Physcial";
    movebio[3] = "Fire your Photon Blasts at an enemy to deal high damage to them. Types: Laser";

    avengers[12] = new Character("Captain Marvel","",
            "Avengers","S.H.I.E.L.D",8,7,5,  moveset, movenam,
            movebio, "FLI","","PHYEMP");

    moveset[0] = "DAM0L1BLA0";
    moveset[1] = "DAM0M1EMP0";
    moveset[2] = "DAM0M1ELE1STU";
    moveset[3] = "DAM1M1EXP0";

    movenam[0] = "Fire Arrow";
    movenam[1] = "EMP Arrow";
    movenam[2] = "Electric Arrow";
    movenam[3] = "Explosive Arrow";

    movebio[0] = "Fire a basic arrow at an enemy to deal low damage to them. Types: Bladed";
    movebio[1] = "Fire an EMP arrow at an enemy dealing medium damage. Types: EMP";
    movebio[2] = "Fire an electric arrow at an enemy which deals medium damage and stuns them for a turn. Types: Electric";
    movebio[3] = "Fire an explosive arrow at the enemies dealing medium damage to them all. Types: Explosive";

    avengers[13] = new Character("Hawkeye","",
            "Avengers","S.H.I.E.L.D",3,4,4,  moveset, movenam,
            movebio, "","","EMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M1BUL0";
    moveset[2] = "DAM0M1PHY1HAP";
    moveset[3] = "DAM0H2ELEPHY1STU";

    movenam[0] = "Punch";
    movenam[1] = "Fire Pistols";
    movenam[2] = "Kick";
    movenam[3] = "Takedown";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Fire your pistols at an enemy ro deal medium damage to them. Types: Bullet";
    movebio[2] = "Kick an enemy to deal medium damage and hit their AP. Types: Physical";
    movebio[3] = "Use your stun batons and martial arts to take an enemy down, dealing high damage and stunning them for a turn. Types: Electrical, Physical";

    avengers[14] = new Character("Black Widow","",
            "Avengers","S.H.I.E.L.D",3,8,5,  moveset, movenam,
            movebio, "HEL1","","PSYEMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M1PHY0";
    moveset[2] = "DAM0H1PHY0";
    moveset[3] = "DAM1M2PHYGRO0";

    movenam[0] = "Punch";
    movenam[1] = "Kick";
    movenam[2] = "Smash";
    movenam[3] = "Ground Pound";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Kick an enemy to deal medium damage to them. Types: Physical";
    movebio[2] = "Smash an enemy to deal high damage to them. Types: Physical";
    movebio[3] = "Smash the ground to send shockwavesand rubble to hit the enemies for high damage. Types: Physical, Ground";

    avengers[15] = new Character("Hulk","",
            "Avengers","Hulk & She Hulk",10,5,7,  moveset, movenam,
            movebio, "HEL6","VIBADAMAGPSY","PHYBULEXPBLALASEMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M1PHY0";
    moveset[2] = "DAM0H1PHY1STU";
    moveset[3] = "DAM1M2PHYGRO0";

    movenam[0] = "Punch";
    movenam[1] = "Kick";
    movenam[2] = "Takedown";
    movenam[3] = "Ground Pound";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Kick an enemy to deal medium damage to them. Types: Physical";
    movebio[2] = "Take an enemy down to deal high damage and stun them for a turn. Types: Physcial";
    movebio[3] = "Smash the ground to send shockwavesand rubble to hit the enemies for high damage. Types: Physical, Ground";

    avengers[16] = new Character("She Hulk","",
            "Avengers","Hulk & She Hulk",10,5,6,  moveset, movenam,
            movebio, "HEL5","VIBADAMAGPSYRAD","PHYBULEXPBLALASPOIEMP");

    moveset[0] = "DAM0L1WAT0";
    moveset[1] = "SUP1STU2";
    moveset[2] = "DAM0M1GRO0";
    moveset[3] = "DAM0H1GFIR0";

    movenam[0] = "Water Whip";
    movenam[1] = "Freeze";
    movenam[2] = "Rock Crush";
    movenam[3] = "Flames";

    movebio[0] = "Use water to attack the enemy for low damage. Types: Water";
    movebio[1] = "Freeze an enemy stopping them from acting for 2 turns.";
    movebio[2] = "Use rocks to crush your enemy for medium damage. Types: Ground";
    movebio[3] = "Use flames to burn your enemy for high damage. Types: Fire";

    avengers[17] = new Character("Crystal","",
            "Avengers","Inhumans",5,6,6,  moveset, movenam,
            movebio, "FLI","","FIRWATAIREMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M2MAGPHY0";
    moveset[2] = "DAM0H1MAG0";
    moveset[3] = "SUP0HEL11002";

    movenam[0] = "Punch";
    movenam[1] = "Telekinesis";
    movenam[2] = "Mystic Bolts";
    movenam[3] = "Reverse Time";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Use your telekinesis to throw things at an enemy for medium damage. Types: Magic, Physical";
    movebio[2] = "Hit an enemy with your Mystic Bolts to deal high damage to them. Types: Magic";
    movebio[3] = "Reverse time for your team to the beginning of the battle when you were unhurt, stunning yourself in the process.";

    avengers[18] = new Character("Dr Strange","",
            "Avengers","Sorcerers",2,6,3,  moveset, movenam,
            movebio, "FLI","","MAGEMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M2MAGPHY0";
    moveset[2] = "DAM0H1MAG0";
    moveset[3] = "DAM1M1PSY0";

    movenam[0] = "Punch";
    movenam[1] = "Telekinesis";
    movenam[2] = "Hex Bolts";
    movenam[3] = "Destroy Minds";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Use your telekinesis to throw things at an enemy for medium damage. Types: Magic, Physical";
    movebio[2] = "Hit an enemy with your Hex Bolts to deal high damage to them. Types: Magic";
    movebio[3] = "Use your powers to devastate all of the enemies mentally for medium damage. Types: Psychic";

    avengers[19] = new Character("Scarlet Witch","",
            "Avengers","Sorcerers",2,5,3,  moveset, movenam,
            movebio, "FLI","","MAGPSYEMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M1PHY1STU";
    moveset[2] = "DAM0H1PHY0";
    moveset[3] = "DAM1M1AIR0";

    movenam[0] = "Punch";
    movenam[1] = "Takedown";
    movenam[2] = "Running Punch";
    movenam[3] = "Whirlwind";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Knock an enemy off their feet stunning them for a turn and dealing medium damage. Types: Physical";
    movebio[2] = "Use your speed to hit an enemy and deal high damage to them. Types: Physical";
    movebio[3] = "Use your speed to create a whirlwind and deal medium damage to all enemies. Types: Air";

    avengers[20] = new Character("Quicksilver","",
            "Avengers","Speedsters",5,9,5,  moveset, movenam,
            movebio, "HEL2","","PHYEMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M2BLAVIB0";
    moveset[2] = "DAM0M1PHY1STU";
    moveset[3] = "DAM0H2BLAVIB0";

    movenam[0] = "Punch";
    movenam[1] = "Claw";
    movenam[2] = "Takedown";
    movenam[3] = "Pounce";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Use your claws on an enemy for medium damage. Types: Bladed, Vibranium";
    movebio[2] = "Takedown an enemy to deal medium damage and stun them for a turn. Types: Physical";
    movebio[3] = "Pounce on an enemy with your claws to deal high damage to them. Types: Bladed, Vibranium";

    avengers[21] = new Character("Black Panther","",
            "Avengers","Wakandans",4,7,5,  moveset, movenam,
            movebio, "HEL1","EMP","BULBLA");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M1PHY0";
    moveset[2] = "DAM0M1PHY1STU";
    moveset[3] = "DAM0H1BLA0";

    movenam[0] = "Punch";
    movenam[1] = "Pound";
    movenam[2] = "Takedown";
    movenam[3] = "Spear";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Pound an enemy to deal medium damage to them. Types: Physical";
    movebio[2] = "Takedown an enemy to deal medium damage and stun them for a turn. Types: Physical";
    movebio[3] = "Attack an enemy with your spear to deal high damage to them. Types: Bladed";

    avengers[22] = new Character("Man Ape","",
            "Avengers","Wakandans",7,5,5,  moveset, movenam,
            movebio, "","","EMP");

    moveset[0] = "DAM0L2PHYAVE0";
    moveset[1] = "DAM0M2PHYAVE0";
    moveset[2] = "SUP0HEL00500";
    moveset[3] = "DAM0H2BLAAVE0";

    movenam[0] = "Punch";
    movenam[1] = "Tentacle";
    movenam[2] = "Heal";
    movenam[3] = "Claw";

    movebio[0] = "A basic attack that deals low damage. Types: Physical, Anti Venom";
    movebio[1] = "Attack an enemy with your tentacles to deal medium damage to them. Types: Physical, Anti Venom";
    movebio[2] = "Heal a friendly target (including yourself) for 50% of their health. (cannot go above max health)";
    movebio[3] = "Attack an enemy with your claws to deal high damage to them. Types: Bladed, Anti Venom";

    avengers[23] = new Character("Anti Venom","",
            "Avengers","Anti Venom",10,5,6,  moveset, movenam,
            movebio, "HEL6","","POIEMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M2ANTPHY0";
    moveset[2] = "DAM1M1PHY0";
    moveset[3] = "DAM0H2ANTPHY0";

    movenam[0] = "Punch";
    movenam[1] = "Small Punch";
    movenam[2] = "Ant Swarm";
    movenam[3] = "Giant Punch";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Shrink and attack an enemy for medium damage. Types: Ant, Physical";
    movebio[2] = "Control the ants to swarm your enemies, dealing medium damage to them all. Types: Physical";
    movebio[3] = "Grow to giant size and attack an enemy for high damage. Types: Giant, Physical";

    avengers[24] = new Character("Ant Man","",
            "Avengers","Size Changers",3,8,4,  moveset, movenam,
            movebio, "","","EMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M2ANTPHY0";
    moveset[2] = "SELDEF2";
    moveset[3] = "DAM0H1ELE1STU";

    movenam[0] = "Punch";
    movenam[1] = "Small Punch";
    movenam[2] = "Evasive Flight";
    movenam[3] = "Sting";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Shrink and attack an enemy for medium damage. Types: Ant, Physical";
    movebio[2] = "Using evasive flight techniques helps you take reduced damage for 2 turns.";
    movebio[3] = "Use your electric stinger to deal high damage to an enemy and stun them for a turn. Types: Electric";

    avengers[25] = new Character("Wasp","",
            "Avengers","Size Changers",3,9,4,  moveset, movenam,
            movebio, "FLI","","EMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M2ANTPHY0";
    moveset[2] = "DAM0M1ELE1STU";
    moveset[3] = "DAM0H2ANTPHY0";

    movenam[0] = "Punch";
    movenam[1] = "Giant Punch";
    movenam[2] = "The Stinger";
    movenam[3] = "Giant Takedown";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Grow to giant size and attack an enemy for medium damage. Types: Giant, Physical";
    movebio[2] = "Use your electric stinger to deal medium damage to an enemy and stun them for a turn. Types: Electric";
    movebio[3] = "Grow to giant size and takedown an enemy to deal high damage to them. Types: Giant, Physical";

    avengers[26] = new Character("Goliath","",
            "Avengers","Size Changers",4,6,4,  moveset, movenam,
            movebio, "","","EMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M1BUL0";
    moveset[2] = "DAM0H1GRO0";
    moveset[3] = "DAM1M1GRO1STU";

    movenam[0] = "Punch";
    movenam[1] = "Snipe";
    movenam[2] = "Targeted Quake";
    movenam[3] = "Earthquake";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Snipe an enemy for medium damage. Types: Bullet";
    movebio[2] = "Use your powers to target an enemy and deal high damage to them. Types: Ground";
    movebio[3] = "Use your powers to make a bigger, less powerful earthquake and deal medium damage to all enemies and stun them for a turn. Types: Ground";

    avengers[27] = new Character("Quake","",
            "Avengers","Inhumans",5,6,6,  moveset, movenam,
            movebio, "","","PSYGROEMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0L1PHY1STU";
    moveset[2] = "DAM0M1PHY0";
    moveset[3] = "DAM0H1PHY1HAP";

    movenam[0] = "Punch";
    movenam[1] = "Takedown";
    movenam[2] = "Batons";
    movenam[3] = "Bo Staff";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Takedown an enemy to deal low damage and stun them for a turn. Types: Physical";
    movebio[2] = "Attack an enemy with your batons to deal medium damage to them. Types: Physical";
    movebio[3] = "Attak an enemy with your Bo staff to deal high damage and hit their AP. Types: Physical";

    avengers[28] = new Character("Mockingbird","",
            "Avengers","S.H.I.E.L.D",5,6,6,  moveset, movenam,
            movebio, "HEL2","","EMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M1PHY0";
    moveset[2] = "DAM0M1BLA1STU";
    moveset[3] = "DAM0H1BLA0";

    movenam[0] = "Punch";
    movenam[1] = "Kick";
    movenam[2] = "Pounce";
    movenam[3] = "Claws";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Kick an enemy to deal medium damage to them. Types: Physical";
    movebio[2] = "Pounce on an enemy to do medium damage and stun them for a turn. Types: Bladed";
    movebio[3] = "Attack an enemy with your claws to deal high damage to them. Types: Bladed";

    avengers[29] = new Character("Tigra","",
            "Avengers","Cats",7,8,5,  moveset, movenam,
            movebio, "HEL3","","EMP");

    moveset[0] = "DAM0L1PHY0";
    moveset[1] = "DAM0M1WAT0";
    moveset[2] = "DAM0H1BLA0";
    moveset[3] = "DAM1M1WAT0";

    movenam[0] = "Punch";
    movenam[1] = "Splash";
    movenam[2] = "Shark Attack";
    movenam[3] = "Tsunami";

    movebio[0] = "A basic attack that deals low damage. Types: Physical";
    movebio[1] = "Attack an enemy with water for medium damage. Types: Water";
    movebio[2] = "Control a shark to attack an enemy for high damage. Types: Bladed";
    movebio[3] = "Bring a tsunami to hit all enemies for medium damage. Types: Water";

    avengers[30] = new Character("Sub-Mariner","",
            "Avengers","Sea Dwellers",10,4,6,  moveset, movenam,
            movebio, "HEL3","FIRPOIELE","WATEMP");
}

    public Character[] getAvengers() {
        return avengers;
    }
}
