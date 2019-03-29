package Kingsen.Build;

public class Properties {
    private Boolean used = false;
    private Boolean playable;
    private Boolean penaltyEnabled = true;
    private Boolean selfPenalty = false;

    public Properties(Boolean playable) {
        this.playable = playable;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public void setPlayable(Boolean playable) {
        this.playable = playable;
    }

    /**
     * Check whether the card can be played by the player
     *
     * @return
     */
    public Boolean isPlayable() {
        return playable;
    }

    /**
     * Determines if the card has been used by the player
     *
     * @return
     * @deprecated Not yet being used by the app
     */
    @Deprecated
    public Boolean isUsed() {
        return used;
    }

    public void setPenaltyEnabled(Boolean penaltyEnabled) {
        this.penaltyEnabled = penaltyEnabled;
    }

    /**
     * Determines if the card can punish the player
     *
     * @return Boolean
     */
    public Boolean isPenaltyEnabled() {
        return penaltyEnabled;
    }

    public void setSelfPenalty(Boolean selfPenalty) {
        this.selfPenalty = selfPenalty;
    }

    /**
     * When set to true, this card will add a penalty to the player who picks this it
     * @return
     */
    public Boolean isSelfPenalty() {
        if (penaltyEnabled) {
            return selfPenalty;
        } else {
            return false;
        }
    }
}
