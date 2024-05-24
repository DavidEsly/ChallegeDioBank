public abstract class Conta implements IConta{

    private static int SEQUENCE = 10000;
    private static final int AGENCY = 3214;
    private double saldo;
    private int numAccount;
    private int agencia;
    private double limiteTransf;
    

    public Conta(double limiteTransf){
        this.numAccount = SEQUENCE++;
        this.agencia = AGENCY;
        this.limiteTransf = limiteTransf;
        
    }

    protected double getSaldo() {
        return saldo;
    }

    protected int getNumAccount() {
        return numAccount;
    }

    protected int getAgencia() {
        return agencia;
    }

    protected double getLimiteTransf(){
        return limiteTransf;
    }

    @Override
    public String toString() {
        
        return "Ag.: " + this.agencia + "\nNum.: " + this.numAccount;
    }

    public void deposita(double valor){
        this.saldo += valor;

    }
    public void transfere(double valor, Conta conta){
        try {
            if(!checaConta(conta)){
                throw new MinhaExececao("Conta destino inexistente ou inválida!");
            }else {
                if(!checaSaldo(this, valor)){
                    throw new MinhaExececao("Você não possui saldo para realizar essa ação!"); 
                }else {
                    if (!checaTransfLimite(valor)) {
                        throw new MinhaExececao("O valor ultrapassa o limite de transferência diária!");
                    }else {
                        conta.deposita(valor);
                        this.saldo -= valor;
                        this.limiteTransf -= valor;
                    }
                    
                }
            }
        } catch (MinhaExececao e) {
            System.out.println(e.getMessage());
        }
    }
    public void saca(double valor){
        try {
            if(!checaSaldo(this, valor)){
                throw new MinhaExececao("Você não possui saldo para realizar essa ação!"); 
            }else {
                    this.saldo -= valor;
            }
            
        } catch (MinhaExececao e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private boolean checaSaldo(Conta conta, double valor){
        if(conta.getSaldo() >= valor){
            return true;
        }
        return false;

    }

    private boolean checaConta(Conta conta){
        if(conta == null){
            return false;
        }
        return true;

    }

    private boolean checaTransfLimite(double valor){
        if(this.getLimiteTransf() >= valor){
            return true;
        }
        return false;
    }
}