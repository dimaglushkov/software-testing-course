package main.lab1.task3;

public class Things extends Thing{
    int number = 1;

    {reference="вещи";}

    public void increase(){
        System.out.println("количество " + reference + " растет");
        number++;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
