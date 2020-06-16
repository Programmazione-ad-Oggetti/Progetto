package esame.EsameProgrammazione;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import esame.EsameProgrammazione.exceptions.FilterIllegalArgumentException;
import esame.EsameProgrammazione.exceptions.FilterNotFoundException;
import esame.EsameProgrammazione.exceptions.InternalGeneralException;
import esame.EsameProgrammazione.filter.GtLikeFilter;
import esame.EsameProgrammazione.model.FilterStruct;
import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.service.RecognizeFilter;


class FilterUsageTest {
	
	FilterStruct filt = new FilterStruct();
	Hashtag hash = new Hashtag();
	String[] values = {"200"};
	RecognizeFilter proc = new RecognizeFilter();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, InternalGeneralException, ParseException, JSONException {
		hash.setTesto("univpm");
		filt.setField("Like");
		filt.setValues(values);
		filt.setOperator("Gt");
		assertEquals(GtLikeFilter.class, RecognizeFilter.JsonParserColumn(filt, hash));
	}

}
