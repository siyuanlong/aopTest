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
	 * �û���¼
	 */
	@RequestMapping("/login")
	@LoggerManage(logDescription="�û���¼����")
	public String login(@Validated({Login.class}) User user, BindingResult result, Model model) {
		// ����Ҫ�� ��û��У�����
		int count = result.getErrorCount();
		if (count > 0) { // ˵����У�����ĵط�
			// ��ȡ���еĴ���
			List<FieldError> errors = result.getFieldErrors();
			// �������������еĴ���
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
	 * ע�Ṧ��
	 */
	@RequestMapping("/register")
	@LoggerManage(logDescription="�û�ע�᷽��")
	// �������ͷ�װ�˴�����Ϣ �������BindingResult���ܵ��� �����@Validһ��ʹ��
	public String register(@Validated({Register.class}) User user, BindingResult result, Model model) {
		int count = result.getErrorCount(); // ����Ҫ�� ��û��У�����
		if (count > 0) { // ˵����У�����ĵط�
			// ��ȡ���еĴ���
			List<FieldError> errors = result.getFieldErrors();
			// �������������еĴ���
			for (FieldError fieldError : errors) {
				String msg = fieldError.getDefaultMessage();
				model.addAttribute(fieldError.getField(), msg);
				System.out.println(fieldError.getField() + "--------" + msg);
			}
			return "/register.jsp";
		} else {
			System.out.println("������֤ͨ����ע�����ݿ�......");
			return "/index.jsp";
		}

	}
}
