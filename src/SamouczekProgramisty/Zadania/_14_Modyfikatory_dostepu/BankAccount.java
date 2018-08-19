package SamouczekProgramisty.Zadania._14_Modyfikatory_dostepu;

public class BankAccount implements BankTransfer, Account {
    private int saldo;

    public int getSaldo() {
        return saldo;
    }

    @Override
    public void deposit(int amount) {
        if(amount>0)
            saldo+=amount;
    }

    @Override
    public void withdraw(int amount) {
        if(amount>0)
            saldo-=amount;
    }

    @Override
    public void transfer(BankAccount from, BankAccount to, int amount) {
        from.withdraw(amount+1);
        to.deposit(amount);
    }

    public static void main(String[] args) {
        BankAccount one = new BankAccount();
        one.deposit(200);
        System.out.println(one.getSaldo());

        BankAccount two = new BankAccount();
        two.deposit(100);
        System.out.println(two.getSaldo());

        one.transfer(one, two, 50);
        System.out.println(one.getSaldo());
        System.out.println(two.getSaldo());

    }
}
