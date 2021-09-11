package ru.netology;

public class Radio {
    private int currentStation;
    private int maxStation = 9;
    private int minStation = 0;
    private int currentVolume;
    private int maxVolume = 100;
    private int minVolume = 0;
    private int stationAmount = 10;

    //конструктор с одним параметром (задаем сами, сколько станций хотим)
    public Radio(int variableStationAmount) {
        stationAmount = variableStationAmount;
        maxStation = stationAmount - 1;
    }

    public Radio(int currentStation, int currentVolume, int variableStationAmount) {
        this.currentStation = currentStation;
        this.currentVolume = currentVolume;
        this.stationAmount = variableStationAmount;
        maxStation = stationAmount - 1;
    }

    public Radio(int currentStation, int currentVolume) {
        this.currentStation = currentStation;
        this.currentVolume = currentVolume;
    }

    //дефолтный конструктор для тестов, где нам не нужно задавать параметры (например, когда кол-во станций по умолчанию)
    public Radio() {
    }

    public int getStationAmount() {
        return stationAmount;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getMaxStation() {
        return maxStation;
    }

    public int getMinStation() {
        return minStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public void setNextStation() {

        int newNextStation = 0;
        if (currentStation == maxStation) {
            newNextStation = minStation;
        }
        if (currentStation < maxStation) {
            newNextStation = currentStation + 1;
        }
        this.currentStation = newNextStation;
    }

    public void setPreviousStation() {
        int newPreviousStation = 0;
        if (currentStation == minStation) {
            newPreviousStation = maxStation;
        }
        if (currentStation > minStation) {
            newPreviousStation = currentStation - 1;
        }
        this.currentStation = newPreviousStation;
    }

    public void setStation(int newStation) {
        if (newStation > maxStation || newStation < minStation) {
            return;
        }
        this.currentStation = newStation;
    }

    public void setCurrentVolume(int newVolume) {
        if (newVolume > maxVolume) {
            newVolume = maxVolume;
        }
        if (newVolume < minVolume) {
            newVolume = minVolume;
        }
        this.currentVolume = newVolume;
    }

    public void setIncreaseVolume() {
        int newVolume = 0;
        if (currentVolume == maxVolume) {
            newVolume = maxVolume;
        }
        if (currentVolume < maxVolume) {
            newVolume = currentVolume + 1;
        }
        this.currentVolume = newVolume;
    }

    public void setDecreaseVolume() {
        int newVolume = 0;
        if (currentVolume == minVolume) {
            newVolume = minVolume;
        }
        if (currentVolume > minVolume) {
            newVolume = currentVolume - 1;
        }
        this.currentVolume = newVolume;
    }
}

