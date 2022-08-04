package web.model;

public class Car {

    private String model;
    private String color;
    private int yearsOld;

    public Car(String model, String color, int yearsOld) {
        this.model = model;
        this.color = color;
        this.yearsOld = yearsOld;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }
}
