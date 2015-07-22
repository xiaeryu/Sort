import java.util.Arrays;

public class sort{
        public static void bubbleSort(int inarr[]){
                int i,j,tmp;
                if(inarr.length < 2) return;
                for(i=0;i<inarr.length-1;i++){
                        for(j=i+1;j<inarr.length;j++){
                                if(inarr[i] > inarr[j]){
                                        tmp = inarr[i];
                                        inarr[i] = inarr[j];
                                        inarr[j] = tmp;
                                }
                        }
                }
        }

        public static void selectionSort(int inarr[]){
                if(inarr.length < 2) return;
                for(int i=0;i<inarr.length-1;i++){
                        int minTmp = inarr[i];
                        int minPos = i;
                        for(int j=i+1;j<inarr.length;j++){
                                if(inarr[j] < minTmp){
                                        minTmp = inarr[j];
                                        minPos = j;
                                }
                        }
                        if(minPos != i){
                                int tmp;
                                tmp = inarr[minPos];
                                inarr[minPos] = inarr[i];
                                inarr[i] = tmp;
                        }
                }
        }

        public static void insertionSort(int inarr[]){
                if(inarr.length < 2) return;
                for(int i=1;i<inarr.length;i++){
                        int waitNum = inarr[i];
                        int j = i-1;
                        while(j>=0 && (waitNum < inarr[j])){
                                inarr[j+1] = inarr[j];
                                j--;
                        }
                        inarr[(j>0)?j:0]  = waitNum;
                }
        }

        public static void quickSort(int inarr[],int low, int high){
                int i = low;
                int j = high;
                if(i >= j) return;
                int flagVal = inarr[i];
                while(i < j){
                        while((i < j) && (inarr[j] >= flagVal)) j--;
                        while((i < j) && (inarr[i] <= flagVal)) i++;
                        int tmp = inarr[i];
                        inarr[i] = inarr[j];
                        inarr[j] = tmp;
                }
                if(inarr[i] > flagVal) i--;
                int tmp = inarr[low];
                inarr[low] = inarr[i];
                inarr[i] = tmp;
                quickSort(inarr, low, i-1);
                quickSort(inarr, i+1, high);
        }

/*
        public static int[] merge(int arr1[], int arr2[]){
                int i = 0;
                int j = 0;
                int outarr[] = new int[arr1.length+arr2.length];
                int curr = 0;
                while((i < arr1.length) && (j < arr2.length)){
                        if(arr1[i] < arr2[j]){
                                outarr[curr] = arr1[i];
                                i++;
                        }else{
                                outarr[curr] = arr2[j];
                                j++;
                        }
                        curr++;
                }
                if(i < arr1.length){
                        for(int m=0; m<=arr1.length+arr2.length-1-curr;m++){
                                outarr[curr+m] = arr1[i+m];
                        }
                }
                if(j < arr2.length){
                        for(int m=0; m<=arr1.length+arr2.length-1-curr;m++){
                                outarr[curr+m] = arr2[j+m];
                        }
                }
                return outarr;
        }

        public static int[] mergeSort(int inarr[]){
                if(inarr.length <= 1){
                        return inarr;
                }
                int mid = (int)(inarr.length/2);
                int left[] = Arrays.copyOfRange(inarr,0,mid-1);
                int right[] = Arrays.copyOfRange(inarr,mid,inarr.length);
                int left_out[] = mergeSort(left);
                int right_out[] = mergeSort(right);
                return merge(left_out, right_out);
        }
*/
        public static void main(String args[]){
                int a[] = {9,8,7,6,5,4,3,2,1};
                bubbleSort(a);
                System.out.print("Bubble sort: ");
                for(int i=0; i < a.length; i++) {
                        System.out.print(a[i] + " ");
                }
                System.out.println("");

                int b[] = {9,8,7,6,5,4,3,2,1};
                selectionSort(b);
                System.out.print("Selection sort: ");
                for(int i=0; i < b.length; i++) {
                        System.out.print(b[i] + " ");
                }
                System.out.println("");

                int c[] = {9,8,7,6,5,4,3,2,1};
                insertionSort(c);
                System.out.print("Insertion sort: ");
                for(int i=0; i < c.length; i++) {
                        System.out.print(c[i] + " ");
                }
                System.out.println("");

                int d[] = {9,8,7,6,5,4,3,2,1};
                quickSort(d, 0 ,d.length-1);
                System.out.print("Quick sort: ");
                for(int i=0; i < d.length; i++) {
                        System.out.print(d[i] + " ");
                }
                System.out.println("");

/*                int e[] = {9,8,7,6,5,4,3,2,1};
                int result[] = new int[e.length];
                result = mergeSort(e);
                System.out.print("Merge sort: ");
                for(int i=0; i < result.length; i++) {
                        System.out.print(result[i] + " ");
                }
                System.out.println("");
*/
        }
}
