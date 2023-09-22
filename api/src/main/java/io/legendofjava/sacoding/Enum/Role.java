package io.legendofjava.sacoding.Enum;

public enum Role {

    ADMIN, FACILITATOR, LEARNER, UNASSIGNED, UNVERIFIED;

    private String role;

    private Role(){
        this.role = "ROLE_" + this.name();
    }

    public String privilege(){
        return this.role;
    }

}
