import com.google.gson.annotations.SerializedName;

public class Location {
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
