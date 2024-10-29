package com.assassin.java8feature;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/03/16 12:08
 * Version:     1.0
 * Description: 简述一下这个类要做的事情
 */
public class Car {

    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired 自己的生成类" + this.toString());
    }


    public static void main(String[] args) {
        final Car car = Car.create(Car::new);
        final List< Car > cars = Arrays.asList( car );
        
        cars.forEach(Car::collide);
        
        cars.forEach(Car::repair);
        
        // 第四种
        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );
    }
}
    
    

