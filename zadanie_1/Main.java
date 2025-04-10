package zadanie_1;
import java.util.Random;

interface SortingStrategy {
    void sort(int[] array);
}

class InvalidSortingAlgorithmException extends Exception {
    public InvalidSortingAlgorithmException(String message) {
        super(message);
    }
}

class BubbleSort implements SortingStrategy {
    public void sort(int[] tab) {
        int n = tab.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (tab[j] > tab[j+1]) {
                    int temp = tab[j];
                    tab[j] = tab[j+1];
                    tab[j+1] = temp;
                }
            }
        }
    }
}

class InsertionSort implements SortingStrategy {
    public void sort(int[] tab) {
        int n = tab.length;
        for (int i = 1; i < n; ++i) {
            int key = tab[i];
            int j = i - 1;

            while (j >= 0 && tab[j] > key) {
                tab[j + 1] = tab[j];
                j = j - 1;
            }
            tab[j + 1] = key;
        }
    }
}

class MergeSort implements SortingStrategy {
    public void sort(int[] tab) {
        mergeSort(tab, 0, tab.length - 1);
    }

    private void mergeSort(int[] tab, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(tab, l, m);
            mergeSort(tab, m + 1, r);

            merge(tab, l, m, r);
        }
    }

    private void merge(int[] tab, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = tab[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = tab[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                tab[k] = L[i];
                i++;
            } else {
                tab[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            tab[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            tab[k] = R[j];
            j++;
            k++;
        }
    }
}

class QuickSort implements SortingStrategy {
    public void sort(int[] tab) {
        quickSort(tab, 0, tab.length - 1);
    }

    private void quickSort(int[] tab, int low, int high) {
        if (low < high) {
            int pi = partition(tab, low, high);

            quickSort(tab, low, pi - 1);
            quickSort(tab, pi + 1, high);
        }
    }

    private int partition(int[] tab, int low, int high) {
        int pivot = tab[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (tab[j] < pivot) {
                i++;

                int temp = tab[i];
                tab[i] = tab[j];
                tab[j] = temp;
            }
        }

        int temp = tab[i + 1];
        tab[i + 1] = tab[high];
        tab[high] = temp;

        return i + 1;
    }
}

class SelectionSort implements SortingStrategy {
    public void sort(int[] tab) {
        int n = tab.length;

        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (tab[j] < tab[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = tab[minIndex];
            tab[minIndex] = tab[i];
            tab[i] = temp;
        }
    }
}

class Sorter {
    private SortingStrategy sortingStrategy;

    public Sorter(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(int[] tab) throws InvalidSortingAlgorithmException {
        if (sortingStrategy == null) {
            throw new InvalidSortingAlgorithmException("Nie wybrano algorytmu sortowania.");
        }
        sortingStrategy.sort(tab);
    }
}

class Sorting {
    public static void main(String[] args) {
        Random random = new Random();
        int[] tab = new int[50];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = random.nextInt(201) - 100;
        }

        System.out.println("Tablica liczb:");
        for (int num : tab) {
            System.out.print(num + "; ");
        }
        System.out.println();

        Sorter sorter = new Sorter(new BubbleSort());
        long startTime = System.nanoTime();
        try {
            sorter.sort(tab);
        } catch (InvalidSortingAlgorithmException e) {
            System.out.println("Błąd sortowania: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Czas sortowania babelkowego: " + duration + " nanosekund");

//        Sorter sorter = new Sorter(new InsertionSort());
//        long startTime = System.nanoTime();
//        try {
//            sorter.sort(tab);
//        } catch (InvalidSortingAlgorithmException e) {
//            System.out.println("Błąd sortowania: " + e.getMessage());
//        }
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        System.out.println("Czas sortowania przez wstawianie: " + duration + " nanosekund");

//        Sorter sorter = new Sorter(new MergeSort());
//        long startTime = System.nanoTime();
//        try {
//            sorter.sort(tab);
//        } catch (InvalidSortingAlgorithmException e) {
//            System.out.println("Błąd sortowania: " + e.getMessage());
//        }
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        System.out.println("Czas sortowania przez scalanie: " + duration + " nanosekund");

//        Sorter sorter = new Sorter(new QuickSort());
//        long startTime = System.nanoTime();
//        try {
//            sorter.sort(tab);
//        } catch (InvalidSortingAlgorithmException e) {
//            System.out.println("Błąd sortowania: " + e.getMessage());
//        }
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        System.out.println("Czas sortowania szybkiego: " + duration + " nanosekund");

//        Sorter sorter = new Sorter(new SelectionSort());
//        long startTime = System.nanoTime();
//        try {
//            sorter.sort(tab);
//        } catch (InvalidSortingAlgorithmException e) {
//            System.out.println("Błąd sortowania: " + e.getMessage());
//        }
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        System.out.println("Czas sortowania wybieranie: " + duration + " nanosekund");

        System.out.println("Tablica posortowanych liczb:");
        for (int num : tab) {
            System.out.print(num + "; ");
        }
        System.out.println();
    }
}