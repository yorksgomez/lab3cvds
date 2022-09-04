package edu.eci.cvds.tdd.aerodescuentos;

public class ExcepcionParametrosInvalidos extends Exception {
    
    private TipoExcepcion type;

    public ExcepcionParametrosInvalidos(TipoExcepcion type, String message) {
        super(message);
        this.type = type;        
    }

    public TipoExcepcion getType() {
        return type;
    }

}
