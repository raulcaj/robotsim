#!/bin/bash

for testFile in $(ls test*)
do
        grep -v '#' $testFile | java -jar ../bin/robotsim.jar
done
