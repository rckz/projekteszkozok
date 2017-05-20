package com.meglepeteskuldo.frontend.views;

import com.meglepeteskuldo.backend.entities.Consistency;
import com.meglepeteskuldo.backend.entities.MUser;
import com.meglepeteskuldo.backend.entities.Surprise;
import com.meglepeteskuldo.errors.UsernameOrPasswordMismatch;
import com.meglepeteskuldo.frontend.ButtonLayout;
import com.meglepeteskuldo.frontend.MonitorUI;
import com.meglepeteskuldo.frontend.presenter.SurprisePresenter;
import com.vaadin.server.Page;
import com.vaadin.ui.*;
import org.springframework.util.StringUtils;

import java.util.EnumSet;
import java.util.List;

public class BrowserView extends VerticalLayout {
	private TextField nameField;
	private TextField colorField;
	private ComboBox<Consistency> consistencyCombo;
	private TextField priceField;

	public BrowserView() {
		super();
		setContent();
	}

	private void setContent() {
		nameField = new TextField();
		nameField.setPlaceholder("Név");

		colorField = new TextField();
		colorField.setPlaceholder("Szín");

		consistencyCombo = new ComboBox<>();
		consistencyCombo.setItems(EnumSet.allOf(Consistency.class));
		consistencyCombo.setEmptySelectionAllowed(true);
		consistencyCombo.setEmptySelectionCaption("Mind");
		consistencyCombo.setPlaceholder("Viszkozitás");

		priceField = new TextField();
		priceField.setPlaceholder("Ár");

		Button searchButton = new Button("Szűrés");
		searchButton.addClickListener((Button.ClickListener) event -> {
			showFilteredSurprises();
		});

		HorizontalLayout menu = new HorizontalLayout();
		menu.addComponents(nameField, colorField, consistencyCombo, priceField, searchButton);

		Panel surpisePanel = new Panel();
		surpisePanel.setContent(showAllSurprises());

		this.addComponent(menu);
		this.addComponent(surpisePanel);
	}

	private Layout showFilteredSurprises(){
		String name = nameField.getValue();
		String color = colorField.getValue();
		Consistency consistency = consistencyCombo.getValue();

		String priceValue = priceField.getValue().trim();
		int price = 0;
		if(StringUtils.isEmpty(priceValue)){
			price = Integer.parseInt(priceValue);
		}
		return showSurpises(MonitorUI.getCurrent().getSp().getFilteredSurprise(name, color, consistency, price));
	}
	private Layout showAllSurprises(){
		return showSurpises(MonitorUI.getCurrent().getSp().getAllSurprise());
	}

	private VerticalLayout showSurpises(List<Surprise> surprises){
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		for (Surprise surprise : surprises) {
			HorizontalLayout surpriseLayout = new HorizontalLayout();
			surpriseLayout.setSizeFull();
			surpriseLayout.addComponent(createSurpiseTags(surprise.getProductName()));
			surpriseLayout.addComponent(createSurpiseTags(surprise.getColor()));
			surpriseLayout.addComponent(createSurpiseTags(String.valueOf(surprise.getConsistency())));
			surpriseLayout.addComponent(createSurpiseTags(String.valueOf(surprise.getPrice())+"$"));

			layout.addComponent(surpriseLayout);
			layout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
		}

		return layout;
	}

	private Label createSurpiseTags(String value){
		Label label = new Label(value);
		label.setWidth(100, Unit.PIXELS);
		return label;
	}
	
}
