package org.homeapart.domain.enums;

public enum City {
    MINSK(Country.BELARUS),
    KRAKOW(Country.POLAND),
    MOSCOW(Country.RUSSIA),
    KYIV(Country.UKRAINE),
    HOMEL(Country.BELARUS),
    HRODNA(Country.BELARUS),
    BREST(Country.BELARUS);

    private  Country country;

    private City(Country country) {
        this.country=country;
    }

    public Country getCountry() {
        return country;
    }
}
