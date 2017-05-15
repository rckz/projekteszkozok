package com.meglepeteskuldo.frontend.views;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * Created by Krisztián on 2017. 04. 17..
 */
public class LoginWindow extends Window {
    //felugró modális ablak
	
	public LoginWindow(){
		super("Bejelentkezés");
		center();
		setContent(createContent());
	}
	
	private Layout createContent(){
		VerticalLayout vl = new VerticalLayout();
		
		Label l = new Label("Belépés");
		TextField uNameTf = new TextField("Felhasználói név");
		PasswordField pwdPf = new PasswordField("Jelszó");
		
		Button loginBt = new Button("Belépés");
		loginBt.addClickListener(this::doLogin);
		
		HorizontalLayout hl = new HorizontalLayout();
		Label l2 = new Label("Nincs még accountod? ");
		Button signupBt = new Button("Regisztrálj most!");
		signupBt.addClickListener(this::doSignup);
		signupBt.setStyleName("link");
		
		hl.addComponents(l2, signupBt);
		
		vl.addComponents(l, uNameTf, pwdPf, loginBt, hl);
		
		return vl;
	}
	
	private void doLogin(ClickEvent e){
		
	}
	
	private void doSignup(ClickEvent e){
		
	}
}
