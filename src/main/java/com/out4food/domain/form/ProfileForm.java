package com.out4food.domain.form;

/**
 * Pojo representing a profile form on the client side.
 */
public class ProfileForm {
    
    private String displayName;
    
    private String age;
    private String sex;
    private String city;
    private String country;

    
    public String getAge() {
		return age;
	}

	public String getSex() {
		return sex;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}
   

    private ProfileForm () {}

    /**
     * Constructor for ProfileForm, solely for unit test.
     * @param displayName A String for displaying the user on this system.
     * @param teeShirtSize User's tee shirt size
     */
    public ProfileForm(String displayName) {
        this.displayName = displayName;
            }

    public String getDisplayName() {
        return displayName;
    }

    /**
     * Enum representing T shirt size. --> farlo per SEX
     */
    public static enum TeeShirtSize {
        NOT_SPECIFIED,
        XS,
        S,
        M,
        L,
        XL,
        XXL,
        XXXL
    }
}