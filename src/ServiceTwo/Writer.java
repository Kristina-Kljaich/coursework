package ServiceTwo;

import ServiceOne.*;

import java.util.Comparator;
import java.util.Scanner;

public class Writer {
    public Writer(int count) {
        GeneratorOfShips generatedList = new GeneratorOfShips(count);

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("If you want to add new ships, please enter yes");
            String answer = input.nextLine();
            if (answer.equals("yes")) {
                generatedList.getListOfShips().add(checkingInput());
            } else {
                break;
            }
        }
        generatedList.getListOfShips().sort(Comparator.comparing(Ships::summaryTime));
        System.out.println(generatedList.getListOfShips());
    }

    private Ships checkingInput(){
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter day of arrival: ");
        int day = input.nextInt();
        while ((day > 30) || (day < 0)) {
            System.out.println("Please enter day of arrival again: ");
            day = input.nextInt();
        }

        System.out.println("Please enter time of arrival in minutes: ");
        int time = input.nextInt();
        while ((time > 1440) || (time < 0)) {
            System.out.println("Please enter time of arrival in minutes again: ");
            time = input.nextInt();
        }

        System.out.println("Please enter name of ship: ");
        String name = input.nextLine();
        while (name.length() == 0) {
            System.out.println("Please enter name of ship again: ");
            name = input.nextLine();
        }

        System.out.println("Please enter type of cargo (LOOSE, LIQUID or CONTAINER): ");
        String type = input.nextLine();
        while ((type != "LOOSE") && (type != "LIQUID") && (type != "CONTAINER")) {
            System.out.println("Please enter type of cargo (LOOSE, LIQUID or CONTAINER) again: ");
            type = input.nextLine();
        }

        TypeOfCargo typeCargo;

        switch (type){
            case "LOOSE" -> typeCargo = TypeOfCargo.LOOSE;
            case "LIQUID" -> typeCargo = TypeOfCargo.LIQUID;
            case "CONTAINER" -> typeCargo = TypeOfCargo.CONTAINER;
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }

        System.out.println("Please enter weight or count of container: ");
        int weight = input.nextInt();
        while (weight > 600000) {
            System.out.println("Please enter weight or count of container again: ");
            weight = input.nextInt();
        }

        int park = 0;

        switch (typeCargo) {
            case LOOSE -> park = weight / 100;
            case LIQUID -> park = weight / 500;
            case CONTAINER -> park = weight / 2000;
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }

        return new Ships(day, time, name, typeCargo, weight, park);
    }
}
