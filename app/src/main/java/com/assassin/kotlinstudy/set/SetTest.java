package com.assassin.kotlinstudy.set;

import androidx.annotation.Nullable;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020-01-09 09:01
 * Version: 1.0
 * Description: 测试自定义对象的set里面
 */
public class SetTest {
    


    public static void main(String[] args) {
        Student student = new Student("笑话",33f);
        Student student1 = new Student("笑话",33f);
        HashSet<Student>  set = new HashSet<Student>();
        set.add(student);
        set.add(student1);

        Teacher teacher = new Teacher("李老师", 22f);
        Teacher teacher1 = new Teacher("李老师", 22f);
        HashSet<Teacher>  set1= new HashSet<Teacher>();
        set1.add(teacher);
        set1.add(teacher1);

        Iterator<Student> iterator=set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        Iterator<Teacher> iterator1=set1.iterator();
        while (iterator1.hasNext())
        {
            System.out.println(iterator1.next());
        }
    }
    
}


class Student{
    private String name;
    private float score;

    public Student(String name, float score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}


class Teacher{
    private String name;
    private float score;

    public Teacher(String name, float score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Teacher teacher = (Teacher) o;

        if (Float.compare(teacher.score, score) != 0)
            return false;
        return name != null ? name.equals(teacher.name) : teacher.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (score != +0.0f ? Float.floatToIntBits(score) : 0);
        return result;
    }
    
    
    class School
    {
        private Teacher teacher;
        private Student student;

        public School(Teacher teacher, Student student) {
            this.teacher = teacher;
            this.student = student;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            School school = (School) o;

            if (!teacher.equals(school.teacher))
                return false;
            return student.equals(school.student);
        }

        @Override
        public int hashCode() {
            int result = teacher.hashCode();
            result = 31 * result + student.hashCode();
            return result;
        }
    }
}
