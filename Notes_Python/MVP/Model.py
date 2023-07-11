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

    def viewNotes(self) -> str:
        notelist = self.notelist.getNotesList()
        return ["Записная книжка пустая"] if len(notelist)==0 else notelist
    
    def insertNote(self, heading, text_note, time_change) -> str:
        try:
            id = 1 if len(self.notelist.getNotesList())==0 else self.notelist.getNotesList()[len(self.notelist.getNotesList())-1].id+1
            self.notelist.append_note(Note(id, heading, text_note, time_change))
            self.fileHandler.save(str(id)+';'+heading+';'+text_note+';'+time_change.strftime('%Y-%m-%d %H:%M:%S')+'\n')
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
    
    def modifyNote(self, modifyLine: int, mode = 0) -> str:
        return ""