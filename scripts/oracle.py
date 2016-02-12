from common import *
import sys

"""
Test file format:

<Array values separated by a whitespace> <key to search> <expected output value>

"""

if len(sys.argv) < 2:
    print("Usage: python oracle.py testFile")
    sys.exit(0)

testfilename = sys.argv[1]
with open(testfilename, "r") as f:
    for line in f:
        values = line.split(" ")
        array          = values[:ARRAY_SIZE]
        key            = values[ARRAY_SIZE]
        expectedResult = values[ARRAY_SIZE + 1]

