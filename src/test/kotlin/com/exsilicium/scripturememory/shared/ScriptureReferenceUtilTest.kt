package com.exsilicium.scripturememory.shared

import com.exsilicium.scripturememory.shared.model.Book.*
import com.exsilicium.scripturememory.shared.model.ScriptureReference
import com.exsilicium.scripturememory.shared.model.Verse
import com.exsilicium.scripturememory.shared.model.VerseRange
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

    @Test fun `Parse reference from single verse`() {
        assertEquals(ScriptureReference(JOHN, 1, Verse(1)),
                ScriptureReferenceUtil.parse("John 1:1"))
    }

    @Test fun `Parse bible book name with spaces`() {
        assertEquals(ScriptureReference(FIRST_PETER, 2, Verse(9)),
                ScriptureReferenceUtil.parse("First Peter 2:9"))
    }

    @Test fun `Parse bible book name with number`() {
        assertEquals(ScriptureReference(FIRST_CORINTHIANS),
                ScriptureReferenceUtil.parse("1 Corinthians"))
    }

    @Test fun `Parse multiple verse ranges`() {
        assertEquals(ScriptureReference(JOHN, 6, listOf(VerseRange(Verse(14)), VerseRange(Verse(44)))),
                ScriptureReferenceUtil.parse("John 6:14, 44"))
    }

    @Test fun `Parse single verse range`() {
        assertEquals(ScriptureReference(FIRST_CORINTHIANS, 13, Verse(4)..Verse(8)),
                ScriptureReferenceUtil.parse("1 Corinthians 13:4-8"))
    }

    @Test fun `Parse reference from verse part`() {
        assertEquals(ScriptureReference(EZEKIEL, 38, Verse(22, 'b')),
                ScriptureReferenceUtil.parse("Ezekiel 38:22B"))
    }

    @Test fun `Parse multiple verse ranges with multiple verses`() {
        assertEquals(
                ScriptureReference(
                        JOHN,
                        20,
                        listOf(VerseRange(Verse(24)), Verse(26)..Verse(28))
                ),
                ScriptureReferenceUtil.parse("John 20:24,26-28")
        )
    }
}