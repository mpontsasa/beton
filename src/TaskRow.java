public class TaskRow {

    String test;

    TaskRow (){
        test = new String("alma");
    }

    public String saveLine(){
        return "R" + test;
    }

    public void loadLine(){

    }
}
