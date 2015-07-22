#include<iostream>

using namespace std;

void bubbleSort(int inarr[],int count){
        if(count < 2) return;
        int i,j,tmp;
        for(i=0;i<count-1;i++){
                for(j=i+1;j<count;j++){
                        if(inarr[i] > inarr[j]){
                                tmp = inarr[i];
                                inarr[i] = inarr[j];
                                inarr[j] = tmp;
                        }
                }
        }
}

void selectionSort(int inarr[], int count){
        if(count < 2) return;
        for(int i=0;i<count-1;i++){
                int minTmp = inarr[i];
                int minPos = i;
                for(int j=i+1;j<count;j++){
                        if(inarr[j] < minTmp){
                                minTmp = inarr[j];
                                minPos = j;
                        }
                }
                if(i != minPos){
                        int tmp;
                        tmp = inarr[minPos];
                        inarr[minPos] = inarr[i];
                        inarr[i] = tmp;
                }
        }
}

void insertionSort(int inarr[], int count){
        if(count < 2) return;
        for(int i=1;i<count;i++){
                int waitNum = inarr[i];
                int j = i-1;
                while(j>=0 && waitNum < inarr[j]){
                        inarr[j+1] = inarr[j];
                        j--;
                }
                inarr[(j>0)?j:0] = waitNum;
        }
}

void quickSort(int inarr[], int low, int high){
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

int main(){
        int a[10] = {10,9,8,7,6,5,4,3,2,1};
        bubbleSort(a,10);
        cout << "Bubble sort: ";
        for(int i =0;i<=9;i++){
                cout << a[i] << " ";
        }
        cout << endl;

        int b[10] = {10,9,8,7,6,5,4,3,2,1};
        selectionSort(b,10);
        cout << "Selection sort: ";
        for(int i =0;i<=9;i++){
                cout << b[i] << " ";
        }
        cout << endl;

        int c[10] = {10,9,8,7,6,5,4,3,2,1};
        insertionSort(c,10);
        cout << "Insertion sort: ";
        for(int i =0;i<=9;i++){
                cout << c[i] << " ";
        }
        cout << endl;

        int d[10] = {10,9,8,7,6,5,4,3,2,1};
        quickSort(d,0,9);
        cout << "Quick sort: ";
        for(int i =0;i<=9;i++){
                cout << d[i] << " ";
        }
        cout << endl;

        return 0;
}
