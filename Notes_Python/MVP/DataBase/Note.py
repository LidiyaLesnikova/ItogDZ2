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

    def __repr__(self) -> str:
        return f'{self.id}) {self.time_change.strftime("%d.%m.%Y %H:%M")}: {self.heading}\n{self.text_note}\n'

