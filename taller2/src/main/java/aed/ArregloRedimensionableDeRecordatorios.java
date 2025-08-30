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
        recordatoriosArray[longitud()-1 ] = record;
       
    }

    public Recordatorio obtener(int i) {
        // if (! (i))
        return recordatoriosArray[i];
    }

    public void quitarAtras() {
        Recordatorio[] prevArrayDeRecord = recordatoriosArray;
        recordatoriosArray = new Recordatorio[longitud() - 1];
        for (int i = 0; i < longitud(); i++){
            recordatoriosArray[i] = prevArrayDeRecord[i];
        };
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        recordatoriosArray[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        recordatoriosArray = vector.recordatoriosArray.clone();
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        return new ArregloRedimensionableDeRecordatorios(this);
    };

    public Recordatorio[] arregolRecordatorios(){
        return recordatoriosArray;
    };

    private boolean arreglosIguales(Recordatorio[] array1, Recordatorio[] array2){
        if (array1.length != array2.length) {return false;}

        for (int i = 0; i < array1.length; i++){
            if (!array1[i].equals(array2[i])){return false;}
        }
        return true;
    }


    @Override
    public boolean equals(Object otro) {
        if (otro != null && otro.getClass() == this.getClass() ){
            ArregloRedimensionableDeRecordatorios otroArregloDeRecordatorios = (ArregloRedimensionableDeRecordatorios) otro;
            return arreglosIguales(recordatoriosArray, otroArregloDeRecordatorios.arregolRecordatorios());
        }
        return false;
    }
}
