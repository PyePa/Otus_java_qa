import animals.Animal;
import data.CommandsData;
import factory.AnimalFactory;
import tools.AgeTools;
import tools.WeightTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        while (true) {
            System.out.println("Введите в консоль одну из команд add;list;exit");

            String commandStr = scanner.next().trim().toUpperCase(Locale.ROOT);

            boolean isExist = false;
            for (CommandsData commandsData: CommandsData.values()) {
                if (commandsData.name().equals(commandStr)) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                System.out.println(String.format("Команда %s не поддерживается", commandStr));
                continue;
            }

            CommandsData commandsData = CommandsData.valueOf(commandStr);


            switch (commandsData) {
                case ADD: {
                    System.out.println("Введите одно из животных: cat, dog, duck");

                    AnimalFactory animalFactory = new AnimalFactory();

                    String animalStr = scanner.next().trim().toUpperCase(Locale.ROOT);
                    Animal animal = animalFactory.create(animalStr);

                    while (animal == null) {
                        System.out.println("Введен неверный тип животного");
                        animalStr = scanner.next().trim().toUpperCase(Locale.ROOT);
                        animal = animalFactory.create(animalStr);
                    }

                    animals.add(fillAnimalData(animal));
                    break;

                }
                case LIST: {
                    for(Animal animal: animals) {
                        System.out.println(animal.toString());
                    }
                    break;
                }
                case EXIT: {
                    System.exit(0);
                }
            }
        }
    }

    private static Animal fillAnimalData(Animal animal) {
        System.out.println("Введите имя животного");
        animal.setName(scanner.next());

        System.out.println("Введите цвет животного");
        animal.setColor(scanner.next());

        Integer age = 0;
        do {
            System.out.println("Введите возраст животного");
            age = AgeTools.convertStrToInt(scanner.next());

            if (age != null) {
                break;
            }
            System.out.println("Возраст введен неверно");
        } while(true);
        animal.setAge(age);

        Integer weight = 0;
        do {
            System.out.println("Введите вес животного");
            weight = WeightTools.convertWeightToInt(scanner.next());

            if (weight != null) {
                break;
            }
            System.out.println("Вес введен неверно");
        } while(true);
        animal.setWeight(weight);

        return animal;
    }
}