package lab1;

public interface TranportFactory {
    Transport createInstance(String mark, int k) throws NoSuchFieldException;

}
