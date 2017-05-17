package com.meglepeteskuldo.frontend.views;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Krisztián on 2017. 04. 16..
 */
public class HomeView extends VerticalLayout {

	public HomeView() {
		init();
	}

	private void init() {
		Label title = new Label("<h1>Meglepetésküldő</h1>", ContentMode.HTML);
		//sok a <p>, valamé anélkül egy sorba írja ki az egészet, nem érzi a képernyő szélét (br-el a másképp nem megy)
		//ezt próbáld meg esetleg css-be, nem találtam a mappáját
		//.v-label
		//{
		//	   white-space: normal;
		//	}
		Label content = new Label(
				"<p>Meglepetést szeretnél küldeni egy ismerősödnek? Tedd meg nálunk.</p>"
				+ " <p>Csak be kell regisztrálnod, és mehet a móka.</p><p> Válaszd ki a neked tetsző meglepetést,"
				+ " add meg az ismerősöd címét, és üzenj neki.</p><p> Ennyi az egész.</p>", ContentMode.HTML);
		this.addComponents(title, content);
	}
}
