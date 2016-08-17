package com.twu.biblioteca;

/**
 * Created by amornthip on 17/08/2016.
 */
public class RentableItem<T> {
    private boolean isCheckedOut;
    private T item;

    public RentableItem(T item) {
        this.item = item;
        this.isCheckedOut = false;
    }

    public boolean checkOut() {
        if(!isCheckedOut){
            this.isCheckedOut = true;
            return true;
        }
        return false;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public boolean returnItem() {
        boolean isReturnSuccessfully = false;
        if(isCheckedOut){
            this.isCheckedOut = false;
            isReturnSuccessfully = true;
        }
        return isReturnSuccessfully;
    }

    public T getItem() {
        return item;
    }
}
