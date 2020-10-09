package main.lab1.task3;

public class Head extends Thing{

    public Jaw jaw;

    public Head(String reference){
        this.reference = reference;
    }

    public Head(String reference, String jawReference){
        this.reference = reference;
        jaw = new Jaw(jawReference);
    }

    public void smile(){
        System.out.println(reference + " широко улыбается");
    }

    public void eyesLie(){
        System.out.println(reference + " не верит своим глазам");
    }

    public void busy(){
        System.out.println(reference + " занят");
    }



}
