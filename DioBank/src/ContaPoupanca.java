public class ContaPoupanca extends Conta{

    public ContaPoupanca(){
        super(1000);
    }

    @Override
    public String toString() {
        
        return "Conta poupança Ag.: " + this.getAgencia() + "\nNum: " + this.getNumAccount() 
        + "\nSaldo: " + this.getSaldo() + "\nLimite de transferência: " + this.getLimiteTransf();
    }
}
