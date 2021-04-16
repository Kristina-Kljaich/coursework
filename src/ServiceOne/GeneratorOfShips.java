package ServiceOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ServiceOne.TypeOfCargo.*;

public class GeneratorOfShips {
    List<Ships> listOfShips = new ArrayList<>();

    public List<Ships> getListOfShips() {
        return listOfShips;
    }

    final String namesOfShips[] = {"Aurora", "Alaska", "Arizona", "Bonaventure", "Defiant", "Dolphin", "Jane Air", "Mont",
            "Good Hope", "Marianne", "Jellyfish", "Nautilus", "Penguin", "Pilgrim", "Ghost", "Jumper", "Holy Virgin", "Batillus",
            "Pharaoh", "Forward", "Cicada", "Emma", "East", "Peaceful", "Poltava", "Thunder", "Restless", "Suvorov", "Prelude FLNG"};


    public GeneratorOfShips(int count) {
        for (int i = 0; i < count; i++) {
            listOfShips.add(Generation());
        }
    }

    public Ships Generation() {
        Random random = new Random();
        int day = random.nextInt(30);
        int time = random.nextInt(1440);
        String name = namesOfShips[random.nextInt(namesOfShips.length)];

        int numberOfType = random.nextInt(3);
        TypeOfCargo type;
        switch (numberOfType) {
            case 0 -> type = LOOSE;
            case 1 -> type = LIQUID;
            case 2 -> type = CONTAINER;
            default -> throw new IllegalStateException("Unexpected value: " + numberOfType);
        }

        int weight = random.nextInt(600000);
        int parkingTime;

        switch (type) {
            case LOOSE -> parkingTime = weight / 100;
            case LIQUID -> parkingTime = weight / 500;
            case CONTAINER -> parkingTime = weight / 2000;
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }

        return new Ships(day, time, name, type, weight, parkingTime);
    }
}
