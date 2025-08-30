package aed;

public class Fecha {
    int atributoDia;
    int atributoMes;
    public Fecha(int dia, int mes) {
        atributoDia = dia;
        atributoMes = mes;
    }

    public Integer dia() {
        return atributoDia;
    }

    public Integer mes() {
        return atributoMes;
    }

    @Override
    public String toString() {
        return atributoDia + "/" + atributoMes;
    }


    @Override
    public boolean equals(Object otra) {
        if (otra != null && otra.getClass() == this.getClass() ){
            Fecha otraFecha = (Fecha) otra;
            return otraFecha.dia() == atributoDia && otraFecha.mes() == atributoMes;
        }
        return false;
    }

    public void incrementarDia() {
        
        if (atributoDia + 1 > diasEnMes(atributoMes)){
            atributoDia = 1;
            if (atributoMes + 1 > 12){
                atributoMes = 1;
            }
            else {
                atributoMes++;
            }
        } 
        else{
            atributoDia++; 
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
