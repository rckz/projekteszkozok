package com.meglepeteskuldo.frontend;

import com.meglepeteskuldo.frontend.views.BrowserView;
import com.meglepeteskuldo.frontend.views.HomeView;
import com.meglepeteskuldo.frontend.views.LoginWindow;
import com.meglepeteskuldo.frontend.views.OrderView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * Created by Krisztián on 2017. 04. 17..
 */
public class ButtonLayout extends HorizontalLayout {
	VerticalLayout contentLayout;

	private Button homeButton;
	private Button browserButton;
	private Button orderButton;
	private Button loginButton;

	public ButtonLayout(VerticalLayout contentLayout) {
		this.contentLayout = contentLayout;
		setWidth(100, Unit.PERCENTAGE);
		setHeight(40, Unit.PIXELS);
		// setMargin(true);
		setSpacing(true);
		init();
	}

	private void init() {
		homeButton = new Button("Főoldal");
		customizeButton(homeButton);
		homeButton.addClickListener(this::showHomeView);

		browserButton = new Button("Böngészés");
		customizeButton(browserButton);
		browserButton.addClickListener(this::showBrowserView);

		orderButton = new Button("Rendelés");
		customizeButton(orderButton);
		orderButton.addClickListener(this::showOrderView);

		loginButton = new Button("Belépés");
		customizeButton(loginButton);
		loginButton.setStyleName("link");
		loginButton.addClickListener(this::showLoginWindow);
	}

	private void customizeButton(Button button) {
		// button.setWidth(70, Unit.PIXELS);
		// button.setHeight(30, Unit.PIXELS);
		// button.addStyleName("button-navigation");
		addComponent(button);
		setComponentAlignment(button, Alignment.MIDDLE_CENTER);
	}

	private void showHomeView(ClickEvent e) {
		contentLayout.removeAllComponents();
		contentLayout.addComponent(new HomeView());
	}

	private void showBrowserView(ClickEvent e) {
		contentLayout.removeAllComponents();
		contentLayout.addComponent(new BrowserView());
	}

	private void showOrderView(ClickEvent e) {
		contentLayout.removeAllComponents();
		contentLayout.addComponent(new OrderView());
	}

	private void showLoginWindow(ClickEvent e) {
		if (UI.getCurrent().getWindows().isEmpty()) {
			UI.getCurrent().addWindow(new LoginWindow());
		}
	}
}
