# Class: CIST 2742 Python Programming I
# Term: Spring 2026
# Instructor: Chris Bishop
# Description: Solution to Lab #1 Cookie Recipe
# Author: Andrew Wright
#
# By turning in this code, I Pledge:
# 1. That I have completed the programming assignment independently.
# 2. I have not copied the code from a student or any source.
# 3. I have not given my code to any student.

Cookies_Constant = 48
Sugar = 1.5
Butter = 1.0
Flour = 2.75

cookies = int(input("How many cookies do you plan on making: "))

Sugar_Req = (Sugar / Cookies_Constant) * cookies
Butter_Req = (Butter / Cookies_Constant) * cookies
Flour_Req = (Flour / Cookies_Constant) * cookies

print("To make {cookies} cookies. You will need: ")
print(f"Cups of sugar: {Sugar_Req:.2f}")
print(f"Cups of Butter: {Butter_Req:.2f}")
print(f"Cups of Flour: {Flour_Req:.2f}")