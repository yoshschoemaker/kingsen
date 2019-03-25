package Kingsen.Build;

public class CardBuilder implements Builder {
    private Type type;
    private Rule rule;
    private int number;
    private Face face;
    private Properties properties;

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void setRule(Rule rule) {
        this.rule = rule;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void setFace(Face face) {
        this.face = face;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Card getCard() {
        return new Card(type, rule, number, face, properties);
    }
}
