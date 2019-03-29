package Kingsen.Build;

public class Director {

    public void constructAceCard(Builder builder, Type type) {
        builder.setFace(Face.ACE);
        builder.setType(type);
        builder.setRule(new Rule("Ace rule", ""));
        builder.setProperties(new Properties(false));
        builder.setNumber(-1);
    }

    public void constructKingCard(Builder builder, Type type) {
        builder.setFace(Face.KING);
        builder.setType(type);
        builder.setRule(new Rule("King rule", ""));
        builder.setProperties(new Properties(false));
        builder.setNumber(-1);
    }

    public void constructQueenCard(Builder builder, Type type) {
        builder.setFace(Face.QUEEN);
        builder.setType(type);
        builder.setRule(new Rule("Queen rule", ""));
        builder.setProperties(new Properties(false));
        builder.setNumber(-1);
    }

    public void constructJackCard(Builder builder, Type type) {
        builder.setFace(Face.JACK);
        builder.setType(type);
        builder.setRule(new Rule("Jack rule", ""));
        builder.setProperties(new Properties(false));
        builder.setNumber(-1);
    }

    public void constructNumberCard(Builder builder, Type type, int number) {
        builder.setFace(Face.NUMBER);
        builder.setType(type);
        builder.setRule(new Rule(String.format("Number %1$s; rule", number), ""));
        builder.setProperties(new Properties(false));
        builder.setNumber(number);
    }
}
