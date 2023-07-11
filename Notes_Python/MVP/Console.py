from MVP.Presenter import Presenter
from datetime import datetime

class Console:
    presenter: Presenter

    def __init__(self, notelist_file: str) -> None:
        self.presenter = Presenter(notelist_file)

    def menu(self):
        print('Введите действие:\n',
            '1 - просмотреть все заметки в записной книжке \n',
            '2 - добавить новую заметку \n',
            '3 - найти заметку в записной книжке \n',
            '4 - редактировать заметку в записной книжке \n',
            '5 - удалить заметку из записной книжки \n',
            '===================================== \n',
            '6 - закончить работу с записной книжкой \n')

        while True:
            try:
                anser = int(input('Ввод действия с записной книжкой: '))
                match anser:
                    case 1: # просмотр записной книжки
                        print(*self.presenter.viewNotes())
                    case 2: # добавить заметку
                        heading, text_note, time_change = self.InsertNote()
                        print(self.presenter.insertNote(heading, text_note, time_change))
                    case 3: # найти заметку
                        print(self.presenter.searchNote())
                    case 4: # редактировать заметку
                        try:
                            modifyLine = int(input('Введите ID, который надо изменить: '))
                            print(self.presenter.modifyNote(modifyLine))
                        except:
                            print("Такой записи не существует")                
                    case 5: # удалить заметку
                        try:
                            deleteLine = int(input('Введите ID, который надо удалить: '))
                            print(self.presenter.modifyNote(deleteLine, 1))
                        except:
                            print("Такой заметки не существует")
                    case 6: # выход
                        print('До свидания')
                        break
                    case _:
                        print('ошибка ввода данных, введите число от 1 до 6')
            except:
                print('ошибка ввода типа данных, введите заново')

    def InsertNote(self):
        print('Введите заметку: ')
        heading = input('Заголовок: ')
        text_note = input('Текст: ')
        time_change = datetime.now()
        return heading , text_note, time_change