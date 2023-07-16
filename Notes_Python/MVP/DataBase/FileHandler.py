import os

# класс по работе с внешним файлом
class FileHandler:
    notelist_file: str

    def __init__(self, notelist_file: str) -> None:
        self.notelist_file = notelist_file

    # читать данные из файла (возвращает список с данными)
    def read(self):
        dataBase = []
        try:
            with open(self.notelist_file, 'r', encoding="utf-8") as data:
                lines = data.readlines()
                if len(lines)>2:
                    for i in range(1,len(lines)):
                        dataBase.append(lines[i])
        except:
            with open(self.notelist_file, 'w', encoding="utf-8") as data:
                data.writelines('id;heading;text_note;time_change\n')
        return dataBase

    # добавить данные с файл
    def add_data(self, note: str):
        with open(self.notelist_file, 'a', encoding="utf-8") as data:
            data.writelines(note)

    # удалить файл с данными
    def remove(self):
        if os.path.isfile(self.notelist_file): 
            os.remove(self.notelist_file) 
        self.read()
 
