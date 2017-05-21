package com.meglepeteskuldo.frontend.views;

import java.util.Arrays;

import com.meglepeteskuldo.backend.entities.Surprise;
import com.meglepeteskuldo.frontend.ButtonLayout;
import com.meglepeteskuldo.frontend.MonitorUI;
import com.vaadin.server.Page;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;

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
		nameCb.setWidth(450, Unit.PIXELS);
		nameCb.setItems(MonitorUI.getCurrent().getSp().getAllSurprise());
		nameCb.setItemCaptionGenerator((e) -> e.getProductName() + " - " + e.getPrice() + "$");
		optionsCb = new ComboBox<>();
		optionsCb.setWidth(450, Unit.PIXELS);
		optionsCb.setItems(Arrays.asList("gyorsposta", "még gyorsabb", "ráér holnap is"));
		addressTa = new TextArea();
		addressTa.setWidth(450, Unit.PIXELS);
		msgTa = new TextArea();
		msgTa.setWidth(450, Unit.PIXELS);
		sendBt = new Button("Küldés");

		nameCb.setPlaceholder("Termék fantázianeve");
		optionsCb.setPlaceholder("Csomag opciók");
		addressTa.setPlaceholder("Csomag címzése");
		msgTa.setPlaceholder("Üzenet a címzettnek");
		sendBt.addClickListener(this::doSend);

		this.addComponents(nameCb, optionsCb, addressTa, msgTa, sendBt);
		this.setComponentAlignment(nameCb, Alignment.MIDDLE_CENTER);
		this.setComponentAlignment(optionsCb, Alignment.MIDDLE_CENTER);
		this.setComponentAlignment(addressTa, Alignment.MIDDLE_CENTER);
		this.setComponentAlignment(msgTa, Alignment.MIDDLE_CENTER);
		this.setComponentAlignment(sendBt, Alignment.MIDDLE_CENTER);
	}

	private void doSend(ClickEvent e) {
		if (nameCb.getValue() == null || optionsCb.getValue() == null || addressTa.getValue() == null) {
			generateNotification("Üresen hagytál néhány mezőt");
		} else {
			MonitorUI.getCurrent().setUser(MonitorUI.getCurrent().getOp().sendOrder(MonitorUI.getCurrent().getUser(), nameCb.getValue(),
					addressTa.getValue(), msgTa.getValue()));
			Notification notification = new Notification("A rendelés feladva", Type.HUMANIZED_MESSAGE);
			notification.setDelayMsec(3000);
			notification.show(Page.getCurrent());

			((ButtonLayout)MonitorUI.getCurrent().getButtonLayout()).getMyOrdersButton().click();
		}
	}

	private void generateNotification(String msg) {
		new Notification(msg, Type.ERROR_MESSAGE).show(Page.getCurrent());

	}
}
