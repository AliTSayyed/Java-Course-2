package FlightControl;

import FlightControl.domain.Flight;
import FlightControl.domain.Airplane;
import FlightControl.domain.Place;
import java.util.Scanner;
import FlightControl.logic.FlightControl;
import FlightControl.ui.TextUI;

public class Main {

    public static void main(String[] args) {
        
        FlightControl flightControl = new FlightControl();
        Scanner scanner = new Scanner(System.in);
        TextUI ui = new TextUI(flightControl, scanner);
        ui.start();     
        
    }
}
