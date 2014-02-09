package com.gwt.cardlayout.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.cardlayout.event.RefreshCallback;
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
	HTMLPanel headerText;

	@UiField
	HTMLPanel buttonBar;

	@UiField
	HTMLPanel content;

	@UiField
	FocusPanel refresh;

	@UiField
	FocusPanel expand;

	ICardData cardData;

	RefreshCallback refreshCallback;

	public Card() {
		this(DEFAULT_RESOURCES);
	}

	public Card(ICardResources resource) {
		this.resource = resource;
		this.resource.getStyle().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
	}

	private void setHeading(String heading) {
		headerText.getElement().setInnerText(heading);
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

	public void setRefreshCallback(RefreshCallback refreshCallback) {
		this.refreshCallback = refreshCallback;
	}

	public void hideButtonBar() {
		buttonBar.setVisible(false);
	}

	@UiHandler("refresh")
	void onRefreshClicked(ClickEvent event) {
		if (refreshCallback != null) {
			refreshCallback.onRefresh();
		}
	}

	@UiHandler("expand")
	void onExpandClicked(ClickEvent event) {
		PopupPanel popupPanel = new PopupPanel(true, true);
		popupPanel.setAnimationEnabled(true);
		Card duplicate = this;
		duplicate.hideButtonBar();
		duplicate.content.getElement().getStyle().setOverflow(Overflow.VISIBLE);
		popupPanel.add(duplicate);
		popupPanel.setGlassEnabled(true);
		popupPanel.center();
	}
}
