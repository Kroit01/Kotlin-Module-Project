import java.util.Scanner
class MenuScreen(
val title: String,
val list: List<MenuItem>
){
    fun showMenu(){
        while (true){ // бесконечный цикл
            println(title)
            for (i in list.indices) {
                println("$i. ${list[i].name}")
            }
        val input = Scanner(System.`in`).nextLine()
        val number = input.toIntOrNull()
                if (number == null) {
                    println("Введите цифру")
                } else if (number !in list.indices) {
                    println("Такой цифры нет")
                } else {
                   list[number].action()
                    if (number == list.size -1) return

                }

        }
    }
}