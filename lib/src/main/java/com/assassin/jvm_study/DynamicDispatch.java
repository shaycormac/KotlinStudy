package com.assassin.jvm_study;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/02/16 10:13
 * Version:     1.0
 * Description: 
 * Java语言里动态分派的实现过程，它与Java语言多态性的另外
 * 一个重要体现[3]——重写(Override)有着很密切的关联。
 */
class DynamicDispatch {

    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }

    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }


    /**
     *  public static void main(java.lang.String[]);
     *     descriptor: ([Ljava/lang/String;)V
     *     flags: ACC_PUBLIC, ACC_STATIC
     *     Code:
     *       stack=2, locals=3, args_size=1
     *          0: new           #2                  // class com/assassin/jvm_study/DynamicDispatch$Man
     *          3: dup
     *          4: invokespecial #3                  // Method com/assassin/jvm_study/DynamicDispatch$Man."<init>":()V
     *          7: astore_1
     *          8: new           #4                  // class com/assassin/jvm_study/DynamicDispatch$Woman
     *         11: dup
     *         12: invokespecial #5                  // Method com/assassin/jvm_study/DynamicDispatch$Woman."<init>":()V
     *         15: astore_2
     *         16: aload_1
     *         17: invokevirtual #6                  // Method com/assassin/jvm_study/DynamicDispatch$Human.sayHello:()V
     *         20: aload_2
     *         21: invokevirtual #6                  // Method com/assassin/jvm_study/DynamicDispatch$Human.sayHello:()V
     *         24: new           #4                  // class com/assassin/jvm_study/DynamicDispatch$Woman
     *         27: dup
     *         28: invokespecial #5                  // Method com/assassin/jvm_study/DynamicDispatch$Woman."<init>":()V
     *         31: astore_1
     *         32: aload_1
     *         33: invokevirtual #6                  // Method com/assassin/jvm_study/DynamicDispatch$Human.sayHello:()V
     *         36: return
     * 
     * 
     * 
     */

    /**
     * 0~15行的字节码是准备动作，作用是建立man和woman的内存空间、调用M an和Woman类型的实 例构造器，
     * 将这两个实例的引用存放在第1、2个局部变量表的变量槽中，这些动作实际对应了Java源 码中的这两行:
     * 
     * Human man = new Man();
     * Human woman = new Woman();
     * 
     * 接下来的16~21行是关键部分，16和20行的aload指令分别把刚刚创建的两个对象的引用压到栈 顶，
     * 这两个对象是将要执行的say Hello()方法的所有者，称为接收者(Receiver);17和21行是方法调
     * 用指令，这两条调用指令单从字节码角度来看，无论是指令(都是invokevirt ual)还是参数(都是常量 池中第22项的常量，
     * 注释显示了这个常量是Human.say Hello()的符号引用)都完全一样，但是这两句指 令最终执行的目标方法并不相同。
     * 那看来解决问题的关键还必须从invokevirt ual指令本身入手，要弄清 楚它是如何确定调用方法版本、如何实现多态查找来着手分析才行。
     * 根据《Java虚拟机规范》，
     * 
     * invokevirtual指令的运行时解析过程[4]大致分为以下几步:
     * 1)找到操作数栈顶的第一个元素所指向的对象的实际类型，记作C。
     * 2)如果在类型C中找到与常量中的描述符和简单名称都相符的方法，则进行访问权限校验，如果 通过则返回这个方法的直接引用，查找过程结束;不通过则返回java.lang.IllegalAccessError异常。
     * 3)否则，按照继承关系从下往上依次对C的各个父类进行第二步的搜索和验证过程。
     * 4)如果始终没有找到合适的方法，则抛出java.lang.AbstractMethodError异常。
     * 
     * 
     * 正是因为invokevirt ual指令执行的第一步就是在运行期确定接收者的实际类型，
     * 所以两次调用中的 invokevirtual指令并不是把常量池中方法的符号引用解析到直接引用上就结束了，还会根据方法接收者 的实际类型来选择方法版本，
     * 这个过程就是Java语言中方法重写的本质。精髓！！！我们把这种在运行期根据实 际类型确定方法执行版本的分派过程称为动态分派。
     * 
     */
}
