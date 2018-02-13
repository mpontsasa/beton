import java.util.ArrayList;


public class TaskUnit {
    private ArrayList<TaskSubUnit> subUnits;


    private int currentSubUnit;//jeloli hogy melyik subunit belsejeben vagyunk savekor

    public TaskUnit() {
        subUnits = new ArrayList<>();
        currentSubUnit = -1;

        //test
            subUnits.add(new TaskSubUnit());
            subUnits.add(new TaskSubUnit());
        //test
    }

    public String getHeader(){
        return "UnitHeader";
    }

    public String saveLine(){
        if (currentSubUnit == -1){  // ha a unit kezdeten vagyunk
            currentSubUnit ++;
            return "U" + getHeader() + "\n";
        }
        else if(currentSubUnit == subUnits.size()){
            currentSubUnit = -1;    // visszaallitjuk mintha meg nem vettunk volna ki elemet
            return Finals.NO_MORE_ITEMS;//mert tulhaladtuk az osszes subunitot
        }
        else{
            String currentLine = subUnits.get(currentSubUnit).saveLine();
            if(currentLine.equals(Finals.NO_MORE_ITEMS)){
                //kifogytunk ebbol a sub unitbol, ezert leptetem a subunitokat es meghivom megegyszer
                currentSubUnit++;
                return this.saveLine();
            }
            else{
                return currentLine;
            }
        }
    }
}
