from MVP.Presenter import Presenter

class View:
    presenter: Presenter

    def __init__(self, notelist_file: str) -> None:
        self.presenter = Presenter(notelist_file)

    def menu(self):
         while True:
            print('\n',
                '1 - просмотреть все заметки в записной книжке \n',
                '2 - добавить новую заметку \n',
                '3 - найти заметку в записной книжке \n',
                '4 - редактировать заметку в записной книжке \n',
                '5 - удалить заметку из записной книжки \n',
                '6 - выбрать все заметки за дату \n',
                '===================================== \n',
                '0 - закончить работу с записной книжкой')
            try:
                choice = int(input('Введите действие с записной книжкой: '))
                match choice:
                    case 1: # просмотр записной книжки
                        print(*self.presenter.filterNote(-1,None))
                    case 2: # добавить заметку
                        heading, text_note = self.insertNote()
                        print(self.presenter.insertNote(heading, text_note))
                    case 3: # найти заметку
                        searchNote = input('Введите строку поиска в записной книжке: ')
                        print(*self.presenter.searchNote(searchNote))
                    case 4: # редактировать заметку
                        modifyLine = int(input('Введите номер заметки, которую надо редактировать: '))
                        try:
                            newHeading, newText_note = self.modifyNote(modifyLine)
                            print(modifyLine, newHeading, newText_note)
                            print(self.presenter.modifyNote(modifyLine, newHeading, newText_note)) 
                        except:
                            print("Заметка",modifyLine,"не найдена")         
                    case 5: # удалить заметку
                        removeLine = int(input('Введите номер заметки, которую надо удалить: '))
                        print(self.presenter.removeNote(removeLine))
                    case 6: # выбрать заметки за дату
                        dataFilter = self.insertData()
                        print(*self.presenter.filterNote(-1, dataFilter))
                    case 0: # выход00
                        print('\nДо свидания')
                        break
                    case _:
                        print('ошибка ввода данных, введите число от 0 до 6')
            except:
                print('ошибка ввода типа данных, введите заново')

    def insertNote(self):
        print('Введите заметку: ')
        heading = input('Заголовок: ')
        text_note = input('Текст: ')
        return heading , text_note
    
    def modifyNote(self, modifyLine):
        old_note = self.presenter.filterNote(modifyLine)
        newHeading = input('Изменить заголовок ('+old_note[0].getHeading()+'): ')
        newText_note = input('Изменить текст заметки ('+old_note[0].getText()+'): ')
        return newHeading, newText_note
    
    def insertData(self):
        while True:
            try:
                print('Введите за какую дату нужны заметки:')
                dayFilter = monthFilter = yearFilter = 0
                while (dayFilter<1 or dayFilter>31):
                    dayFilter = int(input('день (1-31): '))
                while (monthFilter<1 or monthFilter>12):
                    monthFilter = int(input('месяц (1-12): '))
                while (yearFilter<1000 or yearFilter>9999):
                    yearFilter = int(input('год (xxxx): '))
                dataFilter = self.presenter.getDateFilter(yearFilter, monthFilter, dayFilter)
                break
            except:
                print('ошибка ввода данных, введите заново')
        return dataFilter