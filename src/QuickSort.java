import java.util.Random;

public class QuickSort {
    //如何优雅的手写快排
    Random random = new Random();

    public void quickSort(int[] a, int l, int r){
        if (l < r){
            int p = randomPatition(a, l, r);
            quickSort(a, l, p-1);
            quickSort(a, p+1, r);
        }
    }

    public int randomPatition(int[] a, int l, int r){
        int i = random.nextInt(r-l+1)+l;
        swap(a, i, r);
        return patition(a, l, r);
    }

    public int patition(int[] a, int l, int r){
        int x = a[r];
        int j = l;
        for(int i = l; i < r; i++){
            if (x > a[i])  swap(a, j++, i);
        }
        swap(a, j, r);
        return j;
    }

    public void swap(int[] a, int l, int r){
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    public static void main(String arg[]){
        int[] array = {2,3,4,1,4,6};
        new QuickSort().quickSort(array, 0, array.length-1);
        return;
    }
}
