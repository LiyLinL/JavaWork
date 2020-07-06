package com.liy.generator.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Jackson {

    @JsonProperty("SOME")
    private String some;

    @JsonProperty("ALWAYS")
    private String always;

    public String getSome() {
        return some;
    }

    public void setSome( String some ) {
        this.some = some;
    }

    public String getAlways() {
        return always;
    }

    public void setAlways( String always ) {
        this.always = always;
    }
}
