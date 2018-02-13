import java.util.ArrayList;

//a projekt tablazathoz hasznaljuk
public class TaskModel implements SuperModel {

    private ArrayList<TaskUnit> taskUnits;


    public TaskModel() {
        taskUnits = new ArrayList<>();

        //test
            taskUnits.add(new TaskUnit());
            taskUnits.add(new TaskUnit());
        //test
    }

    private int n = 0;
    @Override
    public void loadLine(String line){
        System.out.println("Task got the line:"+line);
    }

    @Override
    public String saveLine(){
        if(n < 3) {
            n++;
            return "tasktestsaveline";
        }

        else
            return Finals.END_OF_PROJECT;
    }

}
