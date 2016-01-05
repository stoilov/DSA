package linearStructures;

/**
 * 
 * It is still not implemented, soon to be
 * 
 * @author stoilov
 * @param <T>
 */
public class TieredVector<T> {

    private int length;
    private Deque[] vector;

    public TieredVector() {
        length = 2;
        vector = new Deque[length];
        
        for (int i = 0; i < vector.length; i++) {
            vector[i] = new Deque();
        }
    }

    public void insertElemAtRank(int rank, T element) {

    }

    public T removeElemAtRank(int rank) {

        return null;
    }

    public T elemAtRank(int rank) {
        
        return null;
    }

}
