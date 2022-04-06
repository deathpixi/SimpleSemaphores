package com.company;

import java.util.concurrent.Semaphore;

/**
 * Class to encapsulate all the toilet users attributes needed
 */

public abstract class ToiletUser implements Runnable{
    protected UseType useType;
    protected int useTime;
    protected boolean takesFriend;
    protected Semaphore toiletManager;
    protected String toiletUserName;

    /**
     * Non default constructor to set all necessary values
     * @param useType The type of toilet use
     * @param takesFriend Boolean to indicate whether the user takes along a friend to the toilet
     * @param s The Semaphore to manage permits
     * @param userName The name of the toilet user
     */
    public ToiletUser(UseType useType, boolean takesFriend, Semaphore s, String userName) {
        this.useType = useType;
        this.useTime = useTime;
        this.takesFriend = takesFriend;
        this.toiletManager = s;
        this.toiletUserName = userName;
    }

    /**
     * Method to manage the wait of the threads
     */
    public abstract void doBusiness();

    @Override
    public void run() {
        try {
            System.out.println(toiletUserName + " gets in the line at toilet " + Thread.currentThread().getId());
            toiletManager.acquire();
            System.out.println(toiletUserName +  " entered toilet " + Thread.currentThread().getId());
            doBusiness();
            System.out.println(toiletUserName +  " exits Toilet " + Thread.currentThread().getId());
            toiletManager.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //<editor-fold desc="Getters and Setters">
    public UseType getUseType() {
        return useType;
    }

    public void setUseType(UseType useType) {
        this.useType = useType;
    }

    public int getUseTime() {
        return useTime;
    }

    public void setUseTime(int useTime) {
        this.useTime = useTime;
    }

    public boolean isTakesFriend() {
        return takesFriend;
    }

    public void setTakesFriend(boolean takesFriend) {
        this.takesFriend = takesFriend;
    }
    //</editor-fold>
}
