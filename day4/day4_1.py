import time

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

file=open("/Users/davidemetauro/Documents/Advent/input_4.txt",'r')
c=0
for line in file:
    elfa, elfb = line.split(',')
    mina, maxa= elfa.split('-')
    minb, maxb= elfb.split('-')
    mina=int(mina)
    minb=int(minb)
    maxa=int(maxa)
    maxb=int(maxb)
    if (mina <= minb and maxa >= maxb) or ( minb <= mina and maxb >= maxa):
        c+=1
print(c)





end_time = time.time()
print("--- {} ---".format(approx(end_time - start_time)))
