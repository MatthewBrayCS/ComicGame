 class CharacterInstance{

    private Character stats;

    private int currentHealth;
    private int currentAP;
    private int blockingTurns;
    private int stunTurns;

    CharacterInstance(Character characterRef) {
        stats = characterRef;
        currentHealth = stats.getMaxhealth();
        currentAP = 10;
        blockingTurns = 0;
        stunTurns = 0;
    }

    public void modifyHealth(int input) {
        currentHealth += input;
        //stops the character going above max health
        if (currentHealth > stats.getMaxhealth()) {
            currentHealth = stats.getMaxhealth();
        }
    }

    public void  modifyAP(int input) {
        currentAP += input;
        //stops the character going above max AP
        if (currentAP > stats.getMaxap()) {
            currentAP = stats.getMaxap();
        }
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
