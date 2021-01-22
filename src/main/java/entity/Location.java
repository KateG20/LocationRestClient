package entity;

import com.google.gson.annotations.SerializedName;

/**
 * Класс геолокации
 */
public class Location {
    public String getCountryName() {
        return countryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getCity() {
        return city;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @SerializedName("country_name")
    String countryName;
    @SerializedName("region_name")
    String regionName;
    String city;
    Double latitude;
    Double longitude;

    @Override
    public String toString() {
        return "Страна: " + countryName +
                "\nОбласть: " + regionName +
                "\nГород: " + city +
                "\nШирота: " + latitude +
                "\nДолгота: " + longitude;
    }
}
