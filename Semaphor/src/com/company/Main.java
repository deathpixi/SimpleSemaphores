package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore s = new Semaphore(4);
        ExecutorService ex = Executors.newFixedThreadPool(6);
        ex.execute(new FemaleUser(UseType.NUMBA_ONE, false, s, "Alissa"));
        ex.execute(new MaleUser(UseType.NUMBA_TWO, false, s, "Steve"));
        ex.execute(new FemaleUser(UseType.NUMBA_ONE, false, s, "Christie"));
        ex.execute(new MaleUser(UseType.NUMBA_ONE, false, s, "Mark"));
        ex.execute(new FemaleUser(UseType.NUMBA_TWO, true, s, "Stacy"));
        ex.execute(new MaleUser(UseType.NUMBA_ONE, false, s, "John"));
        ex.execute(new MaleUser(UseType.NUMBA_ONE, true, s, "Berny"));
        ex.execute(new MaleUser(UseType.NUMBA_TWO, false, s, "Bright"));
        ex.execute(new FemaleUser(UseType.NUMBA_ONE, true, s, "Tanya"));
        ex.execute(new FemaleUser(UseType.NUMBA_ONE, false, s, "Marlene"));
        ex.execute(new MaleUser(UseType.NUMBA_TWO, true, s, "Paul"));
        ex.execute(new FemaleUser(UseType.NUMBA_TWO, false, s, "Cherise"));
        ex.execute(new MaleUser(UseType.OTHER, false, s, "Marcell"));
        ex.execute(new FemaleUser(UseType.NUMBA_ONE, false, s, "Suzette"));
        ex.execute(new MaleUser(UseType.NONE, false, s, "Gideon"));
        ex.execute(new MaleUser(UseType.NUMBA_ONE, false, s, "James"));
        ex.execute(new FemaleUser(UseType.NUMBA_TWO, false, s, "Griet"));
        ex.execute(new MaleUser(UseType.NUMBA_ONE, false, s, "Boet"));
        ex.shutdown();
    }

}




