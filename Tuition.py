
base_year = 1

curr_tuition = float(input("Enter the cost of current student tuition: "))
percent = float(input("Enter the yearly percentage increase: ")) / 100
years_input = int(input("How many years of tuition are covered? "))

while base_year <= years_input:

    curr_tuition += curr_tuition * percent

    print(f"The tuition for year {base_year} is: ${curr_tuition:,.2f}")


    base_year += 1
