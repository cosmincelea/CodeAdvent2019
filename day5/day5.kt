import java.io.File

fun main(args: Array<String>) {
    val inputString = File("C:/CodeAdvent/src/Day2/input.txt").bufferedReader().use { it.readText() }
    var result = inputString.split(',').map { it.trim().toInt() }.toIntArray()
    run_computer(1, result);
    result = inputString.split(',').map { it.trim().toInt() }.toIntArray()
    run_computer(5, result);

}

fun run_computer(value: Int,intructions: IntArray){

    var i = 0;
    var val1:Int
    var val2:Int
    var val3:Int
    while(true)
    {
        var instruction = intructions[i];

        if(instruction == 99){break}

        var reverseInstruction = instruction.toString().map { it.toString().toInt() }.reversed().toIntArray()
        var opCode = reverseInstruction[0]
        var addressModes = ArrayList<Int>()

        for( j  in 2 .. reverseInstruction.size-1)
        {
            addressModes.add(reverseInstruction[j])
        }

        while(addressModes.size < 3)
        {
            addressModes.add(0)
        }



        if(addressModes[0] == 1) {
             val1 = i+1
        } else {  val1 = intructions[i+1]}

        if(addressModes[1] == 1) {
             val2 = i+2
        } else {  val2 = intructions[i+2]}

        if(addressModes[2] == 1) {
             val3 = i+3
        } else {  val3 = intructions[i+3]}


        if(opCode == 1)
        {
            intructions[val3] = intructions[val1] + intructions[val2]
            i+=4
        }
        else if(opCode == 2)
        {
            intructions[val3] = intructions[val1] * intructions[val2]
            i+=4
        }
        else if(opCode == 3)
        {
            intructions[val1] = value
                i += 2
        }
        else if(opCode == 4)
        {
            print (intructions[val1])
            println()
            i += 2
        }
        else if(opCode == 5)
        {
            if(intructions[val1] != 0)
            {
                i = intructions[val2]
            } else {
                i += 3
            }
        }
        else if(opCode == 6)
        {
            if(intructions[val1] == 0)
            {
                i = intructions[val2]
            } else {
                i += 3
            }
        }
        else if(opCode == 7)
        {
            if(intructions[val1] < intructions[val2])
            {
                intructions[val3] = 1
            } else {
                intructions[val3] = 0
            }
            i += 4
        }
        else if(opCode == 8)
        {
            if(intructions[val1] == intructions[val2])
            {
                intructions[val3] = 1
            } else {
                intructions[val3] = 0
            }
            i += 4
        }

    }

}