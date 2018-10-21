package lesson2.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun quadraticRootNumber() {
        assertEquals(1, quadraticRootNumber(1.0, 2.0, 1.0))
        assertEquals(2, quadraticRootNumber(1.0, 3.0, 2.0))
        assertEquals(0, quadraticRootNumber(1.0, 4.0, 10.0))
    }

    @Test
    @Tag("Example")
    fun gradeNotation() {
        assertEquals("отлично", gradeNotation(5))
        assertEquals("удовлетворительно", gradeNotation(3))
    }

    @Test
    @Tag("Example")
    fun minBiRoot() {
        assertEquals(Double.NaN, minBiRoot(0.0, 0.0, 1.0), 1e-2)
        assertEquals(Double.NaN, minBiRoot(0.0, 1.0, 2.0), 1e-2)
        assertEquals(-2.0, minBiRoot(0.0, 1.0, -4.0), 1e-10)
        assertEquals(Double.NaN, minBiRoot(1.0, -2.0, 4.0), 1e-2)
        assertEquals(Double.NaN, minBiRoot(1.0, 3.0, 2.0), 1e-2)
        assertEquals(-1.41, minBiRoot(1.0, -3.0, 2.0), 1e-2)
    }

    @Test
    @Tag("Easy")
    fun ageDescription() {
        assertEquals("1 год", ageDescription(1))
        assertEquals("2 года", ageDescription(2))
        assertEquals("3 года", ageDescription(3))
        assertEquals("4 года", ageDescription(4))
        assertEquals("5 лет", ageDescription(5))
        assertEquals("6 лет", ageDescription(6))
        assertEquals("7 лет", ageDescription(7))
        assertEquals("8 лет", ageDescription(8))
        assertEquals("9 лет", ageDescription(9))
        assertEquals("10 лет", ageDescription(10))
        assertEquals("11 лет", ageDescription(11))
        assertEquals("12 лет", ageDescription(12))
        assertEquals("13 лет", ageDescription(13))
        assertEquals("14 лет", ageDescription(14))
        assertEquals("15 лет", ageDescription(15))
        assertEquals("16 лет", ageDescription(16))
        assertEquals("17 лет", ageDescription(17))
        assertEquals("18 лет", ageDescription(18))
        assertEquals("19 лет", ageDescription(19))
        assertEquals("20 лет", ageDescription(20))
        assertEquals("21 год", ageDescription(21))
        assertEquals("22 года", ageDescription(22))
        assertEquals("23 года", ageDescription(23))
        assertEquals("24 года", ageDescription(24))
        assertEquals("25 лет", ageDescription(25))
        assertEquals("26 лет", ageDescription(26))
        assertEquals("27 лет", ageDescription(27))
        assertEquals("28 лет", ageDescription(28))
        assertEquals("29 лет", ageDescription(29))
        assertEquals("30 лет", ageDescription(30))
        assertEquals("31 год", ageDescription(31))
        assertEquals("32 года", ageDescription(32))
        assertEquals("132 года", ageDescription(132))
        assertEquals("111 лет", ageDescription(111))
        assertEquals("112 лет", ageDescription(112))
        assertEquals("110 лет", ageDescription(110))
        assertEquals("113 лет", ageDescription(113))
        assertEquals("114 лет", ageDescription(114))
        assertEquals("115 лет", ageDescription(115))
        assertEquals("116 лет", ageDescription(116))
        assertEquals("117 лет", ageDescription(117))
        assertEquals("118 лет", ageDescription(118))
        assertEquals("119 лет", ageDescription(119))
        assertEquals("120 лет", ageDescription(120))
        assertEquals("121 год", ageDescription(121))
        assertEquals("122 года", ageDescription(122))
        assertEquals("199 лет", ageDescription(199))
    }

    @Test
    @Tag("Easy")
    fun timeForHalfWay() {
        assertEquals(2.5, timeForHalfWay(1.0, 5.0, 2.0, 4.0, 3.0, 3.0), 1e-2)
        assertEquals(3.67, timeForHalfWay(4.0, 3.0, 1.0, 4.0, 1.0, 6.0), 1e-2)
        assertEquals(4.4, timeForHalfWay(3.0, 0.0, 1.0, 6.0, 2.0, 5.0), 1e-2)
    }

    @Test
    @Tag("Easy")
    fun whichRookThreatens() {
        assertEquals(0, whichRookThreatens(1, 2, 3, 4, 5, 6))
        assertEquals(1, whichRookThreatens(5, 3, 7, 3, 4, 8))
        assertEquals(2, whichRookThreatens(6, 8, 8, 6, 6, 3))
        assertEquals(3, whichRookThreatens(3, 7, 8, 7, 3, 5))
    }

    @Test
    @Tag("Easy")
    fun rookOrBishopThreatens() {
        assertEquals(0, rookOrBishopThreatens(4, 5, 5, 7, 8, 8))
        assertEquals(1, rookOrBishopThreatens(2, 8, 6, 8, 1, 6))
        assertEquals(2, rookOrBishopThreatens(5, 4, 3, 7, 1, 8))
        assertEquals(3, rookOrBishopThreatens(1, 6, 7, 6, 3, 8))
    }

    @Test
    @Tag("Easy")
    fun triangleKind() {
        assertEquals(-1, triangleKind(3.0, 7.5, 4.0))
        assertEquals(-1, triangleKind(7.5, 3.0, 4.0))
        assertEquals(-1, triangleKind(4.0, 3.0, 7.5))
        assertEquals(1, triangleKind(5.0, 3.0, 4.0))
        assertEquals(1, triangleKind(4.0, 3.0, 5.0))
        assertEquals(1, triangleKind(3.0, 5.0, 4.0))
        assertEquals(2, triangleKind(4.0, 6.0, 8.0))
        assertEquals(2, triangleKind(6.0, 4.0, 8.0))
        assertEquals(2, triangleKind(8.0, 4.0, 6.0))
        assertEquals(0, triangleKind(1.0, 1.5, 1.5))
        assertEquals(0, triangleKind(1.5, 1.5, 1.0))
        assertEquals(0, triangleKind(1.5, 1.0, 1.5))
    }

    @Test
    @Tag("Normal")
    fun segmentLength() {
        assertEquals(-1, segmentLength(1, 2, 3, 4))
        assertEquals(-1, segmentLength(5, 7, 1, 3))
        assertEquals(0, segmentLength(1, 2, 2, 4))
        assertEquals(3, segmentLength(3, 6, 0, 9))
        assertEquals(2, segmentLength(2, 5, 3, 9))
        assertEquals(1, segmentLength(3, 6, 1, 4))
        assertEquals(4, segmentLength(1, 15, 10, 14))
    }
}