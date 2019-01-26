package de.jonashackt.springbootvuejs.model;

/**
 * @author aleksandr
 * @date 2019-01-26 22:59
 */
public enum AssessmentScore {
    CAN_DEPOSIT("canDeposit"),
    CAN_WITHDRAW("canWithdraw");

    private String status;

    AssessmentScore(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }}
