package com.company;

import java.util.concurrent.Semaphore;

/**
 * FemaleUser inherits from ToiletUser and implements the wait logic for the thread for female toilet users
 */
public class FemaleUser extends ToiletUser {

    public FemaleUser(UseType useType, boolean takesFriend, Semaphore s, String userName) {
        super(useType, takesFriend, s, userName);
    }

    @Override
    public void doBusiness() {
        int waitTime = 0;
        switch (this.useType) {
            case NONE -> waitTime = 0;
            case NUMBA_ONE -> waitTime = 5;
            case NUMBA_TWO -> waitTime = 10;
            case OTHER -> waitTime = 2;
        }
        if (this.takesFriend) {
            waitTime = waitTime * 2;
            try {
                Thread.sleep(waitTime * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
