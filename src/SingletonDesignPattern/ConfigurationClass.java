package SingletonDesignPattern;

public class ConfigurationClass {
    private static ConfigurationClass instance = null;
    private String serverAddress;
    private int portNumber;
    private boolean debugMode;

    private ConfigurationClass() {
        // private constructor to prevent instantiation outside of the class
        this.serverAddress = "localhost";
        this.portNumber = 8080;
        this.debugMode = false;
    }

    public static ConfigurationClass getInstance() {
        if (instance == null) {
            instance = new ConfigurationClass();
        }
        return instance;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    public static void main(String[] args) {
        System.out.println(ConfigurationClass.getInstance().getPortNumber());
        System.out.println(ConfigurationClass.getInstance().getServerAddress());
    }
}