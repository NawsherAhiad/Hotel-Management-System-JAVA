package hotelmanagementsystem3;


public class CompanyAccount {
    private double totalBalance;

    public CompanyAccount() {
        this.totalBalance = 0.0;
    }

    public void addPayment(double amount) {
        totalBalance += amount;
    }


    public double getTotalBalance() {
        return totalBalance;
    }

    public void displayBalance() {
        System.out.println("Total Company Balance: BDT " + totalBalance);
    }
}
