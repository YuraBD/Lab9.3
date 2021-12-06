package atm;

public abstract class DefaultBill implements Bill {
    private final int billAmount;
    private Bill nextBill;

    public DefaultBill(int billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public void setNext(Bill bill) {
        nextBill = bill;
    }

    @Override
    public void process(int amount) {
        if (nextBill != null) {
            nextBill.process(amount % billAmount);
        } else if (amount % billAmount != 0) {
            throw new IllegalArgumentException();
        }
        System.out.printf("Please receive %d of %d UAH bills\n", amount / billAmount, billAmount);
    }
}
