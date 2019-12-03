
def generate_wire_course(commands):
    path = []
    path_cursor = -1
    for direction, length in commands:
        for i in range(length):
            y, x = path[path_cursor + i] if bool(path) else (0, 0)
            path.append(
                (y + y_direction[direction], x + x_direction[direction]))
        path_cursor += length
    return path

with open('input.txt', 'r') as file:
    x_direction = {'L': -1, 'R': 1, 'U': 0, 'D': 0}
    y_direction = {'L': 0, 'R': 0, 'U': 1, 'D': -1}
    paths = []
    for line in file.readlines():
        tuple_list = [(x[:1], int(x[1:])) for x in line.strip().split(',')]
        path = generate_wire_course(tuple_list)
        paths.append(path)

    answer_1 = min([abs(p[0]) + abs(p[1]) for p in set(paths[0]).intersection(set(paths[1]))])
    answer_2 = min([paths[0].index(p) + paths[1].index(p) for p in set(paths[0]).intersection(set(paths[1]))]) + 2 #since the index starts at 0 we need +1 for both wires

    print('The first answer is: %d' % answer_1)
    print('The second answer is: %d' % answer_2)