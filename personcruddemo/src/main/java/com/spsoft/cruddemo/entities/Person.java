package com.spsoft.cruddemo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    
    @NotBlank(message = "First Name is required")
    private String firstname;

    @NotBlank(message = "Last name is required")
    private String lastname;

    @NotBlank(message = "Age is required")
    private String age;
    
    @NotBlank(message = "Colour is required")
    private String favouritecolour;
    
    @NotBlank(message = "Hobby is required")
    private String hobby;
    
    public Person() {}
    
    public Person(String firstname, String lastname,
			String age, String favouritecolour,
			String hobby) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.favouritecolour = favouritecolour;
		this.hobby = hobby;
	}
    
    
    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getFavouritecolour() {
		return favouritecolour;
	}

	public void setFavouritecolour(String favouritecolour) {
		this.favouritecolour = favouritecolour;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	



	public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    

}
