package fr.dorian.web.impl;

public class Redirect {

	public static String redirect(String page) {
		return String.format("%s?faces-redirect=true", page);
	}

	public static String redirect(String page, String title) {
		return String.format("%s?%s&faces-redirect=true", page, title);
	}
	
	public static String redirect(String page, String label, String title) {
		return String.format("%s?%s=%s&faces-redirect=true", page, label, title);
	}

	public static String redirectThread(String page, String title) {
		return String.format("%s?%s=%s&faces-redirect=true", page, "th", title);
	}

	public static String redirectTutorial(String page, String title) {
		return String.format("%s?%s=%s&faces-redirect=true", page, "tu", title);
	}

}
