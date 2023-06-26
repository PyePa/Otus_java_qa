package factory;

import animals.Animal;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.birds.Duck;
import data.AnimalTypeData;

import static data.AnimalTypeData.DOG;

public class AnimalFactory {
    public Animal create(String animalType) {

        boolean isAnimalExist = false;
        for(AnimalTypeData animalTypeData: AnimalTypeData.values()) {
            if(animalTypeData.name().equals(animalType)) {
                isAnimalExist = true;
                break;
            }
        }

        if (!isAnimalExist) {
            System.out.println(String.format("Животное %s не поддерживается", animalType));
            return null;
        }

        AnimalTypeData animalTypeData = AnimalTypeData.valueOf(animalType);

        switch (animalTypeData) {
            case CAT: {
                return new Cat();
            }
            case DOG: {
                return new Dog();
            }
            default: {
                return new Duck();
            }
        }
    }
}
