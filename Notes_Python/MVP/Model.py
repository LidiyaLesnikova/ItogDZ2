from MVP.DataBase.NotesList import NotesList
from MVP.DataBase.FileHandler import FileHandler
from MVP.DataBase.Note import Note
from datetime import datetime

class Model:
    notelist: NotesList = NotesList()
    fileHandler: FileHandler

    def __init__(self, notelist_file: str) -> None:
        self.fileHandler = FileHandler(notelist_file)
        self.createNotelist()

    def createNotelist(self) -> None:
        for i in self.fileHandler.read():
            str = i.replace('\n','').split(';')
            self.notelist.append_note(Note(int(str[0]), str[1], str[2], datetime.strptime(str[3],'%Y-%m-%d %H:%M:%S')))

    def filterNote(self, numberNote: int, dataNote: datetime):
        notelist = self.notelist.filter_note(numberNote, dataNote)
        return ["Заметок нет"] if len(notelist)==0 else notelist

    def getDateFilter(self, yearFilter: int, monthFilter: int, dayFilter: int):
        return datetime(yearFilter, monthFilter, dayFilter)

    def insertNote(self, heading, text_note) -> str:
        try:
            id = 1 if self.notelist.getSize()==0 else self.notelist.getNotesList()[-1].id+1
            time_change = datetime.now()
            self.notelist.append_note(Note(id, heading, text_note, time_change))
            self.fileHandler.add_data(str(id)+';'+heading+';'+text_note+';'+time_change.strftime('%Y-%m-%d %H:%M:%S')+'\n')
            rez = "Заметка успешно добавлена"
        except:
            rez = "Ошибка, не удалось сохранить заметку"
        return rez
    
    def searchNote(self, searchNote: str) -> str:
        rez = []
        for i in self.notelist.getNotesList():
            if searchNote.upper() in i.__repr__().upper():
                rez.append(i)
        if len(rez)==0:
            rez.append('Запись не найдена')
        return rez
    
    def modifyNote(self, modifyLine: int, newHeading: str, newText_note: str, time_change = datetime.now()) -> str:
        self.fileHandler.remove()
        rez = ""
        for i in tuple(self.notelist.getNotesList()):
            if modifyLine==i.id:
                i.setHeading(newHeading)
                i.setText(newText_note)
                i.setTime(time_change)
                self.fileHandler.add_data(str(i.id)+';'+newHeading+';'+newText_note+';'+time_change.strftime('%Y-%m-%d %H:%M:%S')+'\n')
                rez = rez + "Заметка "+str(i.id)+" отредактирована. "
            else:
                self.fileHandler.add_data(str(i.id)+';'+i.heading+';'+i.text_note+';'+i.time_change.strftime('%Y-%m-%d %H:%M:%S')+'\n')
        return 'Запись не найдена' if rez=="" else rez
    
    def removeNote(self, removeLine: int) -> str:
        self.fileHandler.remove()
        rez = ""
        for i in tuple(self.notelist.getNotesList()):
            if removeLine==i.id:
                self.notelist.remove_note(i)
                rez = rez + "Заметка "+str(i.id)+" удалена. "
            else:
                self.fileHandler.add_data(str(i.id)+';'+i.heading+';'+i.text_note+';'+i.time_change.strftime('%Y-%m-%d %H:%M:%S')+'\n')
        return 'Запись не найдена' if rez=="" else rez
