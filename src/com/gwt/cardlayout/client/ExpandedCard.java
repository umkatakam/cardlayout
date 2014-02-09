package com.gwt.cardlayout.client;

import com.google.gwt.dom.client.Style.Overflow;

public class ExpandedCard extends Card {

	public ExpandedCard() {
		panel.setWidth("500px");
		content.setHeight("350px");
		header.setHeight("50px");
		content.getElement().getStyle().setOverflow(Overflow.VISIBLE);
		hideButtonBar();
	}

}
