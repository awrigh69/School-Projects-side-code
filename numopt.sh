#!/bin/bash
#
# Lab Assignment #6
#
# Your name:
# 
# By turning in this code, I Pledge:
# That I have completed the programming assignment independently.
# I have not copied the code from a student or any source.
# I have not given my code to any student.

add() {
    result=$(( numb1 + numb2 ))
    echo "$numb1 + $numb2 = $result"
}

difference() {
    result=$(( numb1 - numb2 ))
    echo "$numb1 - $numb2 = $result"
}

multiply() {
    result=$(( numb1 * numb2 ))
    echo "$numb1 x $numb2 = $result"
}

divide() {

    if [ "$numb2" -eq 0 ]; then
        echo "Zero is not divisible."
    else
        result=$(( numb1 / numb2 ))
        echo "$numb1 / $numb2 = $result"
    fi
}


echo "Please enter your first number: "
read numb1
echo "Please enter your second number: "
read numb2
echo "Enter a number of 1 (sum), 2 (difference), 3 (multiply) or 4 (Division). Which operation would you like to perform: "
read oper

case "$oper" in
    1) add ;;
    2) difference ;;
    3) multiply ;;
    4) divide ;;
    *) echo "Input is invalid, number is out of bounds" ;;
esac
