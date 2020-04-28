package com.assassin.kotlinstudy.algorithm;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020/2/29 22:16
 * Version: 1.0
 * Description: 
 *  算法题 微软远程面试题
 *   有两个非递减并且已经排好续的数组，求两个数组合并后新数组的中位数
 *   要求用不带提示的文档写代码，语言不限，要求要有代码规范
 *   
 *    非递减就是譬如[9,9,8,5],可能有相同的元素,从大到小排列
 *    中位数是指这个数组如果奇数个元素，取中间值，如果偶数个，取中间两个值之和的平均值。
 *    
 *    
 *    思路：需要一个新数组把两个数组全部放进来，我当时直接粗暴的把两个先后放入，还需要重新排序，经过面试官的
 *    指点，比较两个数组的首位，大的放在后面，依次类推
 *    难点就是如何快速排成新的一个数组
 */
public class FindMidValue {
    /**
     * 
     * @param a 不能为空已经排好序的非递减数组
     * @param b 不能为空已经排好序的非递减数组
     * @return
     */
    public static float getTarget(int a[],int b[])
    {
        int  lengthA = a.length;
        int lengthB = b.length;
        int c[] = new int[lengthA+lengthB];
        //判断两个数组的长度,遍历短的数组
        
        int tmpA;
        int tmpB;
        
        int size=0;
        if(lengthA <= lengthB)
        {
            //自己手写的时候错误了，最后加加
            for (int i = 0; i < lengthA; i++) 
            {
                //比较两个位置上的元素大小
             tmpA  = a[i];
             tmpB = b[i];
             //数组A的第一个值比较大，先放A
             if(tmpA>=tmpB)
             {
                 //第一个位置已经放好了，
                 c[i]=tmpA;
                 //开始处理B了，还要看看B的元素是不是比a的第二个大，一直循环下去把
                 //比较大的话，直接赋值，结束这次比较
                 if (i<lengthA-2 &&tmpB>=a[i+1])
                 {
                     // 记住占据的元素个数
                     size++;
                     c[i+1]=tmpB;
                 }else 
                 {
                     for(int j=i+1;j<lengthA;j++)
                     {
                         if(a[j]>=tmpB)
                         {
                             c[j]=a[j];
                         }else 
                         {
                             size++;
                             c[j]=tmpB;
                             break;
                         }
                         
                     }
                     
                 }
             }else 
             {
                 //B的值比较大
                 c[i]=tmpB;
                 if (tmpA>=b[i+1])
                 {
                     size++;
                     c[i+1]=tmpA;
                 }else
                 {
                     for(int j=i+1;j<lengthA;j++)
                     {
                         if(b[j]>=tmpA)
                         {
                             c[j]=b[j];
                         }else
                         {
                             size++;
                             c[j]=tmpA;
                             break;
                         }

                     }

                 }
                 
                 
             }
                
            }
           //剩下的元素需要补气
           for (int k=lengthA+size;k<lengthA+lengthB;k++)
           {
               c[k]=b[size+k];
           }
               
            
          printArray(c);  
            
        }
        else 
        {
            
        }
        
        return 0f;
    }
    
    public static  void printArray(int args[])
    {
        System.out.printf("[");
        for(int i = 0;i<args.length;i++)
        {
            System.out.printf(args[i]+",");
        }
        System.out.printf("]");
        System.out.println("-----");
    }

    public static void main(String[] args) {
        int a[] = {9,9,8,7,6};
        int b[] ={8,6,5,4,3,2,1,0};
        getTarget(a,b);
        
    }
}
