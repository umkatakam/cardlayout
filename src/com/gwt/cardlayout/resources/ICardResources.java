package com.gwt.cardlayout.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface ICardResources extends ClientBundle {

	@Source("card.css")
	ICardCssRescource getStyle();

	@Source("add.png")
	ImageResource add();

	@Source("expand.png")
	ImageResource expand();

	@Source("refresh.png")
	ImageResource refresh();

}
