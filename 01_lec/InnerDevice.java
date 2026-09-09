//ABstract class
abstract class Device{

    //variable
    String brand = "samsung";

    //abstract method
    abstract void turnOn();

    //concrete method
    void showBrand(){
        System.out.println("Brand:"+ brand);
    }
        
}

// interface 1
interface Camera {
    int MAX_ZOOM = 10; //public staitc final
    void takePhoto();    //abstract and public method

    default void cameraInfo(){  //concrete method
        System.out.println("camera is ready");
    }
} 

// interFace 2
interface MusicPlayer {
    String TYPE = "Digital";    //public static final
    void playMusic();

    default void musicInfo(){
        System.out.println("Music player is ready");
    }
}


//class child
class Smartphone extends Device implements Camera, MusicPlayer{
    //implementing abstract method of device
    void turnOn(){
        System.out.println("smartphone is turned ON");
    }

    // implementing abstract metohd of camera
    public void takePhoto(){
        System.out.println("Taking photo........");
    }

    //implementing the abstract method of MusicPlayer
    public void playMusic(){
        System.out.println("Playing music.......");
    }
}

//main classs
public class InnerDevice {
    public static void main(String[] args) {
        Smartphone s = new Smartphone();
        s.turnOn();
        s.showBrand();
        s.takePhoto();
        s.playMusic();
        s.cameraInfo();
        s.musicInfo();
        System.out.println("Maximum zoom: " + Camera.MAX_ZOOM);

    }
}

//final keyword -- it is used to retrict modification
//it can be a 
// it can be applied to variable, methods, and class
//final variable cannot be modified inside a child class or any other class
//final methods cannot be overwritten 
//final class cannot be inhertited in anyother class
