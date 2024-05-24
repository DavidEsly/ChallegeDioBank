public class Main {
    public static void main(String[] args){
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.saca(100);
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.saca(100);

        System.out.println("Teste de saque de contas com valor zero");
        System.out.println(contaCorrente.toString());
        System.out.println(contaPoupanca.toString());
        System.out.println("###########################");

        contaCorrente.deposita(100);
        ContaCorrente testeContaCorrente = null;
        System.out.println("Teste transferencia conta corrente para conta null");
        contaCorrente.transfere(50, testeContaCorrente);
        System.out.println("###########################");

        contaCorrente.deposita(6000);
        System.out.println("Teste transferencia conta corrente acima do limite");
        contaCorrente.transfere(5500, contaPoupanca);
        System.out.println(contaCorrente.toString());
        System.out.println("###########################");

        System.out.println("Teste transferencia conta corrente valida para conta corrente");
        contaCorrente.transfere(5000, contaPoupanca);
        System.out.println(contaCorrente.toString());
        System.out.println(contaPoupanca.toString());
        System.out.println("###########################");

        System.out.println("Teste transferencia poupanca para conta null");
        contaPoupanca.transfere(100, testeContaCorrente);
        System.out.println("Teste transferencia poupanca acima do limite");
        contaPoupanca.transfere(1100, contaCorrente);
        System.out.println("Teste transferencia poupanca valida para conta corrente");
        contaPoupanca.transfere(1000, contaCorrente);
        System.out.println(contaPoupanca.toString());


    }
}
