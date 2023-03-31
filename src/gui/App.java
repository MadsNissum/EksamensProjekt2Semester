package gui;

import application.utility.Utility;
import javafx.application.Application;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        System.out.println(Utility.randomUUID(16));

        //Application.launch(Start.class);
    }


}