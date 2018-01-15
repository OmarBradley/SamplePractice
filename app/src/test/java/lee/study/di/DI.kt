package lee.study.di

import lee.study.di.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class DI : Spek({

    given("DI 예제 ") {

        it("DI를 사용하지 않은 상태") {
            val heater: Heater = A_Heater()
            val pump: Pump = A_Pump(heater)
            val coffeeMaker = CoffeeMaker(heater, pump)
            coffeeMaker.brew()

            /*
            coffeeMaker 객체를 만드려면 사용자가 A_Heater, A_Pump 라는 구현체를 알아야 한다
             */
        }

        it("Injection 클래스를 사용한다면") {
            val coffeeMaker = Injection.provideCoffeeMaker()
            coffeeMaker.brew()

            /*
            coffeeMaker 객체를 만드는 것은 Injection 클래스 안에서 처리 한다
            -> coffeeMaker는 A_Heater, A_Pump 라는 구현체를 몰라도 된다
             */
        }

        on("이 둘을 비교한다면?") {

        }

    }

})
