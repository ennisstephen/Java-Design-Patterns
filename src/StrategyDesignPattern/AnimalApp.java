package StrategyDesignPattern;

interface EatingBehavior {
    void eat();
}

interface MovementBehavior {
    void move();
}

abstract class Animal {
    EatingBehavior eatingBehavior;
    MovementBehavior movementBehavior;

    public Animal(EatingBehavior eatingBehavior, MovementBehavior movementBehavior) {
        this.eatingBehavior = eatingBehavior;
        this.movementBehavior = movementBehavior;
    }

    public void eat() {
        eatingBehavior.eat();
    }

    public void move() {
        movementBehavior.move();
    }
}

class Lion extends Animal {
    public Lion() {
        super(new CarnivorousEatingBehavior(), new WalkingMovementBehavior());
    }
}

class Cow extends Animal {
    public Cow() {
        super(new HerbivorousEatingBehavior(), new WalkingMovementBehavior());
    }
}

class Shark extends Animal {
    public Shark() {
        super(new CarnivorousEatingBehavior(), new SwimmingMovementBehavior());
    }
}

class CarnivorousEatingBehavior implements EatingBehavior {
    public void eat() {
        System.out.println("Eating meat...");
    }
}

class HerbivorousEatingBehavior implements EatingBehavior {
    public void eat() {
        System.out.println("Eating plants...");
    }
}

class WalkingMovementBehavior implements MovementBehavior {
    public void move() {
        System.out.println("Walking...");
    }
}

class SwimmingMovementBehavior implements MovementBehavior {
    public void move() {
        System.out.println("Swimming...");
    }
}

public class AnimalApp {
    public static void main(String[] args) {
        Animal lion = new Lion();
        Animal cow = new Cow();
        Animal shark = new Shark();

        lion.eat(); // Output: Eating meat
        lion.move(); // Output: Walking

        cow.eat(); // Output: Eating plants
        cow.move(); // Output: Walking

        shark.eat(); // Output: Eating meat
        shark.move(); // Output: Swimming
    }
}