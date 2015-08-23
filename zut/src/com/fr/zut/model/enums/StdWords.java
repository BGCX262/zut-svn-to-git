package com.fr.zut.model.enums;

/**
 * Standard words to use instead of direct string.
 * @author KONE
 */
public enum StdWords {

	ID("id"),
	USER_NAME("name"),
	SURNAME("surname"),
	USER_ID("user_id"),
	CREATED_AT("created_at");
	
	private String word;
	
	private StdWords(final String word) {
		this.word = word;
	}
	
	public String getWord() {
		return this.word;
	}
}
