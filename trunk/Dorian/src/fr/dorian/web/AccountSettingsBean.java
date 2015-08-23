package fr.dorian.web;

import fr.dorian.model.AccountSettings;

public interface AccountSettingsBean {

	void setSettings(AccountSettings settings);

	AccountSettings getSettings();

	void save();

}
