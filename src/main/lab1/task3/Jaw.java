package main.lab1.task3;

public class Jaw extends Thing {

    public Jaw(){
        reference = "челюсть";
    }

    public Jaw(String reference){
        this.reference = reference;

    }

    public void sag(){
        System.out.println(reference + " отвисла");
    }

}
