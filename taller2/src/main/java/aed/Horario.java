package aed;

public class Horario {

    private int atrHora;
    private int atrMin;
    public Horario(int hora, int minutos) {
        atrHora = hora;
        atrMin = minutos;
    }

    public int hora() {
        return atrHora;
    }

    public int minutos() {
        return atrMin;
    }

    @Override
    public String toString() {
        return atrHora + ":" + atrMin;
    }

    @Override
    public boolean equals(Object otro) {
        if (otro != null && otro.getClass() == this.getClass() ){
            Horario otroHorario = (Horario) otro;
            return otroHorario.hora() == atrHora && otroHorario.minutos() == atrMin;
        }
        return false;
    }

}
