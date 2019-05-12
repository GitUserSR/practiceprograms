package generics;

public class Something<T>
{
    public static <T> Something<T> newInstance(Class<T> type)
    {
        return new Something<T>();
    }

    public void doSomething(T input){;}

    public static <S> void doOtherThing(Class<S> clazz, S input)
    {
        Something<S> smt = Something.newInstance(clazz);
        smt.doSomething(input); input.getClass();
    }
    
    public static void main(String[] args) {
    	Integer input = 1;
    	doOtherThing(Integer.class, input);
    }
}