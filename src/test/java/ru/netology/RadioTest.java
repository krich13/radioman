package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void objectCreationWithSpecifiedStationAmount() {  //можно задавать любое количество радиостанций при создании объекта
        Radio radio = new Radio(30);
        radio.getStationAmount();
        assertEquals(30, radio.getStationAmount());
    }

    @Test
    void objectCreationWithDefaultStationAmount() {  //если желаемое кол-во станций не задано, то по дефолту будет 10
        Radio radio = new Radio();
        radio.getStationAmount();
        assertEquals(10, radio.getStationAmount());
    }

    //тесты на переключение станций

    @Test
    void setNextStationWithSpecifiedStationAmount() { //мы проверяем переключение на следующую станцию при заданном кол-ве станций, используя конструктор
        Radio radio = new Radio(102, 2, 150);
        radio.setNextStation();
        int actual = radio.getCurrentStation();
        int expected = 103;
        assertEquals(expected, actual);
    }

    @Test
    void setNextStationWithDefaultStationAmount() { //мы проверяем переключение на следующую станцию при дефолтном кол-ве станций
        Radio radio = new Radio(8, 2);
        radio.setNextStation();
        int actual = radio.getCurrentStation();
        int expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    void setPreviousStationWithSpecifiedStationAmount() { //мы проверяем переключение на предыдущую станцию при заданном кол-ве станций, используя конструктор
        Radio radio = new Radio(3, 2, 15);
        radio.setPreviousStation();
        int actual = radio.getCurrentStation();
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void setPreviousStationWithDefaultStationAmount() { //мы проверяем переключение на предыдущую станцию при дефолтном кол-ве станций, используя конструктор
        Radio radio = new Radio(3, 2);
        radio.setPreviousStation();
        int actual = radio.getCurrentStation();
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationAboveMaxWithDefaultStationAmount() {
        Radio radio = new Radio(); // если пользователь хочет поставить станцию выше максимальной, то ничего не проиcходит (он остается на уже включенной)
        int stationToStartWith = 3;
        radio.setStation(stationToStartWith);
        int weWantToSetOutOfLimits = radio.getMaxStation() + 40;
        radio.setStation(weWantToSetOutOfLimits);
        int actual = radio.getCurrentStation();
        int expected = stationToStartWith;
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationAboveMaxWithSpecifiedStationAmount() {
        Radio radio = new Radio(250, 2, 200);
        radio.setStation(radio.getMaxStation() + 40);
        int actual = radio.getCurrentStation();
        int expected = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationAboveMinWithSpecifiedStationAmount() {
        Radio radio = new Radio(5, 2, 200);
        radio.setStation(radio.getMinStation() - 40);
        int actual = radio.getCurrentStation();
        int expected = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationAboveMinWithDefaultStationAmount() {
        Radio radio = new Radio();
        radio.setStation(radio.getMinStation() - 40);
        int actual = radio.getCurrentStation();
        int expected = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void setNextStationOnEdgeWithSpecifiedStationAmount() { //мы проверяем переключение с последней на первую станцию с помощью конструктора при заданном кол-ве станций
        Radio radio = new Radio(99, 2, 100);
        radio.setNextStation();
        int actual = radio.getCurrentStation();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void setNextStationOnEdgeWithDefaultStationAmount() { //мы проверяем переключение с последней на первую станцию с помощью конструктора при дефолтном кол-ве станций
        Radio radio = new Radio(9, 2);
        radio.setNextStation();
        int actual = radio.getCurrentStation();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void setPreviousStationOnEdgeWithSpecifiedStationAmount() { //мы проверяем переключение с первой на последнюю станцию с помощью конструктора при заданном кол-ве станций
        Radio radio = new Radio(0, 2, 150);
        radio.setPreviousStation();
        int actual = radio.getCurrentStation();
        int expected = 149;
        assertEquals(expected, actual);
    }

    @Test
    void setPreviousStationOnEdgeWithDefaultStationAmount() { //мы проверяем переключение с первой на последнюю станцию с помощью конструктора при дефолтном кол-ве станций
        Radio radio = new Radio(0, 5);
        radio.setPreviousStation();
        int actual = radio.getCurrentStation();
        int expected = 9;
        assertEquals(expected, actual);
    }

    //тесты на громкость
    @Test
    void increaseVolume() { //мы увеличиваем громкость с помощью конструктора
        Radio radio = new Radio(5, 4);
        radio.setIncreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void decreaseVolume() { //мы уменьшаем громкость с помощью конструктора
        Radio radio = new Radio(5, 5);
        radio.setDecreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void increaseVolumeOnEdge() { //мы не можем увеличить громкость выше 100 (с помощью конструктора)
        Radio radio = new Radio(5, 100);
        radio.setIncreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    void decreaseVolumeOnEdge() { //мы не можем уменьшить громкость ниже 0 (с помощью конструктора)
        Radio radio = new Radio(5, 0);
        radio.setDecreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void сurrentVolumeshouldNotSetStationAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMaxVolume() + 40);
        int expected = radio.getMaxVolume();
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void сurrentVolumeshouldNotSetStationAboveMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMinVolume() - 40);
        int actual = radio.getCurrentVolume();
        int expected = radio.getMinVolume();
        assertEquals(expected, actual);
    }
}
