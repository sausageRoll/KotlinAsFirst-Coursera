@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import kotlin.math.PI
import kotlin.math.roundToInt
import kotlin.math.sqrt

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    if (n == 0) {
        return 1;
    }

    var cur = n
    var counter = 0
    while (cur != 0) {
        cur /= 10
        ++counter
    }
    return counter
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var previous = 0
    var current = 1
    for (i in 2..n) {
        val temp = current
        current += previous
        previous = temp;
    }
    return current;
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    for (i in Math.min(m, n)..m * n) {
        if (i % m == 0 && i % n == 0) {
            return i
        }
    }
    return m * n
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (i in 2..n) {
        if (n % i == 0) {
            return i
        }
    }

    return n
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var i = n - 1;
    while (i-- > 1) if (n % i == 0) {
        return i
    }

    return 1
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    for (i in 2..Math.min(m, n)) {
        if (m % i == 0 && n % i == 0) {
            return false
        }
    }
    return true
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    val msqrt = Math.sqrt(m.toDouble()).roundToInt()
    val nsqrt = Math.sqrt(n.toDouble()).roundToInt()

    for (i in msqrt..nsqrt) {
        if (i * i >= m && i * i <= n) {
            return true
        }
    }
    return false
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var next = x
    var counter = 0
    while (next != 1) {
        if (next % 2 == 0) {
            next /= 2
        } else {
            next = 3 * next + 1
        }
        ++counter
    }
    return counter
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {

    var realX = x;

    realX = mapToFirstCircle(realX)

    var value = realX / 1.0
    var nextX = realX
    var i = 2.0
    while (Math.abs(value) > eps) {
        value = value / i / (i + 1) * (-realX) * realX
        i += 2

        nextX += value
    }

    return nextX
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var realX = x;

    realX = mapToFirstCircle(realX)

    var value = 1.0 / 1.0
    var nextX = 1.0
    var i = 1.0
    while (Math.abs(value) > eps) {
        value = value / i / (i + 1) * (-realX) * realX
        i += 2

        nextX += value
    }

    return nextX
}

private fun mapToFirstCircle(x: Double): Double {
    var realX = x
    if (Math.abs(realX) > 2 * PI) {
        val d = realX / (2 * PI)
        realX -= d.toInt() * (2 * PI)
    }
    return realX
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var result = n % 10
    var nn = n / 10
    while (nn != 0) {
        result = result * 10 + nn % 10
        nn /= 10
    }
    return result
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    val numberOfDigits = countNumberOfDigits(n)
    if (numberOfDigits == 1) {
        return true
    }

    var maxP = power(10, numberOfDigits - 1)
    var minP = 1

    while (maxP > minP) {
        if ((n / maxP) % 10 != (n / minP) % 10) {
            return false
        }
        maxP /= 10
        minP *= 10
    }
    return true
}

fun power(n: Int, a: Int): Int {
    return Math.pow(n.toDouble(), a.toDouble()).toInt()

}

fun countNumberOfDigits(n: Int): Int {
    if (n == 0) {
        return 1
    }

    var counter = 0
    var nn = n
    while (nn != 0) {
        ++counter
        nn /= 10
    }
    return counter
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
//    var bit = 0
//    var nn = n
//
//    while (nn != 0) {
//        val cur = nn % 10
//        val leftShift= 1.shl(cur)
//        if (bit.and(leftShift) > 0) {
//            return false
//        }
//        bit = bit.or(leftShift)
//
//        nn /= 10
//    }
//
//    return true

    val first = n % 10
    var nn = n
    while (nn != 0) {
        val cur = nn % 10
        if (cur != first) {
            return true
        }
        nn /= 10
    }
    return false
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var nn = n
    var i = 1
    while (true) {
        val sqr = sqr(i++)

        val digits = countNumberOfDigits(sqr)
        if (digits < nn) {
            nn -= digits
        } else {
            var ssqr = sqr
            for (j in 1..(digits - nn)) {
                ssqr /= 10
            }
            return ssqr % 10
        }
    }
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var nn = n
    var previous = 0
    var current = 1


    while (true) {
        val temp = current
        current += previous
        previous = temp;
        val sqr = previous

        val digits = countNumberOfDigits(sqr)
        if (digits < nn) {
            nn -= digits
        } else {
            var ssqr = sqr
            for (j in 1..(digits - nn)) {
                ssqr /= 10
            }
            return ssqr % 10
        }
    }
}
