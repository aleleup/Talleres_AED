package aed;

public class Recordatorio {
    private String atrMensaje;
    
    private Fecha atrFecha;
    private Horario atrHorario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        atrMensaje = mensaje;
        atrFecha = new Fecha(fecha.dia(), fecha.mes());
        atrHorario = new Horario(horario.hora(), horario.minutos());
    }

    public Horario horario() {
        return new Horario(atrHorario.hora(), atrHorario.minutos());
    }

    public Fecha fecha() {
        return new Fecha(atrFecha.dia(), atrFecha.mes());
    }

    public String mensaje() {
        return atrMensaje;
    }

    @Override
    public String toString() {
        // Implementar
        return atrMensaje + " @ " + atrFecha+ " " + atrHorario;
    }

    @Override
    public boolean equals(Object otro) {
        if (otro != null && otro.getClass() == this.getClass() ){
            Recordatorio otroRecordatorio = (Recordatorio) otro;
                return otroRecordatorio.horario().equals(atrHorario) && 
                otroRecordatorio.fecha().equals(atrFecha) && 
                otroRecordatorio.mensaje().equals(atrMensaje)
                ;
        }
        return false;
    }


}
