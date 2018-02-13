public class TaskRow {

    String test;

    TaskRow (String line){
        test = line;
    }

    public String saveLine(){
        return "R" + test;
    }

}
