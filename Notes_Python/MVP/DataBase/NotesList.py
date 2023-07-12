from MVP.DataBase.Note import Note

class NotesList:
    notes_list: list[Note]

    def __init__(self) -> None:
        self.notes_list = []

    def getNotesList(self):
        return self.notes_list

    def getSize(self):
        return len(self.notes_list)
    
    def append_note(self, note: Note) -> None:
        self.notes_list.append(note)

    def remove_note(self, note: Note) -> None:
        self.notes_list.remove(note)
    
    def filter_note(self, numberNote, dataNote):
        return [x for x in self.notes_list if (x.id==numberNote and numberNote!=-1) or (dataNote!=None and x.time_change==dataNote)]
