public class HeapSort {
    public void sort(Pessoa arr[], int tipo)
    {
        int N = arr.length;
 
        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i, tipo);
 
        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            Pessoa temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0, tipo);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(Pessoa arr[], int N, int i, int tipo)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if(tipo==1){
            if (l < N && arr[l].getMatricula() > arr[largest].getMatricula())
            largest = l;
 
        
        if (r < N && arr[r].getMatricula() > arr[largest].getMatricula())
            largest = r;

        }else if(tipo == 2){
            if (l < N && arr[l].getNome().compareTo (arr[largest].getNome())==1)
            largest = l;
 

        if (r < N && arr[r].getNome().compareTo(arr[largest].getNome())==1)
            largest = r;
        }else if(tipo == 3){
            if (l < N && arr[l].getNota() < arr[largest].getNota())
            largest = l;
 
        
        if (r < N && arr[r].getNota() < arr[largest].getNota())
            largest = r;
        }
        
 
        // If largest is not root
        if (largest != i) {
            Pessoa swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest, tipo);
        }
    }
 
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int N = arr.length;
 
        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}