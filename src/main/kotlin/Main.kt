fun main() {
    val choices = listOf("Камень", "Ножницы", "Бумага")

    println("Добро пожаловать в игру 'Камень-Ножницы-Бумага'!")

    while (true) {
        val computerChoice = choices.random()
        print("Выберите ваш ход (Камень, Ножницы, Бумага): ")
        val userChoice = readln()?.capitalize()

        if (userChoice in choices) {
            println("Компьютер выбрал: $computerChoice")
            println("Вы выбрали: $userChoice")

            val result = determineWinner(computerChoice, userChoice)
            println(result)
        } else {
            println("Неверный выбор. Пожалуйста, выберите Камень, Ножницы или Бумагу.")
        }

        print("Хотите сыграть еще раз? (да/нет): ")
        val playAgain = readLine()?.equals("да", ignoreCase = true) ?: false

        if (!playAgain) {
            println("Спасибо за игру!")
            break
        }
    }
}

fun determineWinner(computerChoice: String, userChoice: String): String {
    return when {
        computerChoice == userChoice -> "Ничья!"
        (computerChoice == "Бумага" && userChoice == "Камень") ||
                (computerChoice == "Камень" && userChoice == "Ножницы") ||
                (computerChoice == "Ножницы" && userChoice == "Бумага") -> "Компьютер победил!"
        else -> "Вы победили!"
    }
}