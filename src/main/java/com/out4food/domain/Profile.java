package com.out4food.domain;

import com.google.common.collect.ImmutableList;
//import com.google.devrel.training.conference.form.ProfileForm.TeeShirtSize;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Profile class stores user's profile data.
 */
@Entity
public class Profile {
    /**
     *  Use userId as the datastore key.
     */
    @Id
    private String userId;

    /**
     * Any string user wants us to display him/her on this system.
     */
    private String displayName;

    /**
     * User's main e-mail address.
     */
    private String mainEmail;

   private String age;
    private String city;
    private String country;
    private String gender;

    
    /**
     * Keys of the conferences that this user registers to attend.
     */
    private List<String> conferenceKeysToAttend = new ArrayList<>(0);

    public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

    /**
     * Just making the default constructor private.
     */
    private Profile() {}

   
    /**
     * Public constructor for Profile.
     * @param userId The datastore key.
     * @param displayName Any string user wants us to display him/her on this system.
     * @param mainEmail User's main e-mail address.
     */
    public Profile(String userId, String displayName, String mainEmail, String sex, String age, String city, String country) {
        
    	this.userId = userId;
        this.displayName = displayName;
        this.mainEmail = mainEmail;
        this.age=age;
        this.city=city;
        this.country=country;
        		
    }

    /**
     * Getter for userId.
     * @return userId.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Getter for displayName.
     * @return displayName.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Getter for mainEmail.
     * @return mainEmail.
     */
    public String getMainEmail() {
        return mainEmail;
    }


    /**
     * Update the Profile with the given displayName and teeShirtSize
     * @param displayName
     * @param teeShirtSize
     */
    public void update(String displayName, String age, String country, String city, String sex) {
        if (displayName != null) {
            this.displayName = displayName;
        }
        if (age != null) {
            this.age = age;
        }
        
        if (country != null) {
            this.country = country;
        }
        
        if (city != null) {
            this.city = city;
        }
        
        if (sex != null) {
            this.city = sex;
        }
    }

    /**
     * Getter for conferenceIdsToAttend.
     * @return an immutable copy of conferenceIdsToAttend.
     */
    public List<String> getConferenceKeysToAttend() {
    	return ImmutableList.copyOf(conferenceKeysToAttend);
    }

    /**
     * Adds a ConferenceId to conferenceIdsToAttend.
     *
     * The method initConferenceIdsToAttend is not thread-safe, but we need a transaction for
     * calling this method after all, so it is not a practical issue.
     *
     * @param conferenceKey a websafe String representation of the Conference Key.
     */
    public void addToConferenceKeysToAttend(String conferenceKey) {
        conferenceKeysToAttend.add(conferenceKey);
    }

    /**
     * Remove the conferenceId from conferenceIdsToAttend.
     *
     * @param conferenceKey a websafe String representation of the Conference Key.
     */
    public void unregisterFromConference(String conferenceKey) {
        if (conferenceKeysToAttend.contains(conferenceKey)) {
            conferenceKeysToAttend.remove(conferenceKey);
        } else {
            throw new IllegalArgumentException("Invalid conferenceKey: " + conferenceKey);
        }
    }
}
