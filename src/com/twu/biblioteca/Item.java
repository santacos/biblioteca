package com.twu.biblioteca;

public class Item {
    protected boolean isCheckedOut;
    private User borrower;

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

    public boolean returnItem() {
        this.borrower = null;
        boolean isReturnSuccessfully = false;
        if(isCheckedOut){
            this.isCheckedOut = false;
            isReturnSuccessfully = true;
        }
        return isReturnSuccessfully;
    }

    public void checkOut(User borrower) {
        this.borrower = borrower;
        checkOut();
    }

    public User getBorrower() {
        return borrower;
    }
}
