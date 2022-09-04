package edu.eci.cvds.tdd.aerodescuentos;

public class CalculadorDescuentos {

    /**
	calcular la tarifa de cada billete según el trayecto, la antelación
	en la que se obtiene el billete y la edad del pasajero, de acuerdo
	con la normativa 005.
	@param tarifaBase valor base del vuelo
	@param diasAntelacion dias de antelación del vuelo
	@param edad - edad del pasajero
	@throws ExcepcionParametrosInvalidos [XXXXXXXXXXXXXXXXXXXXXXXXXXX]
	public long calculoTarifa(long tarifaBase, int diasAntelacion, int edad)
	**/
    /**
    Se definen tres clases de equivalencia
    EDAD_INVALIDA, es alquella edad que es menor a 0 o mayor a 150 (Incorrecto))
    DIAS_INVALIDOS: dias negativos o excesivamente altos (mayores a 10000 (Incorrecto)
    VALIDO: Ninguno de los dos anteriores casos se cumplen (Correcto)
    Dentros de los VALIDOS
    0 de descuento para personas mayores de 18 y menores de 65 con 20 o menos dias de antelacion
    15 para personas mayores de 18 y menores de 65 con mas de 20 dias de antelacion
    20 para personas menores de 18 con mas de 20 dias de antelacion
    23 para personas mayoress de 65 con mas de 20 dias de antelacion
    5 para personas menores de 18 con 20 o menos dias de antelacion
    8 para personas nayores de 65 con 20 o menos dias de antelacion
    **/
    public long calculoTarifa(long tarifaBase, int diasAntelacion, int edad) throws ExcepcionParametrosInvalidos {
        double descuento = 0;

        if(edad < 0)
            throw new ExcepcionParametrosInvalidos(TipoExcepcion.INVALID_AGE, "La edad no puede ser menor que 0");
    
        if(edad > 150)
            throw new ExcepcionParametrosInvalidos(TipoExcepcion.INVALID_AGE, "La edad no puede ser mayor que 150");

        if(diasAntelacion < 0)
            throw new ExcepcionParametrosInvalidos(TipoExcepcion.INVALID_DAYS, "No se puede pedir un tiquete con menos de 0 dias de antelacion");

        if(diasAntelacion > 10000)
            throw new ExcepcionParametrosInvalidos(TipoExcepcion.INVALID_DAYS, "No se puede pedir un tiquete con mas de 10000 dias de antelacion");

        if(diasAntelacion > 20)
            descuento += 15;

        if(edad < 18)
            descuento += 5;
        else if(edad > 65)
            descuento += 8;
 
        descuento /= 100;

        tarifaBase = tarifaBase - (long) (tarifaBase * descuento); 
        return tarifaBase;
    }

}
