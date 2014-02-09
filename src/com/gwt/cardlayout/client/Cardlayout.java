package com.gwt.cardlayout.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwt.cardlayout.event.RefreshCallback;
import com.gwt.cardlayout.model.ICardData;
import com.gwt.cardlayout.model.RandomString;
import com.gwt.cardlayout.model.SimpleCardData;

public class Cardlayout implements EntryPoint {

	RandomString contentRandomizer = new RandomString(5);
	RandomString headingRandomizer = new RandomString(15);
	RandomString metaDataRandomizer = new RandomString(35);

	@Override
	public void onModuleLoad() {
		for (int i = 0; i < 15; i++) {
			RootPanel.get().add(getNewCard(i));
		}

	}

	private Card getNewCard(int index) {
		final Card card = new Card();
		ICardData data = getRandomCardData();
		card.setRefreshCallback(new RefreshCallback() {

			@Override
			public void onRefresh() {
				card.setValue(getRandomCardData());

			}
		});
		card.setValue(data);
		return card;
	}

	private ICardData getRandomCardData() {
		ICardData data = new SimpleCardData();
		data.setHeading(headingRandomizer.nextString());
		data.setContent(getRandomContent());
		data.setMetaData(metaDataRandomizer.nextString());
		return data;
	}

	private String getRandomContent() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 75; i++) {
			sb.append(contentRandomizer.nextString()).append(" ");
		}
		return sb.toString();
	}

}
