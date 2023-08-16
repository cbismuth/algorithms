/*
 * MIT License
 *
 * Copyright (c) 2022-2023 Christophe Bismuth (christophe.bismuth@gmail.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.cbismuth.puzzles.facebook;

import com.github.cbismuth.puzzles.facebook.utils.ArraysHelper;

/**
 * <b>Matching Pairs</b>
 * <p>
 * Given two strings {@code s} and {@code t} of length {@code N}, find the maximum number of possible matching pairs in
 * strings {@code s} and {@code t} after swapping exactly two characters within {@code s}.
 * <p>
 * A swap is switching {@code s[i]} and {@code s[j]}, where {@code s[i]} and {@code s[j]} denotes the character that is
 * present at the {@code ith} and {@code jth} index of {@code s}, respectively. The matching pairs of the two strings
 * are defined as the number of indices for which {@code s[i]} and {@code t[i]} are equal.
 * <p>
 * Note: This means you must swap two characters at different indices.
 */
class MatchingPairs {

  /**
   * Counts matching pairs between two {@code char} arrays.
   * <p>
   * Cyclomatic complexity is {@code O(n)}.
   *
   * @param array1 a {@code char} array
   * @param array2 another {@code char} array
   *
   * @return the matching pairs count
   */
  private int countMatchingPairs(final char[] array1, final char[] array2) {
    assert array1.length == array2.length;

    int output = 0;

    for (int i = 0; i < array1.length; i++) {
      if (array1[i] == array2[i]) {
        output++;
      }
    }

    return output;
  }

  /**
   * Counts matching pairs between two strings after swapping two characters in the first string.
   * <p>
   * Cyclomatic complexity is {@code O(n^3)} (3 nested loops).
   *
   * @param string1 a string
   * @param string2 another string
   *
   * @return the matching pairs count
   */
  int matchingPairs(final String string1, final String string2) {
    final char[] array1 = string1.toCharArray();
    final char[] array2 = string2.toCharArray();

    int output = 0;

    for (int i = 0; i < array1.length - 1; i++) {
      for (int j = i + 1; j < array1.length; j++) {
        ArraysHelper.swap(array1, i, j);
        output = Math.max(output, countMatchingPairs(array1, array2));
        ArraysHelper.swap(array1, i, j);
      }
    }

    return output;
  }
}
