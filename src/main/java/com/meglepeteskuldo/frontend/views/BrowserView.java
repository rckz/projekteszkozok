package com.meglepeteskuldo.frontend.views;

import com.meglepeteskuldo.backend.entities.Consistency;
import com.meglepeteskuldo.backend.entities.MUser;
import com.meglepeteskuldo.backend.entities.Surprise;
import com.meglepeteskuldo.errors.UsernameOrPasswordMismatch;
import com.meglepeteskuldo.frontend.ButtonLayout;
import com.meglepeteskuldo.frontend.MonitorUI;
import com.meglepeteskuldo.frontend.presenter.SurprisePresenter;
import com.vaadin.server.Page;
import com.vaadin.shared.ui.ContentMode;
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
		priceField.setPlaceholder("Ár kisebb mint");

		Panel surpisePanel = new Panel();
		surpisePanel.setContent(showAllSurprises());

		Button searchButton = new Button("Szűrés");
		searchButton.addClickListener((Button.ClickListener) event -> surpisePanel.setContent(showFilteredSurprises()));

		Button resetButton = new Button("Reset");
		resetButton.addClickListener((Button.ClickListener) event -> {
			nameField.setValue("");
			colorField.setValue("");
			priceField.setValue("");
			consistencyCombo.setValue(null);
			surpisePanel.setContent(showAllSurprises());
		});

		HorizontalLayout menu = new HorizontalLayout();
		menu.addComponents(nameField, colorField, consistencyCombo, priceField, searchButton, resetButton);

		this.addComponent(menu);
		this.addComponent(surpisePanel);
	}

	private Layout showFilteredSurprises(){
		String name = nameField.getValue();

		String color = colorField.getValue();

		Consistency consistency = consistencyCombo.getValue();

		String priceValue = priceField.getValue().trim();
		int price = 999999;
		if(!StringUtils.isEmpty(priceValue)){
			try{
				price = Integer.parseInt(priceValue);
				return showSurprises(MonitorUI.getCurrent().getSp().getFilteredSurprise(name, color, consistency, price));
			}catch(Exception e){
				new Notification("Az árnak egy egész számot kell megadni!",
						Notification.Type.ERROR_MESSAGE).show(Page.getCurrent());
			}
		}
		return new VerticalLayout();
	}
	private Layout showAllSurprises(){
		return showSurprises(MonitorUI.getCurrent().getSp().getAllSurprise());
	}

	private VerticalLayout showSurprises(List<Surprise> surprises){
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();

		HorizontalLayout headerLayout = new HorizontalLayout();
		headerLayout.setSizeFull();
		headerLayout.addComponent(createHeaderTags("Név:", 350));
		headerLayout.addComponent(createHeaderTags("Szín:",100));
		headerLayout.addComponent(createHeaderTags("Viszkozitás:",100));
		headerLayout.addComponent(createHeaderTags("Ár:", 100));

		headerLayout.setExpandRatio(headerLayout.getComponent(0), 1.0f);

		layout.addComponent(headerLayout);
		layout.setComponentAlignment(headerLayout, Alignment.MIDDLE_CENTER);


		for (Surprise surprise : surprises) {
			HorizontalLayout surpriseLayout = new HorizontalLayout();
			surpriseLayout.setSizeFull();
			surpriseLayout.addComponent(createSurpriseTags(surprise.getProductName(), 350));
			surpriseLayout.addComponent(createSurpriseTags(surprise.getColor(),100));
			surpriseLayout.addComponent(createSurpriseTags(String.valueOf(surprise.getConsistency()),100));
			surpriseLayout.addComponent(createSurpriseTags(String.valueOf(surprise.getPrice())+"$", 100));

			surpriseLayout.setExpandRatio(surpriseLayout.getComponent(0), 1.0f);

			layout.addComponent(surpriseLayout);
			layout.setComponentAlignment(surpriseLayout, Alignment.MIDDLE_CENTER);
		}

		return layout;
	}

	private Label createSurpriseTags(String value, int width){
		Label label = new Label(value);
		label.setWidth(width, Unit.PIXELS);
		return label;
	}

	private Label createHeaderTags(String value, int width){
		Label label = new Label("<b>"+value+"<b>", ContentMode.HTML);
		label.setWidth(width, Unit.PIXELS);
		return label;
	}
	
}
