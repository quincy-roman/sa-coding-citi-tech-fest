package io.legendofjava.sacoding.Enum;

public enum AssignmentType {

    QUIZ, ASSESSMENT, PRACTICAL;

    private String assignmentType;

    private AssignmentType(){
        this.assignmentType = "ATYPE_" + this.name();
    }

    public String getAssignmentType(){
        return this.assignmentType;
    }

}
