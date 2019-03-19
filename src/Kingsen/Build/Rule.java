package Kingsen.Build;

public class Rule {
    private String rule;
    private String penalty;

    public Rule() {

    }

    public Rule(String rule, String penalty) {
        this.rule = rule;
        this.rule = penalty;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }

    public String getRule() {
        return rule;
    }

    public String getPenalty() {
        return penalty;
    }
}
