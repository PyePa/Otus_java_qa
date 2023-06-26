package data;

public enum AnimalTypeData {
    CAT("кот"),
    DOG("пёс"),
    DUCK("утка");

    private String name;
    AnimalTypeData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
