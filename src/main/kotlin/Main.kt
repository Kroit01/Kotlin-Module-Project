import java.util.Scanner
fun main() {
    val archives: MutableList<Archive> = mutableListOf()
    val mainMenuSteps = mutableListOf<MenuItem>()
    // создаем первую кнопку 0. Создать архив
    mainMenuSteps.add(
        MenuItem("Создать архив") {
            println("Введите название архива.")
            val name = Scanner(System.`in`).nextLine()
            if (name.isBlank()) {
                println("Имя не может быть пустым")
            } else {
                val newArchive = Archive(name)
                archives.add(newArchive)


                // Созданный архив будет перед кнопкой Выход
                mainMenuSteps.add(
                    mainMenuSteps.size - 1,
                    MenuItem(name) {
                        // меню заметок
                        val noteMenuSteps = mutableListOf<MenuItem>()

                        // кнопка создать заметку
                        noteMenuSteps.add(MenuItem("Создать заметку") {
                            println("Введите название заметки:")
                            val noteName = Scanner(System.`in`).nextLine()

                            if (noteName.isBlank()) {
                                println("Имя не может быть пустым")
                            } else {
                                println("Введите текст заметки.")
                                val textNote = Scanner(System.`in`).nextLine()

                                if (textNote.isBlank()) {
                                    println("Имя не может быть пустым")
                                } else {
                                    val newNote = Note(noteName, textNote)
                                    newArchive.notes.add(newNote)

                                    //Кнопка проверить заметку

                                    noteMenuSteps.add(
                                        noteMenuSteps.size - 1,
                                        MenuItem(noteName) {
                                            println("Заметка: $noteName")
                                            println("Текст: $textNote")
                                        })
                                }
                            }
                        }) // конец кнопки создания заметок

                        // Кнопка Назад
                                noteMenuSteps.add(MenuItem("Назад") {})

                        //запуск экрана заметок
                                val notesScreen = MenuScreen("ЗАМЕТКИ АРХИВА: $name", noteMenuSteps)
                                notesScreen.showMenu()
                            })
                        }
                    }) // конец кнопки создать архив
    // Кнопка выход
    mainMenuSteps.add(MenuItem("Выход") {
        println("До свидания!")
        System.exit(0)
    })

    // запуск главного экран
    val mainScreen = MenuScreen("СПИСОК АРХИВОВ", mainMenuSteps)
    mainScreen.showMenu()

}

