/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author think
 */
@Named(value = "language")
@SessionScoped
public class LanguageController implements Serializable {
    
    private Logger logger=LoggerFactory.getLogger(LanguageController.class);

    private String localeCode;
    private static  Map<String, Locale> countries = new HashMap<String, Locale>() {
        {
            put("English", Locale.ENGLISH);
            put("Chinese", Locale.SIMPLIFIED_CHINESE);
        }
    };

    public  Map<String, Locale> getCountries() {
        return countries;
    }

    public void setCountries(Map<String, Locale> countries) {
        LanguageController.countries = countries;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public void countryLocaleCodeChanged(ValueChangeEvent e) {
        String newLocaleValue = e.getNewValue().toString();
        logger.error(newLocaleValue);
        for (Map.Entry<String, Locale> entry : countries.entrySet()) {
            if (entry.getValue().toString().equals(newLocaleValue)) {
                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale( entry.getValue());
            }
        }
    }
}
