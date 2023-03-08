package br.com.gilfercode.orion.enums;

public enum TypesRole {
    ADMIN(1, "ROLE_ADMIN"), DOCTOR(2, "ROLE_DOCTOR");

    private long cod;
    private String desc;

    TypesRole(long cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    /*Gets and sets*/
    public long getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }
}
