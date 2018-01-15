package lee.study.di

interface Heater {

    fun on()

    fun off()

    fun isHot(): Boolean

}

interface Pump {

    fun pump()

}

class CoffeeMaker(
        private val heater: Heater,
        private val pump: Pump
) {

    fun brew() {
        heater.on()
        pump.pump()
        println(" [_]P coffee! [_]P ")
        heater.off()
    }

}

class A_Heater : Heater {

    private var heating: Boolean = false

    override fun on() {
        println("A_Heater : ~ ~ ~ heating ~ ~ ~")
        heating = true
    }

    override fun off() {
        heating = false
    }

    override fun isHot(): Boolean = heating

}

class A_Pump(
        private val heater: Heater
) : Pump {

    override fun pump() {
        if (heater.isHot())
            println("A_Pump => => pumping => =>")
    }

}
