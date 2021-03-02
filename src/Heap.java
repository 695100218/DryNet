public class Heap {
    public static void main(String arg[]){
        int[] array = {2,3,4,1,4,6};
        new Heap().heapSort(array);
        return;
    }

    //大根堆
    public void heapSort(int[] a){
        buildHeap(a, a.length);
        int heapsize = a.length;
        for(int i = a.length-1; i >= 1; i--){
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            heapsize -= 1;
            maxHeapify(a, 0, heapsize);
        }
    }

    public void buildHeap(int[] a, int heapsize){
        int lengthParent = parent(a.length -1);
        for(int i = lengthParent; i >= 0; i--){
            maxHeapify(a, i, heapsize);
        }
    }

    public void maxHeapify(int [] a, int i, int heapsize){
        int l = left(i), r = right(i);
        int largest = -1;
        if (l < heapsize && a[i] < a[l]) largest = l;
        else largest = i;
        if (r < heapsize && a[largest] < a[r]) largest = r;
        if (largest != i){
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            maxHeapify(a, largest, heapsize);
        }
    }

    public int left(int i) {
        return (i + 1) * 2 - 1;
    }

    public int right(int i) {
        return (i + 1) * 2;
    }

    public int parent(int i) {
        // i为根结点
        if (i == 0) return -1;
        return (i - 1) / 2;
    }
}
