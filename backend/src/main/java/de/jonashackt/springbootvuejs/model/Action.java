package de.jonashackt.springbootvuejs.model;

/**
 * @author aleksandr
 * @date 2019-01-27 05:20
 */
public enum Action {
    TAKE("take"),
    DEPOSIT("deposit");

    private String actionName;

    Action(String actionName) {
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}


