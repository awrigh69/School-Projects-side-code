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

source ./mathlib.sh

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
