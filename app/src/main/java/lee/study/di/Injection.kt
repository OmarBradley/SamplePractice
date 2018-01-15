package lee.study.di

class Injection {

    companion object {

        fun provideHeater(): Heater = A_Heater()

        fun providePump(): Pump = A_Pump(provideHeater())

        fun provideCoffeeMaker(): CoffeeMaker = CoffeeMaker(provideHeater(), providePump())

    }

}
