package com.assassin.kotlinstudy.entity

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/02/09 16:32
 * Version:     1.0
 * Description: 简述一下这个类要做的事情
 */
data class MyDataClass(val name: String = "张三", var age: Int) {
    var score: Int? = null
}

// 生成的java字节码为

/**
 * package com.assassin.kotlinstudy.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
mv = {1, 5, 1},
k = 1,
d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"},
d2 = {"Lcom/assassin/kotlinstudy/entity/MyDataClass;", "", "name", "", "age", "", "(Ljava/lang/String;I)V", "getAge", "()I", "setAge", "(I)V", "getName", "()Ljava/lang/String;", "score", "getScore", "()Ljava/lang/Integer;", "setScore", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}
)
public final class MyDataClass {
@Nullable
private Integer score;
@NotNull
private final String name;
private int age;

@Nullable
public final Integer getScore() {
return this.score;
}

public final void setScore(@Nullable Integer var1) {
this.score = var1;
}

@NotNull
public final String getName() {
return this.name;
}

public final int getAge() {
return this.age;
}

public final void setAge(int var1) {
this.age = var1;
}

public MyDataClass(@NotNull String name, int age) {
Intrinsics.checkNotNullParameter(name, "name");
super();
this.name = name;
this.age = age;
}

// $FF: synthetic method
public MyDataClass(String var1, int var2, int var3, DefaultConstructorMarker var4) {
if ((var3 & 1) != 0) {
var1 = "张三";
}

this(var1, var2);
}

@NotNull
public final String component1() {
return this.name;
}

public final int component2() {
return this.age;
}

@NotNull
public final MyDataClass copy(@NotNull String name, int age) {
Intrinsics.checkNotNullParameter(name, "name");
return new MyDataClass(name, age);
}

// $FF: synthetic method
public static MyDataClass copy$default(MyDataClass var0, String var1, int var2, int var3, Object var4) {
if ((var3 & 1) != 0) {
var1 = var0.name;
}

if ((var3 & 2) != 0) {
var2 = var0.age;
}

return var0.copy(var1, var2);
}

@NotNull
public String toString() {
return "MyDataClass(name=" + this.name + ", age=" + this.age + ")";
}

public int hashCode() {
String var10000 = this.name;
return (var10000 != null ? var10000.hashCode() : 0) * 31 + Integer.hashCode(this.age);
}

public boolean equals(@Nullable Object var1) {
if (this != var1) {
if (var1 instanceof MyDataClass) {
MyDataClass var2 = (MyDataClass)var1;
if (Intrinsics.areEqual(this.name, var2.name) && this.age == var2.age) {
return true;
}
}

return false;
} else {
return true;
}
}
}

 */
