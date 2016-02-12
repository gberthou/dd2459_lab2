from common import *
import sys
import os
import subprocess

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
    nPassed = 0
    nTests = 0
    for i,line in enumerate(f):
        values = line.split(" ")
        array          = values[:ARRAY_SIZE]
        key            = values[ARRAY_SIZE]
        expectedResult = int(values[ARRAY_SIZE + 1])
        
        command = ["java", "-cp", "../bin", BIN, version, str(ARRAY_SIZE)]
        command.extend(array)
        command.append(key)
        
        print("[Test %d]" % i)
        print(" ".join(command))
        
        result = subprocess.run(command, stdout=subprocess.PIPE)
        out = int(result.stdout)
        if out == expectedResult:
            print("PASSED")
            nPassed += 1
        else:
            print("FAILED")
            print("  expected: %d" % expectedResult)
            print("  real    : %d" % out)
        print("")
        nTests = i+1
    print("%d/%d passed (%.1f%%)" % (nPassed, nTests, 100.*nPassed/nTests))

