package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
 
    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {

        Person person = new Person("kevin", 1, 18, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    
    @Test
    public void validateDead() {

        Person person = new Person("kevin", 1, 18, Gender.MALE, false);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    
    @Test
    public void validateUnderage() {

        Person person = new Person("kevin", 1, 15, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    
    @Test
    public void validateInvalidAge() {

        Person person = new Person("kevin", 1, 550, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    
    @Test
    public void validateDuplicated() {

        Person person = new Person("kevin", 1, 18, Gender.MALE, true);

		registry.registerVoter(person);
        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

}
