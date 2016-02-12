from common import *
import sys
import os

BIN = "Main"

"""
Test file format:

<Array values separated by a whitespace> <key to search> <expected output value>

"""

if len(sys.argv) < 3:
    print("Usage: python oracle.py testFile softwareVersion")
    sys.exit(0)

testfilename = sys.argv[1]
version = sys.argv[2]

with open(testfilename, "r") as f:
    for i,line in enumerate(f):
        values = line.split(" ")
        array          = values[:ARRAY_SIZE]
        key            = values[ARRAY_SIZE]
        expectedResult = values[ARRAY_SIZE + 1]
        
        command = "cd ../bin && java %s %s %d %s %s" % (BIN, version, ARRAY_SIZE, " ".join(array), key)
        print("[Test %d]" % i)
        print(command)
        os.system(command)

