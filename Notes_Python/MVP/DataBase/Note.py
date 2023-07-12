from datetime import datetime

class Note:
    id: int
    heading: str
    text_note: str
    time_change: datetime

    def __init__(self, id: int, heading: str, text_note: str, time_change: datetime) -> None:
        self.id = id
        self.heading = heading
        self.text_note = text_note
        self.time_change = time_change

    def getHeading(self) -> str:
        return self.heading
    
    def getText(self) -> str:
        return self.text_note
    
    def setHeading(self, heading) -> str:
        self.heading = heading
    
    def setText(self, text_note) -> str:
        self.text_note = text_note
    
    def setTime(self, time_change) -> str:
        self.time_change = time_change

    def __repr__(self) -> str:
        return f'{self.id}) {self.time_change.strftime("%d.%m.%Y %H:%M")}: {self.heading}\n{self.text_note}\n'

