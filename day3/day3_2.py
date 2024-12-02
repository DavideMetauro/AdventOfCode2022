file=open("inputday3.txt","r")
i=0

while i<(len(file)\\3):
    lines=file.readLines(3)
    for el in lines:
        el.sort()
        print el
