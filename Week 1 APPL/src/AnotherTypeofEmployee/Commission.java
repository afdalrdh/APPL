/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnotherTypeofEmployee;

/**
 *
 * @author afdalrdh
 */
public class Commission extends Hourly{
    double totalSales;
    double commRate;
    
    public Commission(String eName, String eAddress, String ePhone,String socSecNumber, double rate, double ncommRate){
        super(eName,eAddress,ePhone,socSecNumber,rate);
        commRate = ncommRate;
    }
    
    public void addSales(double totalSales2){
        totalSales = totalSales2;
    }
    
    @Override
    public double pay(){
        double payment = super.pay() + (totalSales*commRate);
        totalSales = 0;
        return payment;
    }
    
    @Override
    public String toString(){
        String result = super.toString();
        result += "\nTotal Sales: " + totalSales;
        return result;
    }
}
