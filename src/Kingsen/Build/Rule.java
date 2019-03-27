package Kingsen.Build;

public class Rule {
    private String ruleTitle;
    private String description;

    public Rule(String ruleTitle, String description) {
        this.ruleTitle = ruleTitle;
        this.description = description;
    }

    public void setDescription(String rule) {
        this.description = rule;
    }

    public void setRuleTitle(String penalty) {
        this.ruleTitle = penalty;
    }

    public String getDescription() {
        return description;
    }

    public String getRuleTitle() {
        return ruleTitle;
    }
}
