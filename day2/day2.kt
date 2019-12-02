package Day2
import java.io.File
import java.io.BufferedReader

fun main(args: Array<String>)
{
    val inputString = File("C:/CodeAdvent/src/Day2/input.txt").bufferedReader().use { it.readText() }
    var result = inputString.split(',').map { it.trim().toInt() }.toIntArray()
    var i = 0 ; var j = 0
    while(i < 100)
    {
        while(j < 100)
        {
            val copiedArray = result.copyOf()
            copiedArray[1] = i
            copiedArray[2] = j
            val transformedArray = generateArray(copiedArray)
            if(transformedArray[0] == 19690720)
            {
                print(100*i + j)
                break;
            }
            j += 1
        }
        i += 1 ; j = 0
    }
    result[1] = 12
    result[2] = 2
}

fun  generateArray(result: IntArray): IntArray
{
    var position = 0
    while (position + 4 < result.size) {
        if(result[position] == 1) {
            result[result[position + 3]] = result[result[position + 1]] + result[result[position + 2]]
        } else if (result[position] == 2) {
            result[result[position + 3]] = result[result[position + 1]] * result[result[position + 2]]
        } else if (result[position] == 99){ break }

        position += 4
    }
    return result;
}