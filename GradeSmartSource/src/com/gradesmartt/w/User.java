/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gradesmartt.w;

/**
 *
 * @author Akshar
 */
public class User {
    private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String dob;
	private String answerOne;
	private String answerTwo;
	private String answerThree;
	
	public User(){
		this.setUsername("");
		this.setPassword("");
		this.setFirstName("");
		this.setLastName("");
		this.setEmail("");
		this.setDob("");
		this.setAnswerOne("");
		this.setAnswerTwo("");
		this.setAnswerThree("");
	}
	
	public User(String username, String password, String firstName, String lastName, String email, String dob, String answerOne, String answerTwo, String answerThree){
		this.setUsername(username);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setDob(dob);
		this.setAnswerOne(answerOne);
		this.setAnswerTwo(answerTwo);
		this.setAnswerThree(answerThree);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAnswerOne() {
		return answerOne;
	}

	public void setAnswerOne(String answerOne) {
		this.answerOne = answerOne;
	}

	public String getAnswerTwo() {
		return answerTwo;
	}

	public void setAnswerTwo(String answerTwo) {
		this.answerTwo = answerTwo;
	}

	public String getAnswerThree() {
		return answerThree;
	}

	public void setAnswerThree(String answerThree) {
		this.answerThree = answerThree;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
