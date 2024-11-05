/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hehe;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class JOptionPaneStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    
         ArrayList<String> transactionHistory = new ArrayList<>(); 

        while (true) {
            double total = 0.0;
            String receipt = ""; // Use String for receipt

            JOptionPane.showMessageDialog(null,
                    "Hello, welcome to Daryl Coffee Shop!\n"
                            + "We have a 10% Discount Available if your total is $500 or more!\n"
                            + "Here is our Menu:\n"
                            + "  :::::> Caramel Macchiato - $25.00\n"
                            + "  :::::> Cappuccino - $25.00\n"
                            + "  :::::> Espresso - $30.00\n"
                            + "  :::::> Greek Frappe - $35.00\n"
                            + "  :::::> Cafe de Olla - $35.00\n");

            int op = JOptionPane.showConfirmDialog(null, "Do you want to Buy?", "", JOptionPane.YES_NO_OPTION);
            if (op == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Okay! Have a nice day!");
                break; // Exit the loop if the user does not want to buy
            }

            boolean continueShopping = true;
            while (continueShopping) {
                Object[] choice = {"Caramel Macchiato", "Cappuccino", "Espresso", "Greek Frappe", "Cafe de Olla "};
                int ops = JOptionPane.showOptionDialog(null,
                        "Select Fruit:\n" +
                                " Caramel Macchiato- $25.00\n" +
                                " Cappuccino - $25.00\n" +
                                " Espresso - $30.00\n" +
                                " Greek Frappe - $35.00\n" +
                                " Cafe de Olla  - $35.00\n",
                        "Select Coffee!", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, choice, null);

                if (ops >= 0) {
                    String quantityS = JOptionPane.showInputDialog("Enter the quantity:");
                    if (quantityS == null) break; // Exit if user cancels

                    double quantity;
                    try {
                        quantity = Double.parseDouble(quantityS);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid quantity. Please enter a number.");
                        continue; // Restart the loop
                    }

                    switch (ops) {
                        case 0:
                            total += 25.0 * quantity;
                            receipt += "Caramel Macchiato x " + quantity + " = $" + String.format("%.2f", 25.0 * quantity) + "\n";
                            break;
                        case 1:
                            total += 25.0 * quantity;
                            receipt += "Cappuccino x " + quantity + " = $" + String.format("%.2f", 25.0 * quantity) + "\n";
                            break;
                        case 2:
                            total += 30.0 * quantity;
                            receipt += "Espresso x " + quantity + " = $" + String.format("%.2f", 30.0 * quantity) + "\n";
                            break;
                        case 3:
                            total += 35.0 * quantity;
                            receipt += "Greek Frappe x " + quantity + " = $" + String.format("%.2f", 35.0 * quantity) + "\n";
                            break;
                        case 4:
                            total += 35.0 * quantity;
                            receipt += "Cafe de Olla x " + quantity + " = $" + String.format("%.2f", 35.0 * quantity) + "\n";
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "You didn't select any Coffee!");
                    }

                    JOptionPane.showMessageDialog(null, "Current total cost: $" + String.format("%.2f", total));
                    JOptionPane.showMessageDialog(null, receipt); // Show receipt after each item

                    int d = JOptionPane.showConfirmDialog(null, "Do you want to buy more Coffee?", "", JOptionPane.YES_NO_OPTION);
                    if (d == JOptionPane.NO_OPTION) {
                        continueShopping = false;
                    }
                }
            }

            if (total >= 500) {
                double discount = total * 0.10;
                total -= discount;
                JOptionPane.showMessageDialog(null, "Discount applied: $" + String.format("%.2f", discount));
            }

            JOptionPane.showMessageDialog(null, "Your total bill after discount is: $" + String.format("%.2f", total), "Daryl Coffee Shop", JOptionPane.INFORMATION_MESSAGE);

            
            double cash = 0.0;
            while (cash < total) {
                String cashInput = JOptionPane.showInputDialog(null, "Please enter the amount of cash you will pay:", "Daryl's Coffee Shop", JOptionPane.QUESTION_MESSAGE);
                if (cashInput == null) break; 
                try {
                    cash += Double.parseDouble(cashInput);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a number.");
                    continue; 
                }

                if (cash < total) {
                    JOptionPane.showMessageDialog(null, "Insufficient cash. You still need to pay: $" + String.format("%.2f", total - cash), "Daryl Store", JOptionPane.ERROR_MESSAGE);
                }
            }

            double change = cash - total;
            receipt += "Your change is: $" + String.format("%.2f", change) + "\n";
            JOptionPane.showMessageDialog(null, receipt, "Receipt", JOptionPane.INFORMATION_MESSAGE);
            transactionHistory.add(receipt); // Add receipt to transaction history
            JOptionPane.showMessageDialog(null, "Thank you for buying!");

            // Ask to restart the transaction
            int restart = JOptionPane.showConfirmDialog(null, "Do you want to make another transaction?", "", JOptionPane.YES_NO_OPTION);
            if (restart == JOptionPane.NO_OPTION) {
                // Show transaction history before exiting
                String history = "Transaction History:\n\n";
                for (String trans : transactionHistory) {
                    history += trans + "\n"; 
                }
                JOptionPane.showMessageDialog(null, history, "Transaction History", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null,"THANK YOU FOR BUYING AT DARYL's COFFEE SHOP!!");
                break; 
            }
        }
    }
}