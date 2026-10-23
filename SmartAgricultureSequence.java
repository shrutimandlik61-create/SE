import java.util.Scanner;

// Parent Class
class User {
    String name;

    void login() {
        System.out.println(name + " logged in.");
    }
}

// Child Class
class Farmer extends User {
    
    void selectCrop(Crop crop) {
        System.out.println(name + " selected crop: " + crop.cropName);
        crop.getCropInformation();
    }

    void requestAdvisory(Advisory advisory, Crop crop) {
        System.out.println(name + " requested advisory.");
        advisory.provideAdvice(crop);
    }
}

// Crop Object
class Crop {
    String cropName;
    String season;

    Crop(String cropName, String season) {
        this.cropName = cropName;
        this.season = season;
    }

    void getCropInformation() {
        System.out.println("Crop: " + cropName);
        System.out.println("Season: " + season);
    }
}

// Advisory Object
class Advisory {

    void provideAdvice(Crop crop) {
        System.out.println("Advisory for " + crop.cropName +
                           ": Use proper irrigation and fertilizer.");
    }
}

// Main Class
public class SmartAgricultureSequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Farmer farmer = new Farmer();
        Crop crop;
        Advisory advisory = new Advisory();

        System.out.print("Enter farmer name: ");
        farmer.name = sc.nextLine();

        System.out.print("Enter crop name: ");
        String cropName = sc.nextLine();

        System.out.print("Enter season: ");
        String season = sc.nextLine();

        crop = new Crop(cropName, season);

        // Method calls and object interaction
        farmer.login();

        farmer.selectCrop(crop);

        farmer.requestAdvisory(advisory, crop);

        sc.close();
    }
}