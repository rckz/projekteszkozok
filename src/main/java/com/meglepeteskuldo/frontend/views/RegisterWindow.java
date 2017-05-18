package com.meglepeteskuldo.frontend.views;

import com.meglepeteskuldo.errors.AlreadyExists;
import com.meglepeteskuldo.frontend.MonitorUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class RegisterWindow extends Window {
	//validáláshoz
	private final String BANK_ACC_REGEXP = "^[0-9]{8}([ -]?[0-9]{8}){1,2}$";
	
	private VerticalLayout vl;
	private HorizontalLayout hl;
	
	private Label l;
	private Label l2;
	
	private TextField uNameTf;
	private TextField nameTf;
	private TextField bankAccountTf;
	private TextField emailTf;
	
	private PasswordField pwdPf;
	
	private Button loginBt;
	private Button signupBt;
	
	public RegisterWindow(){
		super("Regisztráció");
		center();
		setContent(createContent());
	}
	
	private Layout createContent(){
		vl = new VerticalLayout();
		
		l = new Label("Regisztráció");
		nameTf = new TextField("Teles név");
		uNameTf = new TextField("Felhasználói név");
		bankAccountTf = new TextField("Bankszámlaszám");
		emailTf = new TextField("E-mail cím");
		pwdPf = new PasswordField("Jelszó");
		
		signupBt = new Button("Regisztálás");
		signupBt.addClickListener(this::doSignup);
		
		hl = new HorizontalLayout();
		l2 = new Label("Van már accountod? ");
		loginBt = new Button("Lépj be vele!");
		loginBt.addClickListener(this::openLoginWindow);
		loginBt.setStyleName("link");
		
		hl.addComponents(l2, loginBt);
		
		vl.addComponents(l, nameTf, uNameTf, pwdPf, bankAccountTf, emailTf, signupBt, hl);
		
		return vl;
	}
	
	private void openLoginWindow(ClickEvent e){
		UI.getCurrent().removeWindow(this);
		UI.getCurrent().addWindow(new LoginWindow());
	}
	
	private void doSignup(ClickEvent e){
		try {
			MonitorUI.getCurrent().getUp().register(uNameTf.getValue(), pwdPf.getValue(), emailTf.getValue(), bankAccountTf.getValue());
		} catch (AlreadyExists e1) {
			generateNotification("Már létezik ilyen felhasználó"+e1);
		}
	}

	private void generateNotification(String msg) {
		Notification not = new Notification(msg, Type.ERROR_MESSAGE);
	}
}
