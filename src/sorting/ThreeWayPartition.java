package sorting;

public class ThreeWayPartition {
    public void threeWayPartition(int array[], int a, int b)
    {
        int  n = array.length;
        int start = 0, end = n-1;
        for(int i = 0; i <= end;)
        {

            if(array[i] < a)
            {

                int temp = array[start];
                array[start] = array[i];
                array[i] = temp;
                start++;
                i++;

            }
            else if(array[i] > b)
            {

                int temp = array[end];
                array[end] = array[i];
                array[i] = temp;
                end--;
            }
            else{
                i++;
            }

        }
    }

}
