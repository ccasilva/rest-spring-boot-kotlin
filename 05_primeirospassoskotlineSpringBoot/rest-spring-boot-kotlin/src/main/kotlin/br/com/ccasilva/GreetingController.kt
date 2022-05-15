package br.com.ccasilva

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {
    val counter: AtomicLong = AtomicLong()

    /*
        http://localhost:8080/greeting
        http://localhost:8080/greeting?name=Carlos
     */

    //Mapeia uma requisicao para esse cara
    @RequestMapping("/greeting")
    fun grreting(@RequestParam(value = "name", defaultValue = "Word") name: String?): Greeting{
        return Greeting(counter.incrementAndGet(), content = "Hello, $name!")
    }
}