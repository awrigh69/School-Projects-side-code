# Class: CIST 2742 Python Programming I
# Term: Spring 2026
# Instructor: Chris Bishop
# Description: Solution to Lab # 3 Tuition
# Author: Andrew Wright
#
# By turning in this code, I Pledge:
# 1. That I have completed the programming assignment independently.
# 2. I have not copied the code from a student or any source.
# 3. I have not given my code to any student.

base_year = 1

curr_tuition = float(input("Enter the cost of current student tuition: "))
percent = float(input("Enter the yearly percentage increase: ")) / 100
years_input = int(input("How many years of tuition are covered? "))

while base_year <= years_input:

    curr_tuition += curr_tuition * percent

    print(f"The tuition for year {base_year} is: ${curr_tuition:,.2f}")

    base_year += 1