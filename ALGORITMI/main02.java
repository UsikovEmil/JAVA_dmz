package DZ01;

public class main01 {
    public void sort(int arr[]) {
        int n = arr.length;

        // Построение кучи (перегруппировка массива)
       // for (int i = n / 2 - 1; i >= 0; i--)
            

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Чтобы heapify поддерево с корневым узлом i, который является
    // индексом в arr[]. n - размер кучиФ
    void heapify(int arr[], int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно heapify затронутое поддерево
            heapify(arr, n, largest);
        }
    }
}
