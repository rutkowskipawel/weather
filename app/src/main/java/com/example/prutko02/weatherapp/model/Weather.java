package com.example.prutko02.weatherapp.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Weather extends RealmObject {

    private String countryCode;
    @PrimaryKey
    private String cityName;
    private Double temperature;
    private String description;
    @Required
    private Integer pressure;
    @Required
    private Integer humidity;
    @Required
    private Double tempMin;
    @Required
    private Double tempMax;
    @Required
    private Double longitude;
    @Required
    private Double latitude;
    @Required
    private Integer timestamp;

    public Weather() {
    }


    Weather(String countryCode, String cityName, Double temperature, String description, Integer pressure, Integer humidity, Double tempMin, Double tempMax, Double longitude, Double latitude, Integer timestamp) {
        this.countryCode = countryCode;
        this.cityName = cityName;
        this.temperature = temperature;
        this.description = description;
        this.pressure = pressure;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.longitude = longitude;
        this.latitude = latitude;
        this.timestamp = timestamp;
    }


    public static class WeatherBuilder {
        private String countryCode;
        private String cityName;
        private Double temperature;
        private String description;
        private Integer pressure;
        private Integer humidity;
        private Double tempMin;
        private Double tempMax;
        private Double longitude;
        private Double latitude;
        private Integer timestamp;

        public WeatherBuilder setCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public WeatherBuilder setCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public WeatherBuilder setTemperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }

        public WeatherBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public WeatherBuilder setPressure(Integer pressure) {
            this.pressure = pressure;
            return this;
        }

        public WeatherBuilder setHumidity(Integer humidity) {
            this.humidity = humidity;
            return this;
        }

        public WeatherBuilder setTempMin(Double tempMin) {
            this.tempMin = tempMin;
            return this;
        }

        public WeatherBuilder setTempMax(Double tempMax) {
            this.tempMax = tempMax;
            return this;
        }

        public WeatherBuilder setLongitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        public WeatherBuilder setLatitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public WeatherBuilder setTimestamp(Integer timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Weather createWeather() {
            return new Weather(countryCode, cityName, temperature, description, pressure, humidity, tempMin, tempMax, longitude, latitude, timestamp);
        }
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCityName() {
        return cityName;
    }

    public Double getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "countryCode='" + countryCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", temperature=" + temperature +
                ", description='" + description + '\'' +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", timestamp=" + timestamp +
                '}';
    }
}
