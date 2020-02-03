package ingsoft1920.dho;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DhoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void testEjemploCorrecto() {
		assertEquals(1, 1);
	}
	
	/*@Test
	void testEjemploIncorrecto() {
		assertEquals(0, 1);
	}*/

}
