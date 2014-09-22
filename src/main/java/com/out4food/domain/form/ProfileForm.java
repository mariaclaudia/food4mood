package com.out4food.domain.form;

/**
 * Pojo representing a profile form on the client side.
 */
public class ProfileForm {
    /**
     * Any string user wants us to display him/her on this system.
     */
    private String displayName;

   

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
     * Enum representing T shirt size.
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