import java.util.ArrayList;
import java.util.Iterator;

public class TaskSubUnit {

    private ArrayList<TaskRow> taskRows;
    private Iterator<TaskRow> saveIterator;


    public TaskSubUnit() {
        taskRows = new ArrayList<>();
        saveIterator = null;

        //test
            taskRows.add(new TaskRow());
            taskRows.add(new TaskRow());
            taskRows.add(new TaskRow());
            taskRows.add(new TaskRow());
        //test
    }

    public String getHeader(){
        return "SubUnitHeader";
    }

    public String saveLine(){
        if (saveIterator == null){
            saveIterator = taskRows.iterator();
            return "S" + getHeader() + "\n";
        }
        else if(saveIterator.hasNext()){
            return saveIterator.next().saveLine();
        }
        else{
            saveIterator = null;//reset the itarator
            return Finals.NO_MORE_ITEMS;
        }
    }
}
