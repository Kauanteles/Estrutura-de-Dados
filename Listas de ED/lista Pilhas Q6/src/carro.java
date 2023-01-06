public class carro {
    private String placa;
    private int vezesManobrado = 0;

    public carro(String placa){
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getVezesManobrado() {
        return vezesManobrado;
    }

    public void VezesManobrado() {
        vezesManobrado++;
    }

}
