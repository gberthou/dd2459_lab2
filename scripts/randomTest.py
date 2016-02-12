from random import randint

TEST_COUNT = 200
ARRAY_SIZE = 10
MAX_VALUE = 16
OUTPUT_NAME = "randomTest"

with open(OUTPUT_NAME, "w") as f:
    for j in range(TEST_COUNT):
        t = [str(randint(0, MAX_VALUE)) for i in range(ARRAY_SIZE)]
        t.append(str(randint(0, ARRAY_SIZE - 1)))
        f.write(" ".join(t) + "\n")

