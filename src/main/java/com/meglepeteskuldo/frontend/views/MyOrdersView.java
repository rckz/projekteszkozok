package com.meglepeteskuldo.frontend.views;

import com.meglepeteskuldo.backend.entities.MOrder;
import com.meglepeteskuldo.backend.entities.Surprise;
import com.meglepeteskuldo.frontend.MonitorUI;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;

import java.util.List;

/**
 * Created by Krisztián on 2017. 05. 21..
 */
public class MyOrdersView extends VerticalLayout {

	public MyOrdersView() {
		super();
		setContent();
	}

	private void setContent() {
		Panel surprisePanel = new Panel();
		surprisePanel.setContent(showOrders());

		this.addComponent(surprisePanel);
	}


	private VerticalLayout showOrders(){
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();

		HorizontalLayout headerLayout = new HorizontalLayout();
		headerLayout.setSizeFull();
		headerLayout.addComponent(createHeaderTags("Meglepetés neve:", 300));
		headerLayout.addComponent(createHeaderTags("Erre a címre megy:", 300));
		headerLayout.addComponent(createHeaderTags("Üzenet a címzettnek:", 300));

		layout.addComponent(headerLayout);
		layout.setComponentAlignment(headerLayout, Alignment.MIDDLE_CENTER);

		List<MOrder> orders = MonitorUI.getCurrent().getUser().getOrders();
		for (MOrder order : orders) {
			HorizontalLayout orderLayout = new HorizontalLayout();
			orderLayout.setSizeFull();
			orderLayout.addComponent(createOrderTags(order.getSurprise().getProductName(), 300));
			orderLayout.addComponent(createOrderTags(order.getAddress(), 300));
			orderLayout.addComponent(createOrderTags(order.getDescription(), 300));

			layout.addComponent(orderLayout);
			layout.setComponentAlignment(orderLayout, Alignment.MIDDLE_CENTER);
		}
		return layout;
	}

	private Label createOrderTags(String value, int width){
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
