
import java.util.Arrays;
import java.util.Collection;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public static final int VAL = 10000;
    Resume[] storage = new Resume[VAL];
    int size = 0;




    void clear() {
        Arrays.fill(storage, null);

    }

    void save(Resume r) {
        for (int i = 0; i < VAL; i++) {
            if (storage[i] == null) {
                storage[i] = r;
            }

        }
    }

    Resume get(String uuid) {

    return storage[getIndex(uuid)];
    }

    void delete(String uuid) {
        int index = getIndex(uuid);

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(storage, index+1, storage, index,
                    numMoved);
        storage[--size] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Collection<Resume> getAll() {

    return Arrays.asList(Arrays.copyOf(storage, size));

    }

    int size() {

        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < VAL; i++) {
            if (storage[i] != null) {
                if (storage[i].getUuid().equals(uuid)) {
                    return i;
                }
            }

        }
        return -1;
    }
}
