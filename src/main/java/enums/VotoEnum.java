package enums;

import lombok.Getter;
import lombok.Setter;


public enum VotoEnum {

    SIM("SIM"),
    NAO("NAO");

    private String voto;
    VotoEnum(String voto){
        this.voto = voto;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }
}
