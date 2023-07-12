from MVP.Model import Model

class Presenter:
    model: Model

    def __init__(self, notelist_file) -> None:
        self.model = Model(notelist_file)
  
    def insertNote(self, heading, text_note):
        return self.model.insertNote(heading, text_note)
    
    def searchNote(self, searchNote):
        return self.model.searchNote(searchNote)
    
    def modifyNote(self, modifyLine, newHeading, newText_note):
        return self.model.modifyNote(modifyLine, newHeading, newText_note)
    
    def removeNote(self, removeLine):
        return self.model.removeNote(removeLine)
    
    def filterNote(self, modifyLine=-1, dataNote = None):
        return self.model.filterNote(modifyLine, dataNote)
    
    def getDateFilter(self, yearFilter, monthFilter, dayFilter):
        return self.model.getDateFilter(yearFilter, monthFilter, dayFilter)