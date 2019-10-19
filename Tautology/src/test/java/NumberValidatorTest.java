import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberValidatorTest {

	@Test
	public void checkPrimeNumbers()
	{
		Integer numbers[] = {1,7, 13};
		NumberValidator numberValidator = new NumberValidator();

		for(int i : numbers){
			assertEquals(true, numberValidator.isItPrime(i));
		}
	}

	@Test
	public void checkNonPrimeNumbers()
	{
		Integer numbers[] = {6, 4, 8, 12, 25};
		NumberValidator numberValidator = new NumberValidator();

		for(int i : numbers){
			assertEquals(false, numberValidator.isItPrime(i));
		}
	}

}
