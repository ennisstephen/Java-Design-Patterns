package DecoratorDesignPattern;

public class GameApp {

    public static void main(String[] args) {
        Hero warrior = new Warrior("Conan");
        warrior.attack(); // outputs: Warrior Conan attacks with a sword for 10 damage.

        Hero wizard = new Wizard("Gandalf");
        wizard.attack(); // outputs: Wizard Gandalf attacks with magic for 20 damage.

        Hero warriorWithSword = new Sword(warrior);
        warriorWithSword.attack(); // outputs: Warrior Conan attacks with a sword for 15 damage.

        Hero wizardWithBow = new BowAndArrow(wizard);
        wizardWithBow.attack(); // outputs: Wizard Gandalf attacks with magic for 20 damage.
        // outputs: The hero attacks with a bow and arrow for 20 damage.
    }
}

// Hero.java - the abstract base class for our hero
abstract class Hero {
    protected String name;
    protected int health;
    protected int damage;

    public abstract void attack();
}

// Warrior.java - a concrete implementation of Hero
class Warrior extends Hero {
    public Warrior(String name) {
        this.name = name;
        this.health = 100;
        this.damage = 10;
    }

    @Override
    public void attack() {
        System.out.println("Warrior " + name + " attacks with a sword for " + damage + " damage.");
    }
}

// Wizard.java - another concrete implementation of Hero
class Wizard extends Hero {
    public Wizard(String name) {
        this.name = name;
        this.health = 80;
        this.damage = 20;
    }

    @Override
    public void attack() {
        System.out.println("Wizard " + name + " attacks with magic for " + damage + " damage.");
    }
}

// WeaponDecorator.java - an abstract decorator class for adding weapons to our heroes
abstract class WeaponDecorator extends Hero {
    protected Hero hero;

    public WeaponDecorator(Hero hero) {
        this.hero = hero;
    }

    @Override
    public abstract void attack();
}

// Sword.java - a concrete decorator class for adding a sword to our hero
class Sword extends WeaponDecorator {
    public Sword(Hero hero) {
        super(hero);
        this.damage = 15;
    }

    @Override
    public void attack() {
        hero.attack();
        System.out.println("The hero attacks with a sword for " + damage + " damage.");
    }
}

// BowAndArrow.java - another concrete decorator class for adding a bow and arrow to our hero
class BowAndArrow extends WeaponDecorator {
    public BowAndArrow(Hero hero) {
        super(hero);
        this.damage = 20;
    }

    @Override
    public void attack() {
        hero.attack();
        System.out.println("The hero attacks with a bow and arrow for " + damage + " damage.");
    }
}
