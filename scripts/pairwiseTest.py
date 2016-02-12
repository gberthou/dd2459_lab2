from common import *

OUTPUT_NAME = "pairwiseTest"

ITERATIONS_COUNT = (MAX_VALUE+1) ** (ARRAY_SIZE+1)
ITERATIONS_PERCENT = int(ITERATIONS_COUNT / 100)

def nextArray(t):
    u = list(t)
    i = len(u)-1
    while i >= 0:
        u[i] += 1
        if u[i] > MAX_VALUE:
            u[i] = 0
            i -= 1
        else:
            return u
    return None

array = [0 for i in range(ARRAY_SIZE)]
print("%d iterations" % ITERATIONS_COUNT)
cpt = 0
with open(OUTPUT_NAME, "w") as f:
    while array != None:
        for j in range(MAX_VALUE+1):
            expectedResult = (j in array)

            t = [str(x) for x in array]
            t.append(str(j))
            if expectedResult:
                t.append("1")
            else:
                t.append("0")
            f.write(" ".join(t) + "\n")
            
            if (cpt % ITERATIONS_PERCENT) == 0:
                print("%02d%%" % (cpt / ITERATIONS_PERCENT))
            cpt += 1
        array = nextArray(array)
        
