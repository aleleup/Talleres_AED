package aed;

public class Agenda {
    Fecha fecha;
    ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
        fecha = fechaActual;     
        recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public Fecha fechaActual() {
        return new Fecha(fecha.dia(), fecha.mes());
    }
    
    public void agregarRecordatorio(Recordatorio recordatorio) {
        recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
       String recordatorioConstruido = fecha.toString() + "\n" + "=====" + "\n";

       for (Recordatorio recordatorio : recordatorios.arregolRecordatorios()){
         if (recordatorio.fecha().equals(fecha)){
            recordatorioConstruido += recordatorio.toString() + "\n";
         }
       }

       return recordatorioConstruido;
    }

    public void incrementarDia() {
        fecha.incrementarDia();
    }

    

}
