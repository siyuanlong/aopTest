package com.bruce.bean;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.bruce.group.Login;
import com.bruce.group.Register;

/**
 * ��д������ʵ��
 */
public class User implements Serializable {

	@Min(value = 1, message = "����С��1", groups = { Register.class })
	@Max(value = 10, message = "���ܴ���10",groups = { Register.class })
	@NotNull(message = "�û���ID����Ϊnull",groups = { Register.class })
	private Integer userId;

	@NotNull(message = "�û�������Ϊnull",groups = { Login.class,Register.class})
	@Length(min = 5, max = 10, message = "�û���ֻ��5��10λ֮��",groups = { Login.class,Register.class})
	private String userName;

	@NotNull(message = "���벻��Ϊnull",groups = { Login.class,Register.class})
	@Length(min = 5, max = 10, message = "���������5��10λ֮��",groups = { Login.class,Register.class})
	private String password;

	@NotNull(message = "���䲻��Ϊnull",groups = { Register.class })
	@Email(message = "���䲻�Ϸ�~~",groups = { Register.class })
	private String email;

	public User(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public User() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
}
