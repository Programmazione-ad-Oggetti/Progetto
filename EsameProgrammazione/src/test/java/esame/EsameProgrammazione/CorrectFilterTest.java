package esame.EsameProgrammazione;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import esame.EsameProgrammazione.exceptions.*;
import esame.EsameProgrammazione.service.*;

/**
 * Classe usata per testare l'eccezione in caso di filtro non corretto
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
class CorrectFilterTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		//Se uno dei tre parametri non è corretto allora viene lanciata l'eccezione FilterNotFoundException
		assertThrows(FilterNotFoundException.class, ()-> ServFilter.instanceFilter("likes", "Gt" , 100));		
		assertThrows(FilterNotFoundException.class, ()-> ServFilter.instanceFilter("flollower", "Lt", 250));
		assertThrows(FilterNotFoundException.class, ()-> ServFilter.instanceFilter("Like", "Gtd", 200));
		assertThrows(FilterNotFoundException.class, ()-> ServFilter.instanceFilter("Followers", "Ltd", 300));
		assertThrows(FilterNotFoundException.class, ()-> ServFilter.instanceFilter("Friends", "ciao", 200));
		
		//Se il terzo parametro non è corretto allore viene lanciata l'eccezione FilterIllegalArgumentException
		assertThrows(FilterIllegalArgumentException.class, ()-> ServFilter.instanceFilter("Friends", "Gt", "ciao"));
	}

}
