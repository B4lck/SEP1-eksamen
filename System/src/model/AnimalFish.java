package model;

/**
 * Lidt ekstra metoder til fisk
 */
public class AnimalFish extends Animal {
    private boolean freshWater;

    /**
     * Konstruktør til dyr til salg
     * @param name Navnet på dyret
     * @param price Pris på dyret
     * @param animalId Id til selve dyret
     */
    public AnimalFish(String name, double price, int animalId) {
        // Har valgt at freshWater ikke indgår i konstruktøren, for at gøre den ens med de andre klasser, skal opdateres i klassediagram
        super(name, price, animalId);
    }

    /**
     * Konstruktør til dyr til salg
     * @param name Navnet på dyret
     * @param ownerId Id til ejer af dyret
     * @param animalId Id til selve dyret
     */
    public AnimalFish(String name, int ownerId, int animalId) {
        super(name, ownerId, animalId);
    }

    @Override
    public String getCategory() {
        return Animal.CATEGORY_FISH;
    }

    /**
     * Er fisken en ferskvands fisk?
     */
    public boolean isFreshWater() {
        return freshWater;
    }

    /**
     * Set om fisken en ferskvands fisk eller ej
     * @param freshWater Ferskvandsfisk?
     */
    public void setIsFreshWater(boolean freshWater) {
        this.freshWater = freshWater;
    }
}
