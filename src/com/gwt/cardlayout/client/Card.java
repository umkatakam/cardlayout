package com.gwt.cardlayout.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.cardlayout.model.ICardData;
import com.gwt.cardlayout.resources.ICardResources;

public class Card extends Composite implements TakesValue<ICardData> {

	private static CardUiBinder uiBinder = GWT.create(CardUiBinder.class);
	private static ICardResources DEFAULT_RESOURCES = GWT.create(ICardResources.class);

	interface CardUiBinder extends UiBinder<Widget, Card> {
	}

	@UiField(provided = true)
	ICardResources resource;

	@UiField
	HTMLPanel header;

	@UiField
	HTMLPanel content;

	ICardData cardData;

	public Card() {
		this(DEFAULT_RESOURCES);
	}

	public Card(ICardResources resource) {
		this.resource = resource;
		initWidget(uiBinder.createAndBindUi(this));
		resource.getStyle().ensureInjected();
	}

	private void setHeading(String heading) {
		header.getElement().setInnerText(heading);
	}

	private void setContent(String data) {
		content.getElement().setInnerText(data);
	}

	@Override
	public void setValue(ICardData cardData) {
		this.cardData = cardData;
		setHeading(cardData.getHeading());
		setContent(cardData.getContent());
	}

	@Override
	public ICardData getValue() {
		return cardData;
	}

}
