from MVP.Model import Model

class Presenter:
    model: Model = Model()

    def menu(self):
        return self.model.menu()