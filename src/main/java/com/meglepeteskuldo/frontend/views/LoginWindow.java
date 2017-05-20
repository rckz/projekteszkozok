package com.meglepeteskuldo.frontend.views;

import com.meglepeteskuldo.backend.entities.MUser;
import com.meglepeteskuldo.errors.UsernameOrPasswordMismatch;
import com.meglepeteskuldo.frontend.ButtonLayout;
import com.meglepeteskuldo.frontend.MonitorUI;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
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

/**
 * Created by Krisztián on 2017. 04. 17..
 */
public class LoginWindow extends Window {
    //felugró modális ablak
	
	private VerticalLayout vl;
	private HorizontalLayout hl;

	private Label l2;
	
	private TextField uNameTf;
	
	private PasswordField pwdPf;
	
	private Button loginBt;
	private Button signupBt;
	
	public LoginWindow(){
		super("Belépés");
		center();
		this.setModal(true);
		setContent(createContent());
	}
	
	private Layout createContent(){
		vl = new VerticalLayout();

		uNameTf = new TextField("Felhasználói név");
		pwdPf = new PasswordField("Jelszó");
		
		loginBt = new Button("Belépés");
		loginBt.addClickListener(this::doLogin);
		
		hl = new HorizontalLayout();
		l2 = new Label("Nincs még accountod? ");
		signupBt = new Button("Regisztrálj most!");
		signupBt.addClickListener(this::openRegisterWindow);
		signupBt.setStyleName("link");
		
		hl.addComponents(l2, signupBt);
		
		vl.addComponents(uNameTf, pwdPf, loginBt, hl);
		
		return vl;
	}
	
	private void doLogin(ClickEvent e){
		try {
			MUser user = MonitorUI.getCurrent().getUp().login(uNameTf.getValue(), pwdPf.getValue());
			MonitorUI.getCurrent().setUser(user);
			MonitorUI.getCurrent().removeWindow(this);
			((ButtonLayout) MonitorUI.getCurrent().getButtonLayout()).doLogin();
		} catch (UsernameOrPasswordMismatch e1) {
			generateNotification("Hibás felhasználónév, vagy jelszó"+e1);
		}
	}
	
	private void openRegisterWindow(ClickEvent e){
		UI.getCurrent().removeWindow(this);
		UI.getCurrent().addWindow(new RegisterWindow());
	}
	
	private void generateNotification(String msg){
		new Notification(msg, Type.ERROR_MESSAGE).show(Page.getCurrent());
	}
}
