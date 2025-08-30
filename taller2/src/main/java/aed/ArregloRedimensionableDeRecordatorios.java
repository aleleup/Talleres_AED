package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] recordatoriosArray;
    public ArregloRedimensionableDeRecordatorios() {
        recordatoriosArray = new Recordatorio[0];
    }

    public int longitud() {
        return recordatoriosArray.length;
    }

    public void agregarAtras(Recordatorio record) {
        Recordatorio[] prevArrayDeRecord = recordatoriosArray;
        recordatoriosArray = new Recordatorio[longitud() + 1];

        for (int i = 0; i < longitud() - 1; i++){
            recordatoriosArray[i] = prevArrayDeRecord[i];
        };

        recordatoriosArray[longitud()] = record;
       

        return ; 

    }

    public Recordatorio obtener(int i) {
        // if (! (i))
        return recordatoriosArray[i];
    }

    public void quitarAtras() {
        // Implementar
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        // Implementar
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        // Implementar
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        // Implementar
        return null;
    }
}
