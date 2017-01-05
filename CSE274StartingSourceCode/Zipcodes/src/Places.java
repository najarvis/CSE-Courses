import java.util.*;
import java.io.*;

public class Places {
	private ArrayList<Location> places;
	
	public Places(String fname) throws FileNotFoundException {
		places = new ArrayList<>();
		Scanner input = null;
		 input = new Scanner(new File(fname));
		 input.nextLine();		// skip first line
		 while (input.hasNextLine()) {
			 String [] toks = input.nextLine().split("\t", -1);
			 Location loc = new Location(toks);
			 places.add(loc);
		 }
		input.close();
	}
	/**
	 * Returns all the city names that correspond to a particular zipcode. The empty
	 * set is returned if the zipcode is not valid.
	 * @param zipCode target zip code
	 * @return set with all city names with the target zip code.
	 */
	public Set<String> getCityNameFromZipCode(int zipCode) {
		return null;
	}
	/**
	 * Returns all the zipcodes that are contained in a particular city-state. The empty
	 * set is returned if the city-state pair is illegal.
	 * @param cityName target city name
	 * @param state target state
	 * @return set with all relevant zipcodes.
	 */
	public Set<Integer> getZipCodes(String cityName, String state) {
		return null;
	}
	/**
	 * Returns a map that is keyed to state name. The values in the map is a set of
	 * zip codes that reside in that particular state. The map looks like:
	 * "AL" --> { 36863, 35755, ... }
	 * "AK" --> { 44256, 44257, ...}
	 * ...
	 * @return mapping from states to set of zipcodes.
	 */
	public Map<String, Set<Integer>> getZipCodesInStates() {
		return null;
	}
	/**
	 * Returns all the states that contain a particular city name. The empty
	 * set is returned if the city name is not any state.
	 * @param cityName target city name
	 * @return set of states that contain the target city.
	 */
	public Set<String> getStatesThatContainThisCity(String cityName) {
		return null;
	}
	/**
	 * Returns the states that contain any of the target cities. The empty
	 * set is returned if none of the cities are in any state. This is similar
	 * to above but accepts multiple cities instead of single city.
	 * @param cityNames target cities
	 * @return set of states that contain any of the target cities.
	 */
	public Set<String> getStatesThatContainAnyOfTheseCities(Set<String> cityNames) {
		return null;
	}
	/**
	 * Returns all zipcodes that are within a specified distance from a
	 * particular zipcode.
	 * @param zipCode target zipcode
	 * @param distance maximum distance from target zipcode 
	 * @return all zipcodes that are within "distance" from the target zipcode
	 */
	public Set<Integer> getZipCodesCloseTo(int zipCode, double distance) {
		return null;
	}
	/**
	 * Returns a map that is keyed to state name. The values in the map are the set
	 * of city names that reside in that particular state. The map looks like:
	 * "AL" --> { "MONTGOMERY", "MOBILE", ... }
	 * "AK" --> { "ANCHORAGE", "BARROW", ...}
	 * ...
	 * @return mapping from states to set of city names.
	 */
	public Map<String, Set<String>> getCityNames() {
		return null;
	}
	/**
	 * Returns all city names that reside within a particular state.
	 * @param state target state
	 * @return set of city names
	 */
	public Set<String> allCityNames(String state) {
		return null;
	}
	/**
	 * Returns all city names that reside within any of the
	 * given states.
	 * @param state target states
	 * @return set of city names
	 */
	public Set<String> allCityNames(Set<String> states) {
		return null;
	}
	/**
	 * Returns all city names in the entire database
	 * @return set of city names
	 */
	public Set<String> allCityNames() {
		return null;
	}
	/**
	 * Returns all state names in the entire database
	 * @return set of state names
	 */
	public Set<String> allStateNames() {
		return null;
	}
	/**
	 * Returns the city names that appear in both of the given
	 * states
	 * @param state1 first target state
	 * @param state2 second target state
	 * @return set of city names
	 */
	public Set<String> getCommonCityNames(String state1, String state2) {
		return null;
	}
	/**
	 * Ranked list of states, where the ranking is ascending order of number
	 * of zipcodes.
	 * @return
	 */
	public ArrayList<String> mostZipCodes() {
		return null;
	}
	/**
	 * The city name(s) that appears in the most states. Note, "NEW YORK"
	 * is credited with appearing in NY only once. That is, the large number
	 * of "NEW YORK" zipcodes does not make it a more common name.  
	 * @return set of city names
	 */
	public Set<String> cityNameInMostStates() {
		return null;
	}

	public static void main(String [] args) throws FileNotFoundException {
		Places places = new Places("ZipCodes.txt");
		System.out.println(places.getZipCodes("OXFORD", "OH"));
		System.out.println(places.getZipCodes("RICHMOND", "IN"));
		System.out.println(places.getCityNameFromZipCode(45056));
		System.out.println(places.getCityNameFromZipCode(10048));
		System.out.println(places.allStateNames());
		//System.out.println(places.allCityNames());
		Set<String> smallStates = new TreeSet<>();
		smallStates.add("HI");
		//smallStates.add("AK");
		System.out.println(places.allCityNames(smallStates));
		Map<String, Set<String>> cities = places.getCityNames();
		System.out.println(cities.get("MI"));
		System.out.println(places.getCommonCityNames("MI", "AK"));
		System.out.println(places.cityNameInMostStates());
		System.out.println(places.mostZipCodes());
	}
}
