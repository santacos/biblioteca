package com.twu.biblioteca;

public class Item {
    protected boolean isCheckedOut;

    public Item() {
        this.isCheckedOut = false;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public boolean checkOut() {
        if(isCheckedOut)
            return false;
        else
            this.isCheckedOut = true;
        return true;
    }
}
