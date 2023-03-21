package FactoryDesignPattern.SimpleFactoryPattern;
abstract class Coffee {
    public void grindBeans() {
        System.out.println("Grinding coffee beans");
    }

    public void addMilk() {
        System.out.println("Adding milk");
    }

    public abstract void brew();
}

class Latte extends Coffee {
    @Override
    public void brew() {
        System.out.println("Brewing a latte");
    }
}

class Espresso extends Coffee {
    @Override
    public void brew() {
        System.out.println("Brewing an espresso");
    }
}

class Cappuccino extends Coffee {
    @Override
    public void brew() {
        System.out.println("Brewing a cappuccino");
    }
}

class SimpleCoffeeFactory {
    public static Coffee createCoffee(String coffeeType) {
        switch (coffeeType) {
            case "Latte":
                return new Latte();
            case "Espresso":
                return new Espresso();
            case "Cappuccino":
                return new Cappuccino();
            default:
                throw new IllegalArgumentException("Invalid coffee type: " + coffeeType);
        }
    }
}
public class CoffeeShop {
    private SimpleCoffeeFactory coffeeFactory;

    public CoffeeShop(SimpleCoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public void orderCoffee(String coffeeType) {
        Coffee coffee = coffeeFactory.createCoffee(coffeeType);
        coffee.grindBeans();
        coffee.brew();
        coffee.addMilk();
    }

    public static void main(String[] args) {
        SimpleCoffeeFactory coffeeFactory = new SimpleCoffeeFactory();
        CoffeeShop coffeeShop = new CoffeeShop(coffeeFactory);

        // Order a Latte
        coffeeShop.orderCoffee("Latte");
        // Console output:
        // Grinding coffee beans
        // Brewing a latte
        // Adding milk

        // Order an Espresso
        coffeeShop.orderCoffee("Espresso");
        // Console output:
        // Grinding coffee beans
        // Brewing an espresso
        // Adding milk

        // Order a Cappuccino
        coffeeShop.orderCoffee("Cappuccino");
        // Console output:
        // Grinding coffee beans
        // Brewing a cappuccino
        // Adding milk
    }
}
