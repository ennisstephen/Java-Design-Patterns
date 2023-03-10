package ObserverDesignPattern;

import java.util.*;

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(String status);
}

class SocialMediaStar implements Subject {
    private Set<Observer> observers = new HashSet<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String status) {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }

    public void setStatus(String status) {
        System.out.println("Social Media Star is posting a new status: " + status);
        notifyObservers(status);
    }
}

interface Observer {
    void update(String status);
}

class Follower implements Observer {
    private String name;

    public Follower(String name) {
        this.name = name;
    }

    public void update(String status) {
        System.out.println(name + " received an update: " + status);
    }
}

public class TwitterApp {
    public static void main(String[] args) {
        // Create the social media star and some followers
        Subject star = new SocialMediaStar();
        Observer follower1 = new Follower("Alice");
        Observer follower2 = new Follower("Bob");

        // Followers follow the star
        star.attach(follower1);
        star.attach(follower2);

        // Star posts a new status
        ((SocialMediaStar) star).setStatus("Hello followers! I just released a new video!\n");

        // Alice unfollows the star
        star.detach(follower1);

        // Star posts another status
        ((SocialMediaStar) star).setStatus("Thank you to all my followers for your support!\n");
    }
}