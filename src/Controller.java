import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Controller {

    private ScheduleModel scheduleModel;
    private TaskModel taskModel;
    //***ide meg ket view

    private String projectName;

    public Controller(String projectName) {

        scheduleModel = new ScheduleModel();
        taskModel = new TaskModel();


        this.projectName = projectName;

    }

    public void loadTaskFromFile() throws FileNotFoundException{

        Scanner scan = new Scanner(new File(projectName + "_task.txt"));
        while(scan.hasNextLine()){
            String line = scan.nextLine();

            try {
                taskModel.loadLine(line);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        scan.close();
    }

    public void saveTaskToFile() throws IOException{

        FileWriter fw = new FileWriter(projectName + "_task.txt");

        String currentLine = taskModel.saveLine();

        while(!currentLine.equals(Finals.END_OF_PROJECT)) {
            fw.write(currentLine + "\n");
            currentLine = taskModel.saveLine();
        }

        fw.close();

    }

    public void loadScheduleFromFile() throws FileNotFoundException{

        Scanner scan = new Scanner(new File(projectName + "_schedule.txt"));
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            scheduleModel.loadLine(line);
        }
        scan.close();
    }

    public void saveScheduleToFile() throws IOException{

        FileWriter fw = new FileWriter(projectName + "_schedule.txt");

        String currentLine = scheduleModel.saveLine();

        while(!currentLine.equals(Finals.END_OF_PROJECT)) {
            fw.write(currentLine + "\n");
            currentLine = scheduleModel.saveLine();
        }

        fw.close();

    }


    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
