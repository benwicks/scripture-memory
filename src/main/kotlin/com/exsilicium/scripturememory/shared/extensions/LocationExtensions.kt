package com.exsilicium.scripturememory.shared.extensions

import com.exsilicium.scripturememory.shared.model.ChapterRanges
import com.exsilicium.scripturememory.shared.model.VerseRanges

internal fun ChapterRanges.compareChapterRanges(other: ChapterRanges): Int {
    val startingChapterComparison = chapterRanges.first().start.compareTo(other.chapterRanges.first().start)
    return when (startingChapterComparison) {
        0 -> compareAllChapterRanges(other)
        else -> startingChapterComparison
    }
}

private fun ChapterRanges.compareAllChapterRanges(other: ChapterRanges)
        = chapterRanges.sumBy { it.endInclusive - it.start }
        .compareTo(other.chapterRanges.sumBy { it.endInclusive - it.start })

internal fun VerseRanges.compareVerseRanges(other: VerseRanges): Int {
    val startingVerseComparison = verseRanges.first().start.compareTo(other.verseRanges.first().start)
    return when (startingVerseComparison) {
        0 -> compareAllVerseRanges(other)
        else -> startingVerseComparison
    }
}

private fun VerseRanges.compareAllVerseRanges(other: VerseRanges)
        = verseRanges.sumBy { it.endInclusive - it.start }
        .compareTo(other.verseRanges.sumBy { it.endInclusive - it.start })
