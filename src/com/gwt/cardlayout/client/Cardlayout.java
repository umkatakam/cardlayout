package com.gwt.cardlayout.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwt.cardlayout.model.ICardData;
import com.gwt.cardlayout.model.RandomString;
import com.gwt.cardlayout.model.SimpleCardData;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Cardlayout implements EntryPoint {

	RandomString contentRandomizer = new RandomString(5);
	RandomString headingRandomizer = new RandomString(15);

	@Override
	public void onModuleLoad() {
		for (int i = 0; i < 15; i++) {
			RootPanel.get().add(getNewCard(i));
		}

	}

	private Card getNewCard(int index) {
		Card card = new Card();
		ICardData data = new SimpleCardData();
		data.setHeading(headingRandomizer.nextString());
		data.setContent(getRandomContent());
		card.setValue(data);
		return card;
	}

	private String getRandomContent() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 75; i++) {
			sb.append(contentRandomizer.nextString()).append(" ");
		}
		return sb.toString();
	}

}
