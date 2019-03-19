package Kingsen.Build;

public class Card {
    private Type type;
    private Rule rule;
    private int number;
    private Face face;
    private Properties properties;

    public Card(Type type, Rule rule, int number, Face face, Properties properties) {
        this.type = type;
        this.rule = rule;
        this.face = face;
        this.properties = properties;
        this.number = number;
    }

    public Type getType() {
        return type;
    }

    public Rule getRule() {
        return rule;
    }

    public int getNumber() {
        return number;
    }

    public Face getFace() {
        return face;
    }

    public Properties getProperties() {
        return properties;
    }
}
