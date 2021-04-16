package ServiceOne;

public class Ships {
    private int dayOfArrival;
    private int timeOfArrival;
    private String nameOfShip;
    private TypeOfCargo typeOfCargo;
    private int weightOfContainer;
    private int timeOfParking;

    public Ships(int day, int time, String name, TypeOfCargo type, int weight, int park) {
        this.dayOfArrival = day;
        this.timeOfArrival = time;
        this.nameOfShip = name;
        this.typeOfCargo = type;
        this.weightOfContainer = weight;
        this.timeOfParking = park;
    }

    @Override
    public String toString() {
        return  "\n" + "Ships{" +
                "dayOfArrival=" + dayOfArrival +
                ", timeOfArrival=" + timeOfArrival +
                ", nameOfShip='" + nameOfShip + '\'' +
                ", typeOfCargo=" + typeOfCargo +
                ", weightOfContainer=" + weightOfContainer +
                ", timeOfParking=" + timeOfParking +
                '}' ;
    }

    public int summaryTime(){
        return (this.dayOfArrival * 1440 + this.timeOfArrival);
    }
}
