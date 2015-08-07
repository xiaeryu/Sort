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

        public static void heapSort(int inarr[]){
                for(int i=inarr.length-1;i>=0;i--){
                        int tmp = inarr[0];
                        inarr[0] = inarr[i];
                        inarr[i] = tmp;
                        heapDown(inarr,0,i);
                }
        }

        public static void heapDown(int arr[], int i, int n){
                int tmp = arr[i];
                int j = i*2 +1;
                while(j < n){
                        if((j+1 < n) && (arr[j+1] > arr[j])){j++;}
                        if(arr[j] < tmp){break;}
                        arr[i] = arr[j];
                        i = j;
                        j = 2*i +1;
                }
                arr[i] = tmp;
        }
        
        public static void merge(int[] inarr, int from, int mid, int to){
		int fullLen = to - from + 1;
		int rLen = to - mid;
		int lLen = mid - from + 1;

		int[] storage = new int[fullLen];
		for(int m=from; m<=to; m++){
			storage[m-from] = inarr[m];
		}
                
		int i = 0;
		int j = mid-from+1;
		int flag = from;
		while(i < lLen && j < fullLen){
			if(storage[i] <= storage[j]){
				inarr[flag] = storage[i];
				i ++;
			}else{
				inarr[flag] = storage[j];
				j ++;
			}
			flag ++;
		}
		if(i < lLen){
			for(int m=i;m<lLen;m++){
				inarr[flag] = storage[m];
				flag ++;
			}
		}
		if(j < fullLen){
			for(int n=j;n<rLen;n++){
				inarr[flag] = storage[n];
				flag ++;
			}
		}
	}

	public static void mergeSort(int[] inarr, int from, int to){
		if(to <= from){return;}
		int mid = (to + from)/2;
		mergeSort(inarr,from,mid);
		mergeSort(inarr,mid+1,to);
		merge(inarr,from,mid,to);
	}
	
	public static void shellSort(int[] inarr){
                int gap = inarr.length/2;
                while(gap > 0){
                        for(int i=gap; i<inarr.length;i++){
                                int insVal = inarr[i];
                                int j = i;
                                while(j>=gap && inarr[j-gap]>insVal){
                                        inarr[j] = inarr[j-gap];
                                        j -= gap;
                                }
                                inarr[j] = insVal;
                        }
                        gap /= 2;
                }
        }


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

                int f[] = {9,8,7,6,5,4,3,2,1};
                heapSort(f);
                System.out.print("Heap sort: ");
                for(int i=0; i < f.length; i++) {
                        System.out.print(f[i] + " ");
                }
                System.out.println("");
        }
}
