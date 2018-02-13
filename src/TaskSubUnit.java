import java.util.ArrayList;
import java.util.Iterator;

public class TaskSubUnit {

    private ArrayList<TaskRow> taskRows;
    private Iterator<TaskRow> saveIterator;
    private String subUnitHeader;


    public TaskSubUnit(String subUnitHeader) {
        taskRows = new ArrayList<>();
        saveIterator = null;

        this.subUnitHeader = subUnitHeader;
    }

    public String getHeader(){
        return subUnitHeader;
    }

    public String saveLine(){
        if (saveIterator == null){
            saveIterator = taskRows.iterator();
            return "S" + getHeader();
        }
        else if(saveIterator.hasNext()){
            return saveIterator.next().saveLine();
        }
        else{
            saveIterator = null;//reset the itarator
            return Finals.NO_MORE_ITEMS;
        }
    }

    public void loadLine(String line) throws Exception{
        System.out.println(line+" Task Sub Unit");


        //megnezzuk hogy amit kaptunk row-e vagy anomalia (CSAK ROWT KAPHAT A SUBUNIT)
        if(line.substring(0,1).equals(Finals.ROW_INITAL)){
            taskRows.add(new TaskRow(line.substring(1)));
        }
        else{
            throw new InvalidRowException(line);
        }
    }
}
