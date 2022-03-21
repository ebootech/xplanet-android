package tech.eboot.xplanet.binding;

/**
 * A one-argument action.
 *
 * @param <T> the first argument type
 */
public interface BindingConsumer<T> {
    void call(T t);
}
