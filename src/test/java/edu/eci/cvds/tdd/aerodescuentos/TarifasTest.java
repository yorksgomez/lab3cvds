package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;
import edu.eci.cvds.tdd.aerodescuentos.*;

public class TarifasTest {

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

	@Test
    public void Dado_21Dias67Anios_Entonces_DeberiaRetornar770() throws ExcepcionParametrosInvalidos {
		long tarifaBase = 1000;
        int diasAntelacion = 21;
        int edad = 67;
        long expected = 770;

        long actual = new CalculadorDescuentos().calculoTarifa(tarifaBase, diasAntelacion, edad);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Dado_19Dias67Anios_Entonces_DeberiaRetornar920() throws ExcepcionParametrosInvalidos {
		long tarifaBase = 1000;
        int diasAntelacion = 19;
        int edad = 67;
        long expected = 920;

        long actual = new CalculadorDescuentos().calculoTarifa(tarifaBase, diasAntelacion, edad);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Dado_19Dias15Anios_Entonces_DeberiaRetornar950() throws ExcepcionParametrosInvalidos {
		long tarifaBase = 1000;
        int diasAntelacion = 19;
        int edad = 15;
        long expected = 950;

        long actual = new CalculadorDescuentos().calculoTarifa(tarifaBase, diasAntelacion, edad);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Dado_21Dias20Anios_Entonces_DeberiaRetornar850() throws ExcepcionParametrosInvalidos {
		long tarifaBase = 1000;
        int diasAntelacion = 21;
        int edad = 20;
        long expected = 850;

        long actual = new CalculadorDescuentos().calculoTarifa(tarifaBase, diasAntelacion, edad);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Dado_21Dias15Anios_Entonces_DeberiaRetornar800() throws ExcepcionParametrosInvalidos {
		long tarifaBase = 1000;
        int diasAntelacion = 21;
        int edad = 15;
        long expected = 800;

        long actual = new CalculadorDescuentos().calculoTarifa(tarifaBase, diasAntelacion, edad);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Dado_21DiasN15Anios_Entonces_DeberiaRetornarEx() throws ExcepcionParametrosInvalidos {
		long tarifaBase = 1000;
        int diasAntelacion = 21;
        int edad = -15;
        TipoExcepcion expected = TipoExcepcion.INVALID_AGE;

        try {
            long actual = new CalculadorDescuentos().calculoTarifa(tarifaBase, diasAntelacion, edad);
        } catch(ExcepcionParametrosInvalidos ex) {
            Assert.assertEquals(expected, ex.getType());
        }
        
    }

    @Test
    public void Dado_21Dias160Anios_Entonces_DeberiaRetornarEx() throws ExcepcionParametrosInvalidos {
		long tarifaBase = 1000;
        int diasAntelacion = 21;
        int edad = 160;
        TipoExcepcion expected = TipoExcepcion.INVALID_AGE;

        try {
            long actual = new CalculadorDescuentos().calculoTarifa(tarifaBase, diasAntelacion, edad);
        } catch(ExcepcionParametrosInvalidos ex) {
            Assert.assertEquals(expected, ex.getType());
        }
        
    }

    @Test
    public void Dado_N21Dias16Anios_Entonces_DeberiaRetornarEx() throws ExcepcionParametrosInvalidos {
		long tarifaBase = 1000;
        int diasAntelacion = -21;
        int edad = 16;
        TipoExcepcion expected = TipoExcepcion.INVALID_DAYS;

        try {
            long actual = new CalculadorDescuentos().calculoTarifa(tarifaBase, diasAntelacion, edad);
        } catch(ExcepcionParametrosInvalidos ex) {
            Assert.assertEquals(expected, ex.getType());
        }
        
    }

    @Test
    public void Dado_20000Dias16Anios_Entonces_DeberiaRetornarEx() throws ExcepcionParametrosInvalidos {
		long tarifaBase = 1000;
        int diasAntelacion = 20000;
        int edad = 16;
        TipoExcepcion expected = TipoExcepcion.INVALID_DAYS;

        try {
            long actual = new CalculadorDescuentos().calculoTarifa(tarifaBase, diasAntelacion, edad);
        } catch(ExcepcionParametrosInvalidos ex) {
            Assert.assertEquals(expected, ex.getType());
        }
        
    }
    
}	
