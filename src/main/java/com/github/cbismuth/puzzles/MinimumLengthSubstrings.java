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

package com.github.cbismuth.puzzles;

import com.github.cbismuth.puzzles.utils.ArraysHelper;

import java.util.Arrays;

/**
 * <b>Minimum Length Substrings</b>
 * <p>
 * You are given two strings {@code s} and {@code t}. You can select any substring of string {@code s} and rearrange the
 * characters of the selected substring. Determine the minimum length of the substring of {@code s} such that string
 * {@code t} is a substring of the selected substring.
 */
class MinimumLengthSubstrings {

  /**
   * Computes the minimum length substrings.
   *
   * @param string1 an input string 1
   * @param string2 an input string 2
   *
   * @return the minimum length substrings
   */
  int minLengthSubstring(final String string1, final String string2) {
    final char[] array1 = string1.toCharArray();
    final char[] array2 = string2.toCharArray();

    int min = Integer.MAX_VALUE;

    for (int i = 0; i < array1.length - 1; i++) {
      for (int j = i + 1; j < array1.length; j++) {
        final char[] substring = Arrays.copyOfRange(array1, i, j + 1);

        if (array2.length <= substring.length) {
          int caught = 0;
          int length = substring.length;

          for (int k = 0; k < array2.length && caught < array2.length; k++) {
            final char char2 = array2[k];
            final int index = ArraysHelper.getIndexOfChar(substring, length, char2);

            if (index > -1) {
              ArraysHelper.swap(substring, index, length - 1);

              caught++;
              length--;
            }
          }

          if (caught == array2.length) {
            min = Math.min(min, substring.length);
          }
        }
      }
    }

    return min < Integer.MAX_VALUE ? min : -1;
  }
}
