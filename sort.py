import math
class sort:
    def bubbleSort(self,inarr):
        # Bubble sort. Make changes to the input array.
        total = len(inarr)
        if total < 2:
            return inarr
        for i in range(total-1):
            for j in range(i+1,total):
                if inarr[i] > inarr[j]:
                    inarr[i],inarr[j] = inarr[j],inarr[i]
        return inarr

    def selectionSort(self,inarr):
        total = len(inarr)
        if total < 2:
            return inarr
        for i in range(total-1):
            minTmp = inarr[i]
            minPos = i
            for j in range(i+1,total):
                if inarr[j] < minTmp:
                    minTmp = inarr[j]
                    minPos = j
            if minPos != i:
                inarr[minPos],inarr[i]=inarr[i],inarr[minPos]
        return inarr

    def insertionSort(self,inarr):
        total = len(inarr)
        if total < 2:
            return inarr
        for i in range(1,total):
            waitNum = inarr[i];
            j = i-1
            while j >= 0 and waitNum < inarr[j]:
                inarr[j+1] = inarr[j]
                j -= 1
            inarr[max(j,0)] = waitNum
        return inarr

    def quickSort(self,inarr,low,high):
        i = low
        j = high
        if i >= j:
            return inarr
        flagVal = inarr[i]
        while i < j:
            while i < j and inarr[j] >= flagVal:
                j -= 1
            while i < j and inarr[i] <= flagVal:
                i += 1
            inarr[i],inarr[j] = inarr[j],inarr[i]

        if inarr[i] > flagVal:
            i -= 1
        inarr[low],inarr[i] = inarr[i],inarr[low]
        self.quickSort(inarr, low, i-1)
        self.quickSort(inarr, i+1, high)
        return inarr

    def mergeSort(self,inarr):
        total = len(inarr)
        if total <=1:
            return inarr
        mid = total/2
        left = self.mergeSort(inarr[:mid])
        right = self.mergeSort(inarr[mid:])
        return self.merge(left,right)

    def merge(self,arr1,arr2):
        i = 0
        j = 0
        outarr = []
        while arr1 and arr2:
            if arr1[0] < arr2[0]:
                outarr.append(arr1.pop(0))
            else:
                outarr.append(arr2.pop(0))
        if arr1:
            outarr.extend(arr1)
        elif arr2:
            outarr.extend(arr2)
        return outarr

    def shellSort(self,inarr):
        total = len(inarr)
        gap = total // 2
        while gap > 0:
            for i in range(gap, total):
                insVal = inarr[i]
                j = i
                while j >= gap and inarr[j - gap] > insVal:
                    inarr[j] = inarr[j - gap]
                    j -= gap
                inarr[j] = insVal
            gap //= 2
        return inarr

    def radixSort(self,inarr,radix=10):
        K = int(math.ceil(math.log(max(inarr)+1, radix)))
        bucket = [[] for i in xrange(radix)]
        for i in range(1,K+1):
            for item in inarr:
                bucket[item%(radix**i)/(radix**(i-1))].append(item)
            del inarr[:]
            for item in bucket:
                inarr.extend(item)
            bucket = [[] for i in xrange(radix)]
        return inarr

if __name__ == '__main__':
    t = sort()
    arr = [10,9,8,7,6,5,4,3,2,1]
    print "Bubble sort:",
    print t.bubbleSort(arr)
    arr = [10,9,8,7,6,5,4,3,2,1]
    print "Selection sort:",
    print t.selectionSort(arr)
    arr = [10,9,8,7,6,5,4,3,2,1]
    print "Insertion sort:",
    print t.insertionSort(arr)
    arr = [10,9,8,7,6,5,4,3,2,1]
    print "Quick sort:",
    print t.quickSort(arr,0,len(arr)-1)
    arr = [10,9,8,7,6,5,4,3,2,1]
    print "Merge sort:",
    print t.mergeSort(arr)
    arr = [10,9,8,7,6,5,4,3,2,1]
    print "Shell sort:",
    print t.shellSort(arr)
    arr = [10,9,8,7,6,5,4,3,2,1]
    print "Bucket sort:",
    print t.radixSort(arr)
