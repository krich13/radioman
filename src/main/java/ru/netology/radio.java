package ru.netology;

public class radio {
    private int currentStation;
    private int maxStation = 9;
    private int minStation = 0;

    public int getCurrentStation() {
        return currentStation;
    }

    public int getMinStation() {
        return minStation;
    }

    public int getMaxStation() {
        return maxStation;
    }

    public void setNextStation(int currentStation) { //может возвращаться к предыдущей станции
        int newNextStation = 0;
        if (currentStation == maxStation) {
            newNextStation = minStation;
        }
        if (currentStation < maxStation) {
            newNextStation = currentStation + 1;
        }
        this.currentStation = newNextStation;
    }


    public void setPreviousStation(int currentStation) { //может возвращаться к предыдущей станции
        {
            int newPreviousStation = 0;
            if (currentStation == minStation) {
                newPreviousStation = maxStation;
            }
            if (currentStation > minStation) {
                newPreviousStation = currentStation - 1;
            }
            this.currentStation = newPreviousStation;

        }
    }

    public void setStation(int newStation) {
        if (newStation > maxStation) {  //может устанавливать любую от 0 до 9, но в этом пределе
            return;
        }
        if (newStation < minStation) { //если меньше 0, то ставим 0
            return;
        }
        this.currentStation = newStation;
    }

    private int currentVolume;
    private int maxVolume = 10;
    private int minVolume = 0;

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setCurrentVolume(int newVolume) {
        if (newVolume > maxVolume) {  //может устанавливать любую громкость от 0 до 10, но в этом пределе
            return;
        }
        if (newVolume < minVolume) { //если меньше 0, то ставим 0
            return;
        }
        this.currentVolume = newVolume;
    }

    public void setIncreaseVolume(int currentVolume) { //можем увеличивать громкость до 10
        int newVolume = 0;
        if (currentVolume == maxVolume) {
            newVolume = maxVolume;
        }
        if (currentVolume < maxVolume) {
            newVolume = currentVolume + 1;
        }
        this.currentVolume = newVolume;
    }

    public void setDecreaseVolume(int currentVolume) { //можем уменьшать громкость до 0
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

