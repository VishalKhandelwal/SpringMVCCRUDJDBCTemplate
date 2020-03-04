package com.vk.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Person")
public class Person {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message="name can't be empty")
	@Column(name="name")
    private String name;
	
	@NotEmpty(message="email can't be empty")
	@Email(message="Enter Valid Email Id")
	@Column(name="email")
	private String email;
	
	@NotEmpty(message="DOB can't be empty")
	@Column(name="dob")
	private String dob;
	
	@NotEmpty(message="gender can't be empty")
	@Column(name="gender")
	private String gender;
	
	@NotEmpty(message="address can't be empty")
	@Column(name="address")
	private String address;
	
	@NotEmpty(message="city can't be empty")
	@Column(name="city")
	private String city;
	
	@NotEmpty(message="password can't be empty")
	@Column(name="password")
	private String password;

	@NotNull(message="phone can't be empty")
	@Min(value = 1000000000,message="Please Enter valid no.")
	@Column(name = "phone")
	private Long phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", gender=" + gender
				+ ", address=" + address + ", city=" + city + ", password=" + password + ", phone=" + phone + "]";
	}

		
	
}
