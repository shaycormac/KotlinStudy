package com.assassin.kotlinstudy.builder

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-09-29 14:33
 * Version: 1.0
 * Description: 构建者模式
 * 1.私有化构造函数
 * 2.需要构建的参数
 */
class House private constructor(builder: Builder) {
    internal var window: String? = null
    internal var stone: String? = null
    internal var door: String? = null
    internal var wood: String? = null

    init {
        window = builder.window
        stone = builder.stone
        door = builder.door
        wood = builder.wood
    }


    class Builder {
        internal var window: String? = null
        private set
        internal var stone: String? = null
        private set
        internal var door: String? = null
        private set
        internal var wood: String? = null
        private set
        
        fun setWindow(window: String?)=apply { 
            this.window=window
        }
        

        fun setStone(stone: String?)=apply {
            this.stone=stone
        }

        fun setDoor(door: String?)=apply {
            this.door=door
        }

        fun setWood(wood: String?)=apply {
            this.wood=wood
        }


        fun builder()=House(this)
    }


}