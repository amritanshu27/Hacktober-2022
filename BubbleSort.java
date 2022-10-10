import java.io.*;
 
class sorting
{
    static void bubble_sort(int arr[], int n)
    {
        int i, j, temp;
        boolean is_swapped;
        for (i = 0; i < n - 1; i++)
        {
            is_swapped = false;
            for (j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    is_swapped = true;
                }
            }
 
            if (is_swapped == false)
                break;
        }
    }
 
    static void print_array(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    public static void main(String args[])
    {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        bubble_sort(arr, n);
        System.out.println("Sorted array: ");
        print_array(arr, n);
    }
}
 
 