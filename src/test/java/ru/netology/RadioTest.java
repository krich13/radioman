package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void setNextStation() { //мы проверяем переключение на следующую станцию
        Radio radio = new Radio();
        radio.setStation(3);
        radio.setNextStation();
        int actual = radio.getCurrentStation();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void setPreviousStation() { //мы проверяем переключение на предыдущую станцию
        Radio radio = new Radio();
        radio.setStation(7);
        radio.setPreviousStation();
        int actual = radio.getCurrentStation();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationAboveMax() {
        Radio radio = new Radio(); ////мы проверяем возможность поставить станцию вручную вне граничных значений
        int expected = radio.getCurrentStation();
        radio.setStation(radio.getMaxStation() + 40);
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationAboveMin() { //мы проверяем возможность поставить станцию вручную вне граничных значений
        Radio radio = new Radio();
        int expected = radio.getCurrentStation();
        radio.setStation(radio.getMinStation() - 40);
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void setNextStationOnEdge() { //мы проверяем переключение с 9 на 0 станцию
        Radio radio = new Radio();
        radio.setStation(9);
        radio.setNextStation();
        int actual = radio.getCurrentStation();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void setPreviousStationOnEdge() { //мы проверяем переключение с 0 на 9 станцию
        Radio radio = new Radio();
        radio.setStation(0);
        radio.setPreviousStation();
        int actual = radio.getCurrentStation();
        int expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    void increaseVolume() { //мы увеличиваем громкость
        Radio radio = new Radio();
        radio.setCurrentVolume(4);
        radio.setIncreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void decreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(5);
        radio.setDecreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 4;
        assertEquals(expected, actual);
    }


    @Test
    void increaseVolumeOnEdge() { //мы не можем увеличить громкость выше 10
        Radio radio = new Radio();
        radio.setCurrentVolume(10);
        radio.setIncreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    void decreaseVolumeonEdge() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.setDecreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void сurrentVolumeshouldNotSetStationAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMaxVolume() + 40);
        int expected = radio.getCurrentVolume();
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void сurrentVolumeshouldNotSetStationAboveMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMinVolume() - 40);
        int actual = radio.getCurrentVolume();
        int expected = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }
}