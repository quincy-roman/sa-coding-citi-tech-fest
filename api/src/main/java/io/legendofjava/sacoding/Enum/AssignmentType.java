package io.legendofjava.sacoding.Enum;

public enum AssignmentType {

    QUIZ, ASSEMSMENT, PRACTICAL;

    private String assignmentType;

    private AssignmentType(){
        this.assignmentType = "ATYPE_" + this.name();
    }

    public String getAssignmentType(){
        return this.assignmentType;
    }

}
