package Kingsen.Build;

public class Properties {
    private Boolean used = false;
    private Boolean playable;

    public Properties(Boolean playable) {
        this.playable = playable;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public void setPlayable(Boolean playable) {
        this.playable = playable;
    }

    public Boolean isPlayable() {
        return playable;
    }

    public Boolean isUsed() {
        return used;
    }
}
