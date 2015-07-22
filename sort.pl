sub bubbleSort{
        my @inarr = @_;
        my $total = $#inarr;
        if($total < 2){
                return @inarr;
        }
        for(my $i=0;$i<$total;$i++){
                for(my $j=$i+1;$j<=$total;$j++){
                        if($inarr[$i]>$inarr[$j]){
                                ($inarr[$i],$inarr[$j]) = ($inarr[$j],$inarr[$i]);
                        }
                }
        }
        return @inarr;
}

sub selectionSort{
        my @inarr = @_;
        my $total = $#inarr;
        if($total < 2){
                return @inarr;
        }
        for(my $i=0;$i<$total;$i++){
                my $minTmp = $inarr[$i];
                my $minPos = $i;
                for(my $j=$i+1;$j<=$total;$j++){
                        if($inarr[$j] < $minTmp){
                                $minTmp = $inarr[$j];
                                $minPos = $j;
                        }
                }
                if($minPos != $i){
                        ($inarr[$i],$inarr[$minPos]) = ($inarr[$minPos],$inarr[$i]);
                }
        }
        return @inarr;
}

sub insertionSort{
        my @inarr = @_;
        my $total = $#inarr;
        if($total < 2){
                return @inarr;
        }
        for(my $i=1;$i<=$total;$i++){
                my $waitNum = $inarr[$i];
                my $j = $i-1;
                while($j>=0 && ($waitNum < $inarr[$j])){
                        $inarr[$j+1] = $inarr[$j];
                        $j--;
                }
                $inarr[($j>0)?$j:0] = $waitNum;
        }
        return @inarr;
}

sub quickSort{
        my @inarr = @_;
        if($#inarr < 1){return @inarr;}

        my $flagVal = shift @inarr;
        return (&quickSort(grep{$_ < $flagVal} @inarr), $flagVal, &quickSort(grep{$_ >= $flagVal} @inarr));
}

sub merge{
        my($arr1,$arr2)=@_;
        my @outarr;
        while(($#$arr1 >=0 ) && ($#$arr2 >= 0)){
                if($$arr1[0] < $$arr2[0]){
                        push(@outarr,shift(@$arr1));
                }else{
                        push(@outarr,shift(@$arr2));
                }
        }
        if($#$arr1 >= 0){
                push(@outarr,@$arr1);
        }
        if($#$arr2 >= 0){
                push(@outarr,@$arr2);
        }
        return @outarr;
}

sub mergeSort{
        my @inarr = @_;
        if($#inarr <= 0){
                return @inarr;
        }
        my $mid = int(($#inarr+1)/2);
        my @left_in = @inarr[0 .. $mid-1];
        my @right_in = @inarr[$mid .. $#inarr];
        my @left = mergeSort(@left_in);
        my @right = mergeSort(@right_in);
        return &merge(\@left,\@right);
}

my @arr = (10,9,8,7,6,5,4,3,2,1);
print "Bubble sort: ";
print join(" ",&bubbleSort(@arr))."\n";
print "Selection sort: ";
print join(" ",&selectionSort(@arr))."\n";
print "Insertion sort: ";
print join(" ",&insertionSort(@arr))."\n";
print "Quick sort: ";
print join(" ",&quickSort(@arr))."\n";
print "Merge sort: ";
print join(" ",&mergeSort(@arr))."\n";
