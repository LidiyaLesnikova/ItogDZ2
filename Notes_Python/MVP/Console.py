from MVP.Presenter import Presenter

class Console:
    presenter: Presenter = Presenter()

    def menu(self):
        print("выбрать пункт меню:")
        print(self.presenter.menu())
