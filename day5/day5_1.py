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

file=open("/Users/davidemetauro/Documents/Advent/input_5.txt",'r')
stack[0]="vcdrzgbw"
stack[1]="gwfcbstv"
stack[2]="cbsnw"
stack[3]="qgmnjvcp"
stack[4]="tslfdhb"
stack[5]="jvtwmn"
stack[6]="pflcstg"
stack[7]="bdz"
stack[8]="mnzw"

for i in range(0,8):
    l[i]=list(stack[i].rstrip())
for line in file:
    s=line.split(" ")
    n,f,t=s[1],s[3],s[5]
    for i in range(0,n-1):
        stack[t].add(len,stack[f].last)
        stack[f].remove(last)



end_time = time.time()
print("--- {} ---".format(approx(end_time - start_time)))
