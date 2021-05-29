package helpers;

public enum AirportName {
	Fulton_Airport("Fulton Airport"),
	Grass_Patch_Airport("Grass Patch Airport"),
	River_Oak_Airport("River Oak Airport");
	
	 private String displayName;

	 AirportName(String displayName) {
	        this.displayName = displayName;
	    }

	    public String displayName() { return displayName; }


}
