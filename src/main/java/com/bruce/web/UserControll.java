package com.bruce.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bruc.anotation.Hello;
import com.bruc.anotation.LoggerManage;
import com.bruce.bean.User;
import com.bruce.group.Login;
import com.bruce.group.Register;

@Controller
public class UserControll {
	
	/**
	 * 用户登录
	 */
	@RequestMapping("/login")
	@LoggerManage(logDescription="用户登录方法")
	public String login(@Validated({Login.class}) User user, BindingResult result, Model model) {
		// 首先要看 有没有校验出错
		int count = result.getErrorCount();
		if (count > 0) { // 说明有校验出错的地方
			// 获取所有的错误
			List<FieldError> errors = result.getFieldErrors();
			// 遍历这里面所有的错误
			for (FieldError fieldError : errors) {
				String msg = fieldError.getDefaultMessage();
				model.addAttribute(fieldError.getField(), msg);
				System.out.println(fieldError.getField() + "--------" + msg);
			}
			return "/login.jsp";

		}else{
			return "/register.jsp";
		}
	}

	/**
	 * 注册功能
	 */
	@RequestMapping("/register")
	@LoggerManage(logDescription="用户注册方法")
	// 这个里面就封装了错误信息 而且这个BindingResult不能单用 必须和@Valid一起使用
	public String register(@Validated({Register.class}) User user, BindingResult result, Model model) {
		int count = result.getErrorCount(); // 首先要看 有没有校验出错
		if (count > 0) { // 说明有校验出错的地方
			// 获取所有的错误
			List<FieldError> errors = result.getFieldErrors();
			// 遍历这里面所有的错误
			for (FieldError fieldError : errors) {
				String msg = fieldError.getDefaultMessage();
				model.addAttribute(fieldError.getField(), msg);
				System.out.println(fieldError.getField() + "--------" + msg);
			}
			return "/register.jsp";
		} else {
			System.out.println("数据验证通过，注册数据库......");
			return "/index.jsp";
		}

	}
}
