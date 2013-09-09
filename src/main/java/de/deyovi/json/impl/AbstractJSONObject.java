package de.deyovi.json.impl;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import de.deyovi.json.JSONElement;
import de.deyovi.json.JSONObject;

/**
 * Abstract foundation for {@link JSONObject} defining the core functionality to present the stored data as string
 * @author Michi
 *
 */
public abstract class AbstractJSONObject implements JSONObject {

	
	private static final Logger logger = LogManager.getLogger(AbstractJSONObject.class);
	
	@Override
	public void appendTo(Appendable appender) throws IOException {
		// open the object
		appender.append("{");
		// get all the objects elements
		JSONElement[] elements = getElements();
		for (int i = 0; i < elements.length; i++) {
			if (i > 0) {
				appender.append(',');
			}
			// and append them
			elements[i].appendTo(appender);
		}
		// close the object
		appender.append("}");
	}
	
	@Override
	public int getSize() {
		JSONElement[] elements = getElements();
		// first we add the amount of commata
		int sum = elements.length - 1;
		// then 2 for the two curly brackets
		sum += 2;
		// and the size of each element
		for (JSONElement element : elements) {
			sum += element.getSize();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		try {
			appendTo(sb);
		} catch (IOException e) {
			logger.error("Error building String-representation for JSONObject", e);
		}
		return sb.toString();
	}
	
}
