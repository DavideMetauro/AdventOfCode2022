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
file=open("/Users/davidemetauro/Documents/Advent/inputday3.txt","r")
a=0
f=0
for line in file:
    l = list(line.rstrip())
    p1, p2 = l[:len(l)//2], l[len(l)//2:]
    i = 0
    while i<len(p1):
        j=0;
        while j<len(p2):
            if p1[i]==p2[j]:
                if p1[i].islower():
                    a+=ord(p1[i])-96
                else:
                    a+=ord(p1[i])-38
                f=1
                break
            j+=1
        if f:
            f=0
            break
        i+=1
print(a)
end_time = time.time()
print("--- {} ---".format(approx(end_time - start_time)))

