package esame.EsameProgrammazione;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import esame.EsameProgrammazione.exceptions.*;
import esame.EsameProgrammazione.service.*;

class CorrectFilterTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertThrows(FilterNotFoundException.class, ()-> ServFilter.instanceFilter("likes", "Gt" , 100));		
		assertThrows(FilterNotFoundException.class, ()-> ServFilter.instanceFilter("flollower", "Lt", 250));
		assertThrows(FilterNotFoundException.class, ()-> ServFilter.instanceFilter("Like", "Gtd", 200));
		assertThrows(FilterNotFoundException.class, ()-> ServFilter.instanceFilter("Followers", "Ltd", 300));
		assertThrows(FilterIllegalArgumentException.class, ()-> ServFilter.instanceFilter("Friends", "Gt", "ciao"));
		assertThrows(FilterNotFoundException.class, ()-> ServFilter.instanceFilter("Friends", "ciao", 200));
	}

}
