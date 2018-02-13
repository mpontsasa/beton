import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        Controller controller = new Controller("tesztike");
        try {
            controller.loadTaskFromFile();
            controller.setProjectName("tesztike_mentes");
            controller.saveTaskToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}
