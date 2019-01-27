package de.jonashackt.springbootvuejs.model;

import java.util.List;

/**
 * @author aleksandr
 * @date 2019-01-26 22:59
 */
public class AssessmentParams {

    public AssessmentParams(List<Action> actions, int amount) {
        this.actions = actions;
        this.amount = amount;
    }

    // Список действий (снять, положить, и тп )
    private List<Action> actions;

    // Сумма для действия
    private int amount;

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
