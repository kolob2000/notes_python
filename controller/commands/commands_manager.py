import abc

from model.model import Initializer


class Command(abc.ABC):
    @classmethod
    @abc.abstractmethod
    def title(cls):
        pass

    @staticmethod
    @abc.abstractmethod
    def command(*args, **kwargs):
        pass


class CommandManager:
    commands = {}

    def add_command(self, command: Command):
        self.commands.setdefault(command.title, command.command)

    def get_command(self, nl, title, *args, **kwargs):
        if title in self.commands:
            try:
                self.commands[title](nl, *args, *kwargs)
            except TypeError:
                print('Ошибка! Не верный формат команды.')

        else:
            print('Нет такой команды. Повторите выбор.')


class ListCommand(Command, abc.ABC):
    __title = 'list'

    @staticmethod
    def command(nl, *args, **kwargs):
        nl.print_list()

    @classmethod
    @property
    def title(cls):
        return cls.__title


class AddCommand(Command, abc.ABC):
    __title = 'add'

    @staticmethod
    def command(nl, *args, **kwargs):
        nl.add(*args)
        Initializer.dump(nl, 'notes.json')

    @classmethod
    @property
    def title(cls):
        return cls.__title


class UpdateCommand(Command, abc.ABC):
    __title = 'edit'

    @staticmethod
    def command(nl, *args, **kwargs):
        nl.update(args[0], dict(zip(args[1::2], args[2::2])))
        Initializer.dump(nl, 'notes.json')

    @classmethod
    @property
    def title(cls):
        return cls.__title


class RemoveCommand(Command, abc.ABC):
    __title = 'del'

    @staticmethod
    def command(nl, *args, **kwargs):
        nl.delete_one(args[0])
        Initializer.dump(nl, 'notes.json')

    @classmethod
    @property
    def title(cls):
        return cls.__title
