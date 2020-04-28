package com.assassin.sort;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020/3/11 08:53
 * Version: 1.0
 * Description: 简单排序，核心在于每次循环找出最小的值放在最左边，依次遍历
 */
public class Sort {
    
    public static void  swapValue(int i,  int j ,int[] array)
    {
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    
    public static  void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
        }
    }

    public static void main(String[] args) {
        int []arrayTest = new int[]{10,4,7,16,3,2,1,15,20,20};
      //  simpleSort(arrayTest);
       // bubbleSort(arrayTest);
       // quickSort(arrayTest,0,arrayTest.length-1);
        insertSort(arrayTest);
        printArray(arrayTest);
        
        
    }

    /**
     * 简单选择排序  Simple Selection Sort
     * @param array
     */
    public static void simpleSort(int [] array)
    {
        //数组中每次循环的元素最小值对应的下标
        int min;
        for (int i = 0; i < array.length; i++) {
            //每次默认给当前循环的值
            min = i;
            //从这个元素的后面一位开始遍历查找，如果有的值比这个要小，就互换下标位置
            for (int j = i+1; j < array.length; j++) {
                // 假定最小的值与当前循环的元素进行比较
                if (array[min]>array[j])
                {
                    //互换下标
                    min = j;
                }
            }
            //小的循环弄完，在这次大循环中每次把最小的元素找出来，放到对应的位置
            if (min!=i)
            {
                swapValue(i, min, array);
            }
        }
        
    }

    /**
     * 冒泡排序 BubbleSort
     * @param array
     */
    public static void bubbleSort(int [] array)
    {
        boolean hasChange = true;
        for (int i = 0; i < array.length && hasChange; i++) 
        {
            for (int j = array.length-1; j >i; j--) 
            {
                hasChange =false;
                if (array[j]<array[j-1])
                {
                    swapValue(j, j-1, array);
                    hasChange=true;
                }
                
            }
            
        }
        
    }

    /**
     *   quickSort  快速排序，使用递归思想，先找出一个枢轴，比它大的就放在右边，比它小的，就放在左面
     *    给你一个数组，先从第一个元素开始作为枢轴 pivot
     * @param array
     */
    public static void quickSort(int [] array,int low, int high)
    {
        int pivot;
        if (low<high)
        {
            //先找到一个枢轴
            pivot = quickFindPivot(array, low, high);
            //已它为界限，左面和右面的都需要进行和它相同的操作递归来找到枢轴，
            //最后递归到不能仔递归的，相当于极限的三个排好序的元素，中间的那个就是枢轴。
            quickSort(array, low, pivot-1);
            quickSort(array, pivot+1, high);
        }
       
        
    }

    /**
     *   找到 一个数组的枢轴，保证枢轴的左面都比枢轴小，右边的都比它大
     * @param array
     * @param low  数组的起始下标
     * @param high 数组的结束下标
     * @return
     */
    private static  int  quickFindPivot(int[] array, int low, int high)
    {
        //先假设数组的low对应的元素是枢轴
        int pivot = array[low];
        // 保证遍历一次
        while (low<high)
        {
            //一定要明白这个循环的退出退出条件和循环体里面的意思
            //这个含义是结束下标从右往左(代码为high--)依次查找，如果都是大于枢轴(代码为array[high]>=pivot)的，那么就继续往左面去找相邻元素(代码为high--)
            //直到找到一个元素，它是小于枢轴的，循环结束了，此时它对应的下标的元素由于小于枢轴，需要把枢轴对应的元素和它交换，这样，就保证了这一次循环，
            //把枢轴的右边都是大于枢轴的
            while (low<high&& array[high]>=pivot)
            {
                high--;
            }
            swapValue(low, high, array);
            //此时，high已经改变了，起始下标从左往右扫描，只要小于枢轴的，就继续扫描（代码为low++），直到找到一个元素，发现它是大于枢轴的，那么枢轴就要和它
            //进行交换，注意，退出循环体后再交换。
            while (low<high && array[low]<=pivot)
            {
                low++;
            }
            swapValue(low, high, array);
            
        }
        //经过这次扫描循环，就能初步找到一个这样的枢轴元素，就是它右面的都是大于它，左面的都是小于它，当然，大于它的右边元素不一定是排好序的。
        return low;
    }


    /**
     * 直接插入 O[n*2]
     * @param array
     */
    public static void insertSort(int [] array)
    {
        int i, j;
        //需要插入的元素，怎么理解，它也是数组中的一个元素，只是把它拿出来，这样，他的位置就可以被后面大于他的元素放心的右移一位。
        int insertTarget;
        //从数组的第二个元素开始，每一次循环，都把array[i]拿出来，和前面的元素们进行一一比较，都是想左扫描啊
        //为啥从1开始，是因为假如就是1的话，它往左只有0所在的元素，进行比较，如果0所在的元素大的话，就往右挪动一位，他就插在0元素，结束。
        //那么从0开始，就没意义了
        for(i=1;i<array.length;i++)
        {
            //先把要插入的元素拷贝出来，他的位置就可以作为前面的元素放心往右挪动了
            insertTarget = array[i];
            //然后从这个元素所在的下标位置开始，往左扫描，while循环的条件是这次扫描，
            j =i;
            //此时因为是拿出来的array[i]=array[j],需要和它左面的一位开始比较，所以while循环条件从array[j-1]开始
            while (j>0&& array[j-1]>insertTarget)
            {
                //向左扫描，如果扫描到的元素大于要插入的，就把这个元素往右挪动一位
                array[j]=array[j-1];
                //向左继续扫描，直到扫描到
                j--;
            }
            //循环退出的条件就是向左扫描的时候，找到了这样一个元素的位置，他是小于当前的目标值，插入
            array[j]=insertTarget;
            
        }
        
    }
}
