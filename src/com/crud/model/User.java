package com.crud.model;

public class User {
	// �û���š��������Ա�����
	private int userId;
	private String name;
	private short sex;
	private int age;

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSex(short sex) {
		this.sex = sex;
	}

	public short getSex() {
		return sex;
	}

	public String getSexText() {
		if (sex == 1) {
			return "��";
		} else if (sex == 0) {
			return "Ů";
		} else {
			return "δ֪";
		}
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

}
