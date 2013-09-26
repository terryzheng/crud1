package com.crud.database;

public class UserModel {
	// 用户编号、姓名、性别、年龄
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
			return "男";
		} else if (sex == 0) {
			return "女";
		} else {
			return "未知";
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
		final UserModel other = (UserModel) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

}
