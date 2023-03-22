package apiCommons;

public interface Json {
    public <T> String toJSon(T t) throws Exception;

    public <T> T fromJson(String jSon,
                          Class<T> clazz) throws Exception;
}