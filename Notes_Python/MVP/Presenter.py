from MVP.Model import Model

class Presenter:
    model: Model

    def __init__(self, notelist_file: str) -> None:
        self.model = Model(notelist_file)

    def viewNotes(self):
        return self.model.viewNotes()
    
    def insertNote(self, heading, text_note, time_change):
        return self.model.insertNote(heading, text_note, time_change)
    
    def searchNote(self):
        return self.model.searchNote()
    
    def modifyNote(self, modifyLine: int, mode = 0):
        return self.model.modifyNote(modifyLine, mode)