package com.fabio.cursomc.domain.enums;

public enum CustomerType {

    PESSOAFISICA(1,"Pessoa Física"),
    PESSOAJURIDICA(2,"Pessoa Jurídica");

    private int cod;
    private String description;

    private CustomerType(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static CustomerType toEnum(Integer id){

        if(id == null) return null;

        for (CustomerType c: CustomerType.values()){
            if (id.equals(c.getCod())) return c;
        }

        throw new IllegalArgumentException("Id invalid "+id);

    }



}
