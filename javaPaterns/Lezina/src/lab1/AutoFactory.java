package lab1;

public class AutoFactory implements TranportFactory {
    @Override
    public Transport createInstance(String mark, int k) {
        return new Auto(mark, k);
    }
}
