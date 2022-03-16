package kr.ac.gachon.Project201533745;

public class Order {
    MenuItem menuItem;
    boolean shot, syrup, ice;
    int number, price;

    public Order(MenuItem menuItem, boolean shot, boolean syrup, boolean ice, int number) {
        this.menuItem = menuItem;
        this.shot = shot;
        this.syrup = syrup;
        this.ice = ice;
        this.number = number;

        price = menuItem.getPrice();
        if (shot) price += 500;
        if (syrup) price += 300;
        if (ice) price += 500;

        price*=number;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public boolean isShot() {
        return shot;
    }

    public void setShot(boolean shot) {
        this.shot = shot;
    }

    public boolean isSyrup() {
        return syrup;
    }

    public void setSyrup(boolean syrup) {
        this.syrup = syrup;
    }

    public boolean isIce() {
        return ice;
    }

    public void setIce(boolean ice) {
        this.ice = ice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }
}
