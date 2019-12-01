with open("input.txt") as f:
    content = f.readlines()

totalFuel = 0
totalFuel2 = 0

for x in content:
	x = int(x.strip())
	totalFuel += round(x/3) - 2

	fuel = x // 3 - 2
	while fuel > 0:
		totalFuel2 += fuel
		fuel = fuel // 3 - 2



print(totalFuel)

print(totalFuel2)