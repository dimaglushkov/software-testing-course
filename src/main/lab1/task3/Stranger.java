package main.lab1.task3;

import java.util.HashMap;
import java.util.Map;

public class Stranger extends Thing {
    public Map<String,Head> heads = new HashMap<String,Head>();

    {
        reference = "человек";
        heads.put("left", new Head("левая голова", "челюсть левой головы"));
        heads.put("right", new Head("правая голова", "челюсть правой головы"));
    }

    public void putLegs(Object obj){
        System.out.println(reference + " кладет ноги на " + obj.toString());
    }

    public void chill(Object obj){
        System.out.println(reference + " располагается на " + obj.toString());
    }

    public void poke(Object obj){
        System.out.println(reference + " ковыряется в " + obj.toString());
    }
}
