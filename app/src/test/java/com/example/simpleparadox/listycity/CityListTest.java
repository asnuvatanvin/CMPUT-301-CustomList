package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class  CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testDeleteCities(){

        CityList citylist = mockCityList();

        assertEquals(1, citylist.getCities().size());

        City city = new City("New York", "Brooklyn");
        citylist.add(city);
        City city1 = new City("London","Hampshire");
        citylist.add(city1);

        assertEquals(3,citylist.getCities().size());

        citylist.delete(city);
        assertEquals(2,citylist.getCities().size());
        assertFalse(citylist.getCities().contains(city));

    }

    @Test
    void testlist_size(){
        CityList citylist = mockCityList();

        assertEquals(1, citylist.list_size());

        City city = new City("New York", "Brooklyn");
        citylist.add(city);
        City city1 = new City("London","Hampshire");
        citylist.add(city1);

        assertEquals(3,citylist.list_size());

        citylist.delete(city);
        assertEquals(2,citylist.list_size());

    }

}