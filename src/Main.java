import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        Controller controller = new Controller("tesztike");
        try {
            controller.saveTaskToFile();
            controller.saveScheduleToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList<String> t = new ArrayList<>();
        t.add("elso");
        t.add("masodik");
        t.add("harmadik");

        Iterator<String> it = t.iterator();
        System.out.println(it.next());
        System.out.println(it.next());

        it = t.iterator();
        System.out.println(it.next());

        System.out.println(t.get(0));
        System.out.println(t.size());
    }
}
