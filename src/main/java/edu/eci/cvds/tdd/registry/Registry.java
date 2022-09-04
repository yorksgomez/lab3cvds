package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {

    private ArrayList<Person> persons;

	public Registry() {
		persons = new ArrayList<>();
	}

	/**
	 * Las clases de equivalencia son:
	 * Menores de Edad (Menores de 18)
	 * Edades inválidas (Edades mayores a 150 y menores a 0)
	 * Muertos (Alive = false)
	 * Ya existente (Id ya dentro de la lista de clasificados)
	 * Valido (Persona válida)
	 * Donde sólamente los válidos entrarían a la lista y los demás serían rechazados
	 * @param p: Persona a agregar
	 * @return Resultado
	 */
    public RegisterResult registerVoter(Person p) {

		if(p.getAge() > 150 || p.getAge() < 0) {
			return RegisterResult.INVALID_AGE;
		}

		if(p.getAge() < 18) {
			return RegisterResult.UNDERAGE;
		}
		
		if(!p.isAlive()) {
			return RegisterResult.DEAD;
		}
		
		for (Person e : persons)
			
			if(e.getId() == p.getId())
				return RegisterResult.DUPLICATED;

        // TODO Validate person and return real result.
        persons.add(p);
        return RegisterResult.VALID;
    }

}