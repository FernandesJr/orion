package br.com.gilfercode.orion.entities;

public enum TypesRole {
    ADMIN(0, "ADMIN"), DOCTOR(1, "DOCTOR"), PATIENT(2, "PATIENT");

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
