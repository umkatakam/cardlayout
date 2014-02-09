package com.gwt.cardlayout.model;

public class SimpleCardData implements ICardData {

	String heading;
	String content;
	String metadata;

	@Override
	public String getHeading() {
		return heading;
	}

	@Override
	public void setHeading(String heading) {
		this.heading = heading;

	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public void setContent(String content) {
		this.content = content;

	}

	@Override
	public String getMetdaData() {
		return metadata;
	}

	@Override
	public void setMetaData(String metadata) {
		this.metadata = metadata;

	}

}
