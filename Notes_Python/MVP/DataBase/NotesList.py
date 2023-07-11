from MVP.DataBase.Note import Note

class NotesList:
    notes_list: list[Note]

    def __init__(self) -> None:
        self.notes_list = []

    def getNotesList(self):
        return self.notes_list

    def append_note(self, note: Note) -> None:
        self.notes_list.append(note)

    def remove_note(self, note: Note) -> None:
        self.notes_list.remove(note)

    def select_all_note(self) -> str:
        output: str = ""
        for d in self.notes_list:
            output += f'{d.heading}\n'
        return output

    '''''
    def report(self) -> list[tuple]:
        rep: list[tuple] = []
        for w in self.notes_list:
            rep.append((w.heading, w.text_note, ))
        return rep
    '''
