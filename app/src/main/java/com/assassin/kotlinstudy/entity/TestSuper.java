package com.assassin.kotlinstudy.entity;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020/4/26 14:19
 * Version: 1.0
 * Description: 类说明
 */
public abstract class TestSuper
{
    abstract String getString(int aa);
}

class TestExtends extends TestSuper
{
    @Override
    String getString(int aa) {
        return null;
    }
}


class Father{
    
    public String getName()
    {
        return "Father";
    }
    
    public void save(String hehe)
    {
        
    }
}

class Son extends Father
{
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void save(String hehe) {
        //父类也需要保存这个逻辑。
        super.save(hehe);
    }
}
