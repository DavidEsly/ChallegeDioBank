public interface IConta {
    void deposita(double valor);
    void transfere(double valor, Conta conta);
    void saca(double valor);

}
