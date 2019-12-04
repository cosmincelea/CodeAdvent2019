from collections import Counter

def isAscending(list):
    previous = list[0]
    for number in list:
        if number < previous:
            return False
        previous = number
    return True

numbersFoundPart2 = []
numbersFoundPart1 = []
for i in range (152085,670283):
            number_list = [x for x in str(i)]
            if isAscending(number_list):
               for key,count in Counter(str(i)).items():
                        if count / 2 >= 1:
                            numbersFoundPart1.append(i)
                            break
               for key, count in Counter(str(i)).items():
                    if count / 2 == 1:
                        numbersFoundPart2.append(i)
                        break
print(len(numbersFoundPart1))
print(len(numbersFoundPart2))
