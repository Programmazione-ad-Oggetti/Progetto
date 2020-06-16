package esame.EsameProgrammazione;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import esame.EsameProgrammazione.exceptions.StatsNotFoundException;
import esame.EsameProgrammazione.service.ServTweetsImpl;

/**
 * Classe usata per testare l'eccezione in caso di campo non corretto
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
class CorrectFieldTest {
	
	ServTweetsImpl serv = new ServTweetsImpl();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws StatsNotFoundException {
		//Se il campo "field" non è corretto allora viene lanciata l'eccezione StatsNotFoundException
		assertThrows(StatsNotFoundException.class, ()-> serv.RecognizeField("Wrong Field"));
		
		//Se il campo "field" non è corretto alla ritorna il campo corretto
		assertEquals("Like", serv.RecognizeField("\"Like\""));
	}

}
