package framework.problem;

/**
 * @author Ryan Cahoon
 * @Section 1
 */
public class Benchmark {

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setStart(State s){
        this.start = s;
    }

    public State getStart(){
        return this.start;
    }

    public void setGoal(State s){
        this.goal = s;
    }

    public State getGoal(){
        return this.goal;
    }

    public String toString(){
        return name;
    }

    private String name;
    private State start;
    private State goal;
}