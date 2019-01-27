package de.jonashackt.springbootvuejs.model;

/**
 * @author aleksandr
 * @date 2019-01-27 05:36
 */
public enum Assessment {
    SUITABLE("suitable"),
    NOT_SUITABLE("not_suitable");

    private String assessmentName;

    Assessment(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }
}
