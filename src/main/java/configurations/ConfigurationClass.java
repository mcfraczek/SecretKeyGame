package main.java.configurations;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("configuration")
public class ConfigurationClass {
    @XStreamAlias("speed")
    private final double speed;
    @XStreamAlias("game_margin_size")
    private final int gameMarginSize;
    @XStreamAlias("choice_margin_size")
    private final int choiceMarginSize;
    @XStreamAlias("save_path")
    private String savePath;

    public ConfigurationClass(double speed, int gameMarginSize, int choiceMarginSize) {
        this.speed = speed;
        this.gameMarginSize = gameMarginSize;
        this.choiceMarginSize = choiceMarginSize;
    }

    public double getSpeed() {
        return speed;
    }

    public int getGameMarginSize() {
        return gameMarginSize;
    }

    public int getChoiceMarginSize() {
        return choiceMarginSize;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
