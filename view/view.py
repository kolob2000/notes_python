from model.model import Initializer


def main_menu(cm, nl):
    while True:
        print('Выберите команду:\n'
              '| add title description - добавить '
              '| edit id key val [key val] - изменить '
              '| del id - удалить '
              '| list - вывести список '
              '| exit - выход |')
        command = list(map(lambda x: x.lower().strip(), input().split()))
        if command[0] == 'exit':
            Initializer.dump(nl, 'notes.json')
            exit(1)
        else:
            cm.get_command(nl, command[0], *command[1:])

if __name__ == '__main__':
    pass
