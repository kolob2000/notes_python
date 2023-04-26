import datetime as d
import json


class Note:
    def __init__(self, _id, title, description, create_time='', update_time=''):
        self.__id = _id
        self.title = title
        self.description = description
        self.create_time = create_time if create_time else str(d.datetime.now())
        self.update_time = update_time if update_time else str(d.datetime.now())

    def __str__(self) -> str:
        return f'| {self.__id} ' \
               f'| {self.title} ' \
               f'| {self.description} ' \
               f'| {self.create_time} ' \
               f'| {self.update_time} |'

    def update(self, data: dict) -> None:
        if len(data) > 2 or len(data) == 0:
            print('Ошибка. Неверный формат данных.')
            return None

        for key in data.keys():
            if key == 'title' or key == 'description':
                pass
            else:
                print('Ошибка. Неверный формат данных.')
                return None

        for key, value in data.items():
            self.__dict__[f'{key}'] = value
            self.update_time = str(d.datetime.now())  # if dict is empty no update time

    def get(self):
        return {'title': self.title,
                'description': self.description,
                'create_time': self.create_time,
                'update_time': self.update_time
                }


class NoteList:
    count = 0

    @staticmethod
    def get_count():
        NoteList.count += 1
        return NoteList.count

    @staticmethod
    def set_count(count):
        NoteList.count = count

    note_list = {}

    def initialize(self, data):
        _id = NoteList.get_count()
        self.note_list.setdefault(_id, Note(_id, **data))

    def add(self, title, description):
        _id = NoteList.get_count()
        self.note_list.setdefault(_id, Note(_id, title, description))

    def update(self, _id, data: dict):
        try:
            note: Note = self.note_list.get(int(_id))
            if note:
                note.update(data)
            else:
                raise KeyError
        except KeyError:
            print('Ошибка. Запись с таким id не существует.')

    def print_list(self):
        for i in self.note_list.values():
            print(i)

    def print_one(self, _id):
        print(self.note_list[int(_id)])

    def delete_one(self, _id):
        del self.note_list[int(_id)]

    def clear_all(self):
        self.note_list.clear()

    def convert_to_dict(self):
        d = {}
        for key, value in self.note_list.items():
            d.setdefault(key, value.get())
        return d


class Initializer:
    @staticmethod
    def dump(note_list: NoteList, file_name: str) -> None:
        with open(file_name, 'w') as f:
            json.dump(note_list.convert_to_dict(), f)

    @staticmethod
    def load(note_list: NoteList, file_name: str):
        try:
            with open(file_name, 'r') as f:
                for i in json.load(f).values():
                    note_list.initialize(i)
        except FileNotFoundError:
            print("Файл не найден. Возможно первый запуск.")


if __name__ == '__main__':
    pass
