package lab1;

public class MotoFactory implements  TranportFactory{
    @Override
    public Transport createInstance(String mark, int k) throws NoSuchFieldException {
        return new Moto(mark,k);
    }
}
