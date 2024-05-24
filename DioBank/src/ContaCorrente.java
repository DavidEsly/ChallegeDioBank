public class ContaCorrente extends Conta{

    public ContaCorrente(){
        super(5000);        
    }

    @Override
    public String toString() {
        return "Conta corrente ag.: "+ this.getAgencia() + "\nNum.: " + this.getNumAccount() 
        + "\nSaldo: " + this.getSaldo() + "\nLimite de transferência: " + this.getLimiteTransf();
    }
    
}
