class Model:
    path: str

    def __init__(self) -> None:
        self.path = "./ToyStore_Java/ToyStore.txt"

    def menu(self):
        return self.path