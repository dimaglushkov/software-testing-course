package main.task3;

public class Arthur extends Thing {
    boolean nervous = false;
    public Head head = new Head("голова Артура", "челюсть Артура");

    {reference="Артур";}

    public void follow(){
        System.out.println(reference + " вошел следом");
    }

    public void changeNervosity(){
        nervous = !nervous;
        System.out.println(reference + " стал " + ((nervous) ? "нервным" :"спокойным"));
    }

    public void shocked() {
        System.out.println(reference + " ошеломлен");
    }

    public void see(Object obj){
        System.out.println(reference + " увидел " + obj.toString());
    }

    public void totallyShocked(){
        head.eyesLie();

    }

    public boolean isNervous() {
        return nervous;
    }

    public void setNervous(boolean nervous) {
        this.nervous = nervous;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }
}
