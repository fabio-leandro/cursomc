package com.fabio.cursomc.domain.enums;

public enum StatusPayment {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int cod;
    private String description;


    private StatusPayment(int cod, String description) {
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

    public static StatusPayment toEnum(Integer id){

        if(id == null) return null;

        for (StatusPayment p: StatusPayment.values()){
            if (id.equals(p.getCod())) return p;
        }

        throw new IllegalArgumentException("Id invalid "+id);

    }
}
