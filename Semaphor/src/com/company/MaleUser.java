package com.company;

import java.util.concurrent.Semaphore;

/**
 * MaleUser inherits from ToiletUser and implements the wait logic for the thread for male toilet users
 */
public class MaleUser extends ToiletUser {

    public MaleUser(UseType useType, boolean takesFriend, Semaphore s, String userName) {
        super(useType, takesFriend, s, userName);
    }

    @Override
    public void doBusiness() {
        int waitTime = 0;
        switch(this.useType){
            case NONE ->
                    waitTime = 0;
            case NUMBA_ONE ->
                    waitTime = 2;
            case NUMBA_TWO ->
                    waitTime = 10;
            case OTHER ->
                    waitTime = 1;
        }
        if (this.takesFriend){
            waitTime = waitTime*2;
        }
        try {
            Thread.sleep(waitTime * 1000);
        } catch (Exception e){
            e.printStackTrace();
    }
    }
}

