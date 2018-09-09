/*
 * Kevin Nguyen
 * Home Depot Code Athlon 2018
 */

/*
 * ask yourself: what states and behavior does an object contain?...
 */

import java.io.*;
import java.util.*;
import java.util.Scanner;

class Bundle{
    // traits of a bundle
    private String bundleName;
    private String bundleId;
    private String department;
    private int quantity;
    private double cost;
    private double salesTax = 0.7;
    private double totalAmount;
    private ArrayList<String> MaterialListID = new ArrayList<String>();

    // empty / placeholder constructor
    public myBundle() {
        bundleName = "" ;
        bundleId = "";
        quantity = 0;
        cost = 0;

    }

    // full constructor
    public myBundle(String n, String i, int q, double c) {
        this.bundleName = n;
        this.bundleId = i;
        this.quantity = q;
        this.cost = c;

    }

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void increaseBundleNumber() {
        this.quantity++;
    }

    public void decreaseBundleNumber() {
        this.quantity--;
    }

    public String toString() {
        String s="";
        s+=" name = "+this.bundleName + "\n";
        s+=" , id = "+this.bundleId + "\n";
        s+=" , quantity = "+this.quantity + "\n";
        s+=" , cost = "+this.cost + "\n\n";
        return s;
    }

    //adding Material ID to ArrayList, execution class will utilize this along with Materials getter
    public void addMaterial(String m)
    {
        MaterialListID.add(0, m)
    }

    //removing Material ID to ArrayList, execution class will utilize this along with Materials getter
    //resolve remove so it removes only ONE instance, and not ALL instances >:(
    public void removeMaterial(String m)
    {
        MaterialListID.remove(m);
    }

    public int getNumMaterials()
    {
        int x = MaterialListID.size();
        return x;
    }

    public boolean isBundleEmpty()
    {
        boolean b = MaterialListID.isEmpty();
        return b;
    }

    //this will be the method that does the dirty work for the total cost
    public void calculateTotalAmount()
    {
        double sum = 0;
        for (int i = 0; i < MaterialListID.size(); i++)
        {
            //to do
            sum += MaterialListID(i).get();
        }
        totalAmount = sum + (sum * 0.7);
    }

    //this will be a wrapper method that hides the 'complex' calculations of the previous method
    public double calculateFinalPrice()
    {
        return totalAmount;
    }
}
