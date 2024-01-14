package net.codejava.pes1ug20cs588;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Pes1ug20cs588PersonalInfoTests {
        @Autowired
        private WebController controller;
        
	@Test
	void contextLoads() {
               Assertions.assertNotNull(controller);
	}

}
