package com.construction.constant;

import java.util.Set;
import java.util.TreeSet;

/**
 * Enum constants for every U.S. states
 * @author Jack Chen
 */
public enum States {

	ALABAMA("Alabama", "AL"), ALASKA("Alaska", "AK"), ARIZONA("Arizona", "AZ"),
	ARKANSAS("Arkansas", "AR"), CALIFORNIA("California", "CA"), 
	COLORADO("Colorado", "CO"), CONNECTICUT("Connecticut", "CT"), 
	DELAWARE("Delaware", "DE"), FLORIDA("Florida", "FL"), GEORGIA("Georgia", "GA"), 
	HAWAII("Hawaii", "HI"), IDAHO("Idaho", "ID"), ILLINOIS("Illinois", "IL"), 
	INDIANA("Indiana", "IN"), IOWA("Iowa", "IA"), KANSAS("Kansas", "KS"), 
	KENTUCKY("Kentucky", "KY"), LOUISIANA("Louisiana", "LA"), MAINE("Maine", "ME"), 
	MARYLAND("Maryland", "MD"), MASSACHUSETTS("Massachusetts", "MA"), MICHIGAN("Michigan", "MI"), 
	MINNESOTA("Minnesota", "MN"), MISSISSIPPI("Mississippi", "MS"), 
	MISSOURI("Missouri", "MO"), MONTANA("Montana", "MT"), NEBRASKA("Nebraska", "NE"), 
	NEVADA("Nevada", "NV"), NEW_HAMPSHIRE("New Hampshire", "NH"), 
	NEW_JERSEY("New Jersey", "NJ"), NEW_MEXICO("New Mexico", "NM"), 
	NEW_YORK("New York", "NY"), NORTH_CAROLINA("North Carolina", "NC"), 
	NORTH_DAKOTA("North Dakota", "ND"), OHIO("Ohio", "OH"), OKLAHOMA("Oklahoma", "OK"), 
	OREGON("Oregon", "OR"), PENNSYLVANIA("Pennsylvania", "PA"), 
	RHODE_ISLAND("Rhode Island", "RI"), SOUTH_CAROLINA("South Carolina", "SC"), 
	SOUTH_DAKOTA("South Dakota", "SD"), TENNESSEE("Tennessee", "TN"), TEXAS("Texas", "TX"), 
	UTAH("Utah", "UT"), VERMONT("Vermont", "VT"), VIRGINIA("Virginia", "VA"), 
	WASHINGTON("Washington", "WA"), WEST_VIRGINIA("West Virginia", "WV"), 
	WISCONSIN("Wisconsin", "WI"), WYOMING("Wyoming", "WY");
	
	private String name;
	
	private String abbreviation;
	
	private static final Set<String> ABBREVIATIONS = new TreeSet<>();
	
	States(String name, String abbreviation) {
		this.name = name;
		this.abbreviation = abbreviation;
	}
	
	static {
		for (States state : values()) {
			ABBREVIATIONS.add(state.getAbbreviation());
		}
	}

	public String getName() {
		return name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
	
	public static Set<String> getAllAbbreviations() {
		return ABBREVIATIONS;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
