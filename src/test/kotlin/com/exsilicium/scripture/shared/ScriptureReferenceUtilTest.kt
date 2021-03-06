package com.exsilicium.scripture.shared

import com.exsilicium.scripture.shared.model.*
import com.exsilicium.scripture.shared.model.Book.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ScriptureReferenceUtilTest {

    @Test fun `Parse reference with just book name`() {
        assertEquals(ScriptureReference(EPHESIANS),
                ScriptureReferenceUtil.parse("Ephesians"))
    }

    @Test fun `Parse reference with just book name and chapter`() {
        assertEquals(ScriptureReference(ROMANS, 8),
                ScriptureReferenceUtil.parse("Romans 8"))
    }

    @Test fun `Parse chapter range`() {
        assertEquals(ScriptureReference(ROMANS, ChapterRanges(8..9)),
                ScriptureReferenceUtil.parse("Romans 8-9"))
    }

    @Test fun `Parse chapter and a chapter range`() {
        assertEquals(ScriptureReference(ROMANS, ChapterRanges(ChapterRange(8), 11..13)),
                ScriptureReferenceUtil.parse("Romans 8, 11-13"))
    }

    @Test fun `Parse multiple chapter ranges`() {
        assertEquals(ScriptureReference(ROMANS, ChapterRanges(8..9, 11..13)),
                ScriptureReferenceUtil.parse("Romans 8-9, 11-13"))
    }

    @Test fun `Parse reference from single verse`() {
        assertEquals(ScriptureReference(JOHN, Verse(1, 1)),
                ScriptureReferenceUtil.parse("John 1:1"))
    }

    @Test fun `Parse bible book name with spaces`() {
        assertEquals(ScriptureReference(FIRST_PETER, Verse(2, 9)),
                ScriptureReferenceUtil.parse("First Peter 2:9"))
    }

    @Test fun `Parse bible book name with number`() {
        assertEquals(ScriptureReference(FIRST_CORINTHIANS),
                ScriptureReferenceUtil.parse("1 Corinthians"))
    }

    @Test fun `Parse multiple verse ranges`() {
        assertEquals(
                ScriptureReference(JOHN, VerseRanges(VerseRange(Verse(6, 14)), VerseRange(Verse(6, 44)))),
                ScriptureReferenceUtil.parse("John 6:14, 44")
        )
    }

    @Test fun `Parse single verse range`() {
        assertEquals(
                ScriptureReference(FIRST_CORINTHIANS, VerseRanges(Verse(13, 4)..Verse(13, 8))),
                ScriptureReferenceUtil.parse("1 Corinthians 13:4-8")
        )
    }

    @Test fun `Parse reference from verse part`() {
        assertEquals(ScriptureReference(EZEKIEL, Verse(38, 22, 'b')),
                ScriptureReferenceUtil.parse("Ezekiel 38:22B"))
    }

    @Test fun `Parse multiple verse ranges with multiple verses`() {
        assertEquals(
                ScriptureReference(JOHN, VerseRanges(VerseRange(Verse(20, 24)), Verse(20, 26)..Verse(20, 28))),
                ScriptureReferenceUtil.parse("John 20:24, 26-28")
        )
    }
}
