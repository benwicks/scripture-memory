package com.exsilicium.scripturememory.shared

import com.exsilicium.scripturememory.shared.model.BibleBook.*
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
        assertEquals(ScriptureReference(JOHN, 1, listOf(VerseRange(Verse(1)))),
                ScriptureReferenceUtil.parse("John 1:1"))
    }

    @Test fun `Parse bible book name with spaces`() {
        assertEquals(ScriptureReference(FIRST_CORINTHIANS, 6, listOf()),
                ScriptureReferenceUtil.parse("1 Corinthians 6"))
    }
}