public interface GraphInterface
{
    boolean contain(Object element);
    boolean isSuccessor(Object father, Object child);
    int weight(Object one, Object two);
}
