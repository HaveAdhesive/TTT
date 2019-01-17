package com.ttt.empSys.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 员工实体类
 */
@SuppressWarnings("serial")
public class Emp implements Serializable {

	private Integer id; 		//员工唯一标识
	private String name;		//员工姓名
	private String password;	//员工登录密码
	private String gender;		//员工性别
	private Integer age;		//员工年龄
	private Date hirdate;		//员工入职时间
	private Double salary;		//员工薪资
	private String phone;		//员工电话
	private String emali;		//员工邮箱
	
	/**
	 * 空参构造
	 */
	public Emp() {
		
	}

	/**
	 * 有参构造
	 * @param id
	 * @param name
	 * @param password
	 * @param gender
	 * @param age
	 * @param hirdate
	 * @param salary
	 * @param phone
	 * @param emali
	 */
	public Emp(Integer id, String name, String password, String gender, Integer age, Date hirdate, Double salary,
			String phone, String emali) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.hirdate = hirdate;
		this.salary = salary;
		this.phone = phone;
		this.emali = emali;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getHirdate() {
		return hirdate;
	}

	public void setHirdate(Date hirdate) {
		this.hirdate = hirdate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmali() {
		return emali;
	}

	public void setEmali(String emali) {
		this.emali = emali;
	}

	/**
	 * 重写toString方法
	 */
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", password=" + password + ", gender=" + gender + ", age=" + age
				+ ", hiredate=" + hirdate + ", slalry=" + salary + ", phone=" + phone + ", emali=" + emali + "]";
	}

	/**
	 * 重写hashcode方法
	 */
	@Override
	public int hashCode() {
		return  super.hashCode();
	}

	/**
	 * 重写equals方法
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}
