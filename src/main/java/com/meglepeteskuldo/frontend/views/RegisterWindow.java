package com.meglepeteskuldo.frontend.views;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class RegisterWindow extends Window {
	//validáláshoz
	private final String BANK_ACC_REGEXP = "^[0-9]{8}([ -]?[0-9]{8}){1,2}$";
	
	public RegisterWindow(){
		super("Regisztráció");
		center();
		setContent(createContent());
	}
	
	private Layout createContent(){
		VerticalLayout vl = new VerticalLayout();
		
		Label l = new Label("Regisztráció");
		TextField nameTf = new TextField("Teles név");
		TextField uNameTf = new TextField("Felhasználói név");
		TextField bankAccountTf = new TextField("Bankszámlaszám");
		TextField emailTf = new TextField("E-mail cím");
		PasswordField pwdPf = new PasswordField("Jelszó");
		
		Button signupBt = new Button("Regisztálás");
		signupBt.addClickListener(this::openLoginWindow);
		
		HorizontalLayout hl = new HorizontalLayout();
		Label l2 = new Label("Van már accountod? ");
		Button loginBt = new Button("Lépj be vele!");
		loginBt.addClickListener(this::doSignup);
		loginBt.setStyleName("link");
		
		hl.addComponents(l2, loginBt);
		
		vl.addComponents(l, nameTf, uNameTf, pwdPf, bankAccountTf, emailTf, signupBt, hl);
		
		return vl;
	}
	
	private void openLoginWindow(ClickEvent e){
		
	}
	
	private void doSignup(ClickEvent e){
		
	}
}
