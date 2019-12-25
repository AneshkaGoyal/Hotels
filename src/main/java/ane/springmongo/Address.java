package ane.springmongo;

import org.springframework.stereotype.Component;


public class Address {
    String city;
    String country;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }
}
