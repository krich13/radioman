package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class radioTest {

    @Test
    void setNextStation() { //мы проверяем переключение на следующую станцию
        radio radio = new radio();
        radio.setStation(3);
        radio.setNextStation(radio.getCurrentStation());
        int actual = radio.getCurrentStation();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void setPreviousStation() { //мы проверяем переключение на предыдущую станцию
        radio radio = new radio();
        radio.setStation(7);
        radio.setPreviousStation(radio.getCurrentStation());
        int actual = radio.getCurrentStation();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationAboveMax() {
        radio radio = new radio(); ////мы проверяем возможность поставить станцию вручную вне граничных значений
        int expected = radio.getCurrentStation();
        radio.setStation(radio.getMaxStation() + 40);
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationAboveMin() { //мы проверяем возможность поставить станцию вручную вне граничных значений
        radio radio = new radio();
        int expected = radio.getCurrentStation();
        radio.setStation(radio.getMinStation() - 40);
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void setNextStationOnEdge() { //мы проверяем переключение с 9 на 0 станцию
        radio radio = new radio();
        radio.setStation(9);
        radio.setNextStation(radio.getMaxStation());
        int actual = radio.getCurrentStation();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void setPreviousStationOnEdge() { //мы проверяем переключение с 0 на 9 станцию
        radio radio = new radio();
        radio.setStation(0);
        radio.setPreviousStation(radio.getCurrentStation());
        int actual = radio.getCurrentStation();
        int expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    void increaseVolume() { //мы увеличиваем громкость
        radio radio = new radio();
        radio.setCurrentVolume(4);
        radio.setIncreaseVolume(radio.getCurrentVolume());
        int actual = radio.getCurrentVolume();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void decreaseVolume() {
        radio radio = new radio();
        radio.setCurrentVolume(5);
        radio.setDecreaseVolume(radio.getCurrentVolume());
        int actual = radio.getCurrentVolume();
        int expected = 4;
        assertEquals(expected, actual);
    }


    @Test
    void increaseVolumeOnEdge() { //мы не можем увеличить громколсть выше 10
        radio radio = new radio();
        radio.setCurrentVolume(10);
        radio.setIncreaseVolume(radio.getCurrentVolume());
        int actual = radio.getCurrentVolume();
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    void decreaseVolumeonEdge() {
        radio radio = new radio();
        radio.setCurrentVolume(0);
        radio.setDecreaseVolume(radio.getCurrentVolume());
        int actual = radio.getCurrentVolume();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void сurrentVolumeshouldNotSetStationAboveMax() {
        radio radio = new radio();
        int expected = radio.getCurrentVolume();
        radio.setCurrentVolume(radio.getMaxVolume() + 40);
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void сurrentVolumeshouldNotSetStationAboveMin() {
        radio radio = new radio();
        int expected = radio.getCurrentVolume();
        radio.setCurrentVolume(radio.getMinVolume() - 40);
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }
}