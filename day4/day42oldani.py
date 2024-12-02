import time

def part1():
    with open("/Users/davidemetauro/Documents/Advent/input_4.txt", "r") as f:
        couples = list(map(lambda x : x.strip().split(","), f.readlines()))

    overlap = 0
    for couple in couples:
        first = list(map(int, couple[0].split("-")))
        second = list(map(int, couple[1].split("-")))
        all = [x for x in range(first[0], first[1]+1)]
        all.extend([x for x in range(second[0], second[1]+1)])
        no_dup = set(all)
        if len(all) != len(no_dup):
            overlap += 1

    print(overlap)

def approx(seconds: float):
    if seconds <= 0:
        return str(seconds)+"s"

    notation = ["s", "ms", "µs", "ns"]
    i = 0
    while seconds < 1:
        seconds *= 1000
        i += 1
    return str(seconds)+notation[i]

start_time = time.time()
part1()
end_time = time.time()
print("--- {} ---".format(approx(end_time - start_time)))
