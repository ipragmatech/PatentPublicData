package gov.uspto.document.model;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import gov.uspto.patent.InvalidDataException;
import gov.uspto.patent.model.DocumentId;

public class DocumentIdTest {

	private static Map<String, String> validFromTo = new LinkedHashMap<String, String>();
	static {
		validFromTo.put("US2002/0097953A1", "US97953A1");
		validFromTo.put("US5973683A", "US5973683A");
		validFromTo.put("WO2004/021600A1", "WO21600A1");
		validFromTo.put("DE101 47 913C1", "DE10147913C1");
		validFromTo.put("EP 470 185B1", "EP470185B1");
	}

	@Test
	public void testParse() throws InvalidDataException {
		for (Entry<String,String> entry: validFromTo.entrySet()){
			DocumentId docId = DocumentId.fromText(entry.getKey());
			assertEquals( entry.getValue(), docId.getId());
		}
	}


}