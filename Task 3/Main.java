package main;
import model.Hotel;
import view.HotelView;
import controller.HotelController;

/**
 * The Main class serves as the entry point to start the hotel management system.
 * It demonstrates the implementation of the MVC (Model-View-Controller) architecture.
 * 
 * The class initializes the Model (Hotel), View (HotelView), and Controller (HotelController),
 * and then invokes the controller's `start()` method to begin the interaction with the user.
 */


public class Main {
    public static void main(String[] args) {
       
        Hotel hotel = new Hotel("Hotel Asia");       
        HotelView view = new HotelView();     
        HotelController controller = new HotelController(hotel, view);      
        controller.start();
    }
}
