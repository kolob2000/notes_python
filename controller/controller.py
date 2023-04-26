from controller.commands.commands_manager import CommandManager, ListCommand, AddCommand, UpdateCommand, RemoveCommand
from model.model import NoteList, Initializer
from view.view import main_menu


def init():
    note_list = NoteList()
    Initializer.load(note_list, 'notes.json')
    cm = CommandManager()
    cm.add_command(ListCommand())
    cm.add_command(AddCommand())
    cm.add_command(UpdateCommand())
    cm.add_command(RemoveCommand())
    main_menu(cm, note_list)


if __name__ == '__main__':
    pass
