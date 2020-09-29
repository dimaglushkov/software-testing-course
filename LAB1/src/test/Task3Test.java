package test;

import main.task3.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class Task3Test {

    @Test
    void test(){
        Arthur arthur = new Arthur();
        Stranger stranger = new Stranger();
        Armchair armchair = new Armchair();
        ControlPanel controlPanel = new ControlPanel();
        Things things = new Things();

        ByteArrayOutputStream functionOutput = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(functionOutput);
        PrintStream defaultStream = System.out;
        System.setOut(ps);

        arthur.changeNervosity();
        arthur.follow();
        arthur.shocked();
        arthur.see(stranger);
        stranger.chill(armchair);
        stranger.putLegs(controlPanel);
        stranger.poke(stranger.heads.get("right").jaw);
        stranger.heads.get("right").busy();
        stranger.heads.get("left").smile();
        arthur.see(things);
        things.increase();
        arthur.head.jaw.sag();
        arthur.totallyShocked();

        System.out.flush();
        System.setOut(defaultStream);
        String[] lines = functionOutput.toString().split("\n");
        String[] mustContain = {
                "нерв",
                "вошел",
                "ошеломлен",
                "увидел человек",
                "располагается на кресл",
                "кладет ноги",
                "ковыряется в челюсть",
                "правая голова занят",
                "левая голова широко улыбается",
                "Артур увидел",
                "количество вещи растет",
                "челюсть Артура отвисла",
                "не верит своим глазам"
        };

        assertEquals(mustContain.length, lines.length);
        for (int i = 0; i < lines.length; i++)
            assertTrue(lines[i].contains(mustContain[i].replace("\n", "")));

    }

    @Test
    void testThingsIncrease(){
        Things things = new Things();
        int init_num_of_things = things.getNumber();
        things.increase();
        assertEquals(init_num_of_things + 1, things.getNumber());
    }

    @Test
    void testNervosity(){
        Arthur arthur = new Arthur();
        boolean init_nervosity = arthur.isNervous();
        arthur.changeNervosity();
        assertEquals(!init_nervosity, arthur.isNervous());
        arthur.changeNervosity();
        assertEquals(init_nervosity, arthur.isNervous());
    }

    @Test
    void testArthurSee(){
        Arthur arthur = new Arthur();
        Things things = new Things();
        ControlPanel controlPanel = new ControlPanel();

        ByteArrayOutputStream functionOutput = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(functionOutput);
        PrintStream defaultStream = System.out;
        System.setOut(ps);

        arthur.see(things);
        arthur.see(controlPanel);

        System.out.flush();
        System.setOut(defaultStream);
        assertEquals("Артур увидел вещи\nАртур увидел Пульт управления\n", functionOutput.toString());
    }

    @Test
    void testStrangerChill(){
        Stranger stranger = new Stranger();
        Thing thing = new Thing();

        ByteArrayOutputStream functionOutput = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(functionOutput);
        PrintStream defaultStream = System.out;
        System.setOut(ps);

        stranger.chill(thing);

        System.out.flush();
        System.setOut(defaultStream);
        assertEquals("человек располагается на Вещь\n", functionOutput.toString());
    }

    @Test
    void testSmile(){
        Stranger stranger = new Stranger();

        ByteArrayOutputStream functionOutput = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(functionOutput);
        PrintStream defaultStream = System.out;
        System.setOut(ps);

        stranger.heads.get("left").smile();
        stranger.heads.get("right").smile();

        System.out.flush();
        System.setOut(defaultStream);
        assertEquals("левая голова широко улыбается\n" + "правая голова широко улыбается\n", functionOutput.toString());
    }

    @Test
    void testJawSag(){
        Arthur arthur = new Arthur();

        ByteArrayOutputStream functionOutput = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(functionOutput);
        PrintStream defaultStream = System.out;
        System.setOut(ps);

        arthur.head.jaw.sag();

        System.out.flush();
        System.setOut(defaultStream);
        assertEquals("челюсть Артура отвисла\n", functionOutput.toString());
    }

    @Test
    void testEyesLie(){
        Arthur arthur = new Arthur();

        ByteArrayOutputStream function1Output = new ByteArrayOutputStream();
        ByteArrayOutputStream function2Output = new ByteArrayOutputStream();
        PrintStream ps1 = new PrintStream(function1Output);
        PrintStream ps2 = new PrintStream(function2Output);
        PrintStream defaultStream = System.out;

        System.setOut(ps1);
        arthur.totallyShocked();
        System.out.flush();

        System.setOut(ps2);
        arthur.head.eyesLie();
        System.out.flush();


        System.setOut(defaultStream);
        assertEquals(function1Output.toString(), function2Output.toString());
    }
}


