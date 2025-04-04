package javacoding;

class Day{
    private String todo;
    public void set(String todo){
        this.todo = todo;
    }
    public String get(){
        return todo;
    }
    public void show(){
        if(todo == null) {
            System.out.println("Nothing to do");
        }
        else{
            System.out.println("todo");
        }
    }
}

public class Num25 {
    public static void main(String[] args) {

    }
}
