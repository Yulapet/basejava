
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public static final int LIMITRESUMES = 10000;
    Resume[] storage = new Resume[LIMITRESUMES];
    int size = 0;


    void clear() {
        int idx = 0;
        Arrays.fill(storage, idx, LIMITRESUMES, null);
    }

    void save(Resume r) {
        for (int i = 0; i < LIMITRESUMES; i++) {
            storage[size++] = r;
        }
    }

    Resume get(String uuid) {
        return storage[getIndex(uuid)];
    }

    void delete(String uuid) {
        int index = getIndex(uuid);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(storage, index + 1, storage, index,
                    numMoved);
        storage[--size] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        for (int i = 0; i < size; i++) {
            Resume resume = storage[i];
        }
        return storage;

    }

    int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < LIMITRESUMES; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    return i;
            }
        }
        return -1;
    }
}
