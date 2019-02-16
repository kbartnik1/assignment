package com.gabi.pages;

import com.gabi.Config;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;

@NamedUrls({
        @NamedUrl(name = "staging", url = "https://staging.gabi.com/signup/step/1"),

})
@DefaultUrl("http://google.com")
public class DefaultPage extends PageObject implements Config {

    public DefaultPage() {
        loadProps();
    }

    public void openPageBasedOnProperties() {
        open(System.getProperty("env"), withParameters());
    }
}
