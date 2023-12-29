/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devices;

/**
 *
 * @author Mariam Osama
 */
import javax.swing.JOptionPane;

public class Devices {

    /**
     * @param args the command line arguments
     */
    protected double height;
    protected double width;
    protected double quantity;
    protected double hours;
    protected double power;
    protected double consumption;
    public static int counter;

    public Devices() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public void setHeight(double h) {
        height = h;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double w) {
        width = w;
    }

    public double getWidth() {
        return width;
    }

    public void setQuantity(double q) {
        quantity = q;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setHours(double hr) {
        hours = hr;
    }

    public double getHours() {
        return hours;
    }

    public void setPower(double p) {
        power = p;
    }

    public double getPower() {
        return power;
    }

    public double getConsumption() {
        return consumption;
    }

    public double calculateConsumption(double hr, double p) {
        hours = hr;
        power = p;
        consumption = power * hours;
        return consumption;
    }

    public double totalConsumption(double total) {
        total = consumption * 30;
        return total;
    }

    public static void main(String[] args) {

        double HR1, HR2, HR3, HR4;
        double P1, P2, P3, P4;
        int Q1, Q2, Q3, Q4;
        double Total1 = 0, Total2 = 0, Total3 = 0, Total4 = 0;
        double H1, H2, H3, H4;
        double W1, W2, W3, W4;
        double L1, L2;
        double HS;

        ////Fridge
        Fridge F1 = new Fridge();

        String f1 = JOptionPane.showInputDialog("Enter how many Fridge devices  you have = ");
        Q1 = Integer.parseInt(f1);
        F1.setQuantity(Q1);

        double SumFPerDAY = 0;
        

        for (int i = 1; i <= Q1; i++) {
            String f2 = JOptionPane.showInputDialog("Average of Hours consumed by Fridge number " + i + " per day is   ");
            HR1 = Double.parseDouble(f2);
            F1.setHours(HR1);
            String f3 = JOptionPane.showInputDialog("Power of the Fridge is   ");
            P1 = Double.parseDouble(f3);
            F1.setPower(P1);
            SumFPerDAY += F1.calculateConsumption(HR1, P1);
            
        }
       
       
        
        
        Total1 = SumFPerDAY;

//TV
        TV T1 = new TV();

        String t1;
        t1 = JOptionPane.showInputDialog("Enter how many TV devices  you have = ");
        Q2 = Integer.parseInt(t1);
        T1.setQuantity(Q2);

        double[] array2 = new double[Q2];
        double SumTPerDAY = 0;

        for (int i = 1; i <= Q2; i++) {
            String t2 = JOptionPane.showInputDialog("Average of Hours consumed by  TV  number " + i + " per day is   ");
            HR2 = Double.parseDouble(t2);
            T1.setHours(HR2);

            String t3;
            t3 = JOptionPane.showInputDialog("Power of the  TV  is    ");
            P2 = Double.parseDouble(t3);
            T1.setPower(P2);
            SumTPerDAY += T1.calculateConsumption(HR2, P2);
              array2[i - 1] = T1.calculateConsumption(HR2, P2);
        }
        
        Total2 = SumTPerDAY;

//AC
        AC A1 = new AC();

        String a1 = JOptionPane.showInputDialog("Enter quantity of used AC devices = ");
        Q3 = Integer.parseInt(a1);
        A1.setQuantity(Q3);

        double[] array3 = new double[Q3];
        double SumAPerDAY = 0;

        for (int i = 1; i <= Q3; i++) {
            String a2 = JOptionPane.showInputDialog("Average of Hours consumed by  AC  number " + i + " per day is  ");
            HR3 = Double.parseDouble(a2);
            A1.setHours(HR3);

            String a3 = JOptionPane.showInputDialog("Horses of  the AC is   ");
            HS = Double.parseDouble(a3);
            A1.power(HS);
            SumAPerDAY += A1.calculateConsumption(HR3);
              array3[i - 1] = A1.calculateConsumption(HR3);
        }
        

        Total3 = SumAPerDAY;

//Microwaves
        Microwaves M1 = new Microwaves();

        String m1 = JOptionPane.showInputDialog("Enter how many used Microwave devices = ");
        Q4 = Integer.parseInt(m1);
        M1.setQuantity(Q4);

        double[] array4 = new double[Q4];
        double SumMPerDAY = 0;

        for (int i = 1; i <= Q4; i++) {
            String m2 = JOptionPane.showInputDialog("Average of Hours consumed by Microwave number " + i + " per day is   ");
            HR4 = Double.parseDouble(m2);
            M1.setHours(HR4);
            String m3 = JOptionPane.showInputDialog("Power of the  Microwave  is  ");
            P4 = Double.parseDouble(m3);
            M1.setPower(P4);
            SumMPerDAY += M1.calculateConsumption(HR4, P4);
              array4[i - 1] = M1.calculateConsumption(HR4, P4);
        }
        

        Total4 = SumMPerDAY;

        double GTOTAL;
        GTOTAL = ((F1.totalConsumption(Total1) + T1.totalConsumption(Total2) + A1.totalConsumption(Total3) + M1.totalConsumption(Total4)) / 1000);
        double BILL = (GTOTAL * 0.58);
       
        double[] array = new double[4];
            array[0] =(F1.totalConsumption(Total1)*12);
            array[1] =(T1.totalConsumption(Total2)*12) ;
            array[2] =(A1.totalConsumption(Total3)*12);
            array[3] =(M1.totalConsumption(Total4)*12);
            double summation=0;
            for(int j=0;j<array.length;j++){
                summation+=array[j];
            }
            double TotalBillPerYear=((summation/12)* 0.58);


        
//            JOptionPane.showMessageDialog(null, "Number of total objects=   "+Devices.counter);
        JOptionPane.showMessageDialog(null, "Total Consumption of your Fridges per day is =   " + SumFPerDAY + "  WATT"
                + "\nTotal Consumption of your TV devices per day is =   " + SumTPerDAY + "  WATT"
                + "\nTotal Consumption of your AC devices per day is =   " + SumAPerDAY + "  WATT"
                + "\nTotal Consumption of your  Microwaves per day is =   " + SumMPerDAY + "  WATT"
                + "\nTotal consumption of Fridges per month is  " + F1.totalConsumption(Total1) + "  WATT"
                + "\nTotal consumption of  TV = " + T1.totalConsumption(Total2) + "  WATT"
                + "\nTotal consumption of AC = " + A1.totalConsumption(Total3) + "  WATT"
                + "\nTotal consumption of Microwave = " + M1.totalConsumption(Total4) + "  WATT"
                + "\nGTOTAL=" + GTOTAL + "  KILOWATT" + "\n BILL=" + BILL + "  Pounds"
                +"\nAverage of your Bill per year "+TotalBillPerYear+ "  Pounds");
        
    }
}
