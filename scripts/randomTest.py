from common import *
from random import randint

TEST_COUNT = 200
OUTPUT_NAME = "randomTest"

with open(OUTPUT_NAME, "w") as f:
    for j in range(TEST_COUNT):
        numt = [randint(0, MAX_VALUE) for i in range(ARRAY_SIZE)]
        key = randint(0, MAX_VALUE)
        expectedResult = (key in numt)

        t = [str(x) for x in numt]
        t.append(str(key))
        if expectedResult:
            t.append("1")
        else:
            t.append("0")
        f.write(" ".join(t) + "\n")

