JAVA_FILES=$(wildcard src/*.java)
CLASS_FILES=$(patsubst src/%.java,bin/%.class,$(JAVA_FILES))

default: $(JAVA_FILES)
	javac $(JAVA_FILES) -d bin/
