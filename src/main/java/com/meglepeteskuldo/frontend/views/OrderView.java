package com.meglepeteskuldo.frontend.views;

import java.util.Arrays;

import com.meglepeteskuldo.backend.entities.Surprise;
import com.meglepeteskuldo.frontend.MonitorUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Krisztián on 2017. 04. 17..
 */
public class OrderView extends VerticalLayout {
	// ide mehet a form szerű dolog küldéssel

	private ComboBox<Surprise> nameCb;
	private ComboBox optionsCb;

	private TextArea addressTa;
	private TextArea msgTa;

	private Button sendBt;

	public OrderView() {
		super();
		setContent();
	}

	private void setContent() {
		nameCb = new ComboBox<>();
		nameCb.setItems(MonitorUI.getCurrent().getSp().getAllSurprise());
		nameCb.setItemCaptionGenerator((e) -> e.getProductName() + " - " + e.getPrice() + "$");
		optionsCb = new ComboBox<>();
		optionsCb.setItems(Arrays.asList("gyorsposta", "még gyorsabb", "ráér holnap is"));
		addressTa = new TextArea();
		msgTa = new TextArea();
		sendBt = new Button("Küldés");

		nameCb.setPlaceholder("Termék fantázianeve");
		optionsCb.setPlaceholder("Csomag opciók");
		addressTa.setPlaceholder("Csomag címzése");
		msgTa.setPlaceholder("Üzenet a címzettnek");
		sendBt.addClickListener(this::doSend);

		this.addComponents(nameCb, optionsCb, addressTa, msgTa, sendBt);
	}

	private void doSend(ClickEvent e) {
		if (nameCb.getValue() == null || optionsCb.getValue() == null || addressTa.getValue() == null) {
			generateNotification("Üresen hagytál néhány mezőt");
		} else {
			MonitorUI.getCurrent().getOp().sendOrder(MonitorUI.getCurrent().getUser(), nameCb.getValue(),
					addressTa.getValue(), msgTa.getValue());
			new Notification("A rendelés feladva", Type.HUMANIZED_MESSAGE);
		}
	}

	private void generateNotification(String msg) {
		Notification not = new Notification(msg, Type.ERROR_MESSAGE);
	}
}
