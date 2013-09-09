package de.deyovi.json;

/**
 * A JSON-Object in general is a complex data-type started by encapsulated with {}
 * @author Michi
 *
 */
public interface JSONObject extends JSONBase {

	/**
	 * Returns all Elements, defined in this {@link JSONObject}
	 * @return Array of {@link JSONElement}
	 */
	public JSONElement[] getElements();

	/**
	 * Adds an entry to the object and creates a new JSONObject as value that will be returned 
	 * @param key
	 * @return new {@link JSONObject}
	 */
	public JSONObject put(String key);

	/**
	 * Adds an entry as a key-value pair to the JSONObject, if the key already exists it will be added as array-value to the key
	 * @param key
	 * @param value
	 * @return this
	 */
	public JSONObject push(String key, Object value);

	/**
	 * Adds an entry as key-value pair to the JSONObject, if the key already exists, it will be overwritten
	 * @param key
	 * @param value
	 * @return
	 */
	public JSONObject put(String key, Object value);
	
}
