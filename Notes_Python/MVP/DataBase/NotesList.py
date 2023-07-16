from MVP.DataBase.Note import Note

# класс список заметок
class NotesList:
    notes_list: list[Note]

    def __init__(self) -> None:
        self.notes_list = []

    # получить список заметок
    def getNotesList(self):
        return self.notes_list

    #получить размер списка заметок
    def getSize(self):
        return len(self.notes_list)
    
    # добавить заметку
    def append_note(self, note: Note) -> None:
        self.notes_list.append(note)

    # удалить заметку
    def remove_note(self, note: Note) -> None:
        self.notes_list.remove(note)
    
    # полусить фильтрованный список заметок
    def filter_note(self, numberNote, dataNote):
        return [x for x in self.notes_list if (x.id==numberNote and numberNote!=-1) or (dataNote!=None and x.time_change.date()==dataNote.date()) or (numberNote==-1 and dataNote==None)]
