package entities;


import java.io.Serializable;
import java.util.Date;

public abstract class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String lastname;
	private String surname;
	private String sex;
	private String picture;
	private String email;
	private Date birthday;

	public Person() {
		super();
	}

	public Person(long id, String lastname, String surname, String sex, String picture, String email, Date birthday) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.surname = surname;
		this.sex = sex;
		this.picture = picture;
		this.email = email;
		this.birthday = birthday;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
