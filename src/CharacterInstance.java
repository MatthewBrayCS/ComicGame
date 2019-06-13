public class CharacterInstance{

    private Character stats;

    private int currentHealth;
    private int currentAP;
    private int blockingTurns;
    private int stunTurns;

    public CharacterInstance(Character characterRef) {
        stats = characterRef;
        currentHealth = stats.getMaxhealth();
        currentAP = 10;
        blockingTurns = 0;
        stunTurns = 0;
    }

    public void modifyHealth(int input) {
        currentHealth += input;
    }

    public void  modifyAP(int input) {
        currentAP += input;
    }

    public void stun(int input) {
        stunTurns += input;
    }

    public void block(int input) {
        blockingTurns += input;
    }

    public Character getStats() {
        return stats;
    }

    public int getBlockingTurns() {
        return blockingTurns;
    }

    public int getCurrentAP() {
        return currentAP;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getStunTurns() {
        return stunTurns;
    }
}
