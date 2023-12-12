fun main() {
    val testInput = readInput("Day01_test")
    val input = readInput("Day01")

    val testInput2 = readInput("Day01_test2")
    val inputPart2 = readInput("Day01_2")


    fun calibrationValue(row: String) : Int {
        val first = row.first{ it.isDigit() }
        val last = row.last{ it.isDigit() }
        return "$first$last".toInt()
    }


    fun solvePart1(input: List<String>) : Int =
        input.sumOf { calibrationValue(it) }

    val numberMap = mapOf(
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9",
        "zero" to "0"
    )

    fun solvePart2(input: List<String>) : Int {
        var values = 0

        for(line in input) {
        val nums : MutableList<Int> = mutableListOf()
            var i = 0
            for(char in line) {
                val slice = line.slice(i..<line.length)
                for((key, value) in numberMap) {
                    if(slice.startsWith(key)) {
                        nums.add(value.toInt())
                    }
                }

                if(char.isDigit()) {
                    nums.add(char.digitToInt())
                }
                i++
            }
            values += (nums[0] * 10 + nums[nums.size -1])
        }
        return values
    }

    fun part1(input: List<String>): Int {
        return solvePart1(input)
    }

    fun part2(input: List<String>): Int {
        return solvePart2(input)
    }

    // test if implementation meets criteria from the description, like:
    println("Test result: ${part1(testInput)}")
    check(part1(testInput) == 142)
    println("Test result: ${part2(testInput2)}")
    check(part2(testInput2) == 281)

    println("part 1")
    part1(input).println()
    println("part 2")
    part2(input).println()
}


/**
 * --- Day 1: Trebuchet?! --- part 1 --- **/
/* Something is wrong with global snow production, and you've been selected to take a look. The Elves have even given you a map; on it, they've used stars to mark the top fifty locations that are likely to be having problems.

You've been doing this long enough to know that to restore snow operations, you need to check all fifty stars by December 25th.

Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

You try to ask why they can't just use a weather machine ("not powerful enough") and where they're even sending you ("the sky") and why your map looks mostly blank ("you sure ask a lot of questions") and hang on did you just say the sky ("of course, where do you think snow comes from") when you realize that the Elves are already loading you into a trebuchet ("please hold still, we need to strap you in").

As they're making the final adjustments, they discover that their calibration document (your puzzle input) has been amended by a very young Elf who was apparently just excited to show off her art skills. Consequently, the Elves are having trouble reading the values on the document.

The newly-improved calibration document consists of lines of text; each line originally contained a specific calibration value that the Elves now need to recover. On each line, the calibration value can be found by combining the first digit and the last digit (in that order) to form a single two-digit number.

For example:

1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet
In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces 142.

Consider your entire calibration document. What is the sum of all of the calibration values? */

/***** part 2 *****/

/*
* Your calculation isn't quite right. It looks like some of the digits are actually spelled out with letters: one, two, three, four, five, six, seven, eight, and nine also count as valid "digits".

Equipped with this new information, you now need to find the real first and last digit on each line. For example:

two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen
In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76. Adding these together produces 281.

What is the sum of all of the calibration values?*/


