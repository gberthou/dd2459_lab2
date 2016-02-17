from common import *
import sys
import os
import subprocess

BIN = "Main"
LATEX_OUT = "comparison.tex"

# Returns the number of passed tests before the first failed one
# Returns -1 if all tests were passed
def performTest(testfilename, version, stopWhenFailed, verbose):
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
            
            if verbose or (i % 1000) == 0:
                print("[Test %d]" % i)
                print(" ".join(command))
            
            result = subprocess.run(command, stdout=subprocess.PIPE)
            out = int(result.stdout)
            if out == expectedResult:
                if verbose:
                    print("PASSED")
                nPassed += 1
            else:
                print("FAILED")
                print("  expected: %d" % expectedResult)
                print("  real    : %d" % out)
                
                if stopWhenFailed:
                    return i
            if verbose:
                print("")
            nTests = i+1
        print("%d/%d passed (%.1f%%)" % (nPassed, nTests, 100.*nPassed/nTests))
    return -1

"""
Test file format:

<Array values separated by a whitespace> <key to search> <expected output value>

"""

argc = len(sys.argv)
if argc != 1 and argc != 3:
    print(argc)
    print("Usage: python oracle.py testFile softwareVersion")
    print("  Performs the given test to the given version of software")
    print("       python oracle.py")
    print("  Performs random and pairwise tests to all versions of software")
    sys.exit(0)

if argc == 1:
    testfiles = ["pairwiseTest", "randomTest"]
    versions = [str(i) for i in range(1, 6)]

    with open(LATEX_OUT, "w") as f:
        f.write("""\\begin{tabular}[|c|c|c|]
\hline \\
Version & Pairwise testing & Random testing \\
\hline \\
""")
        for nversion, version in enumerate(versions):
            f.write("Version %d" % nversion)
            for testfilename in testfiles:
                print("[[%s/%s]]" % (version, testfilename))
                n = performTest(testfilename, version, True, False)
                f.write(" & %d" % n)
            f.write(" \\\\\n")
        f.write("""\end{tabular}""")
            
else:
    testfilename = sys.argv[1]
    version = sys.argv[2]
    performTest(testfilename, version, False, True)

