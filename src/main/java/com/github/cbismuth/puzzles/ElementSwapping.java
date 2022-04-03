/*
 * MIT License
 *
 * Copyright (c) 2022 Christophe Bismuth (christophe.bismuth@gmail.com)
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

/**
 * <b>Element Swapping</b>
 * <p>
 * Given a sequence of {@code n} integers input, determine the lexicographically smallest sequence which may be obtained
 * from it after performing at most {@code k} element swaps, each involving a pair of consecutive elements in the
 * sequence.
 * <p>
 * <b>Note</b>: A list {@code x} is <b>lexicographically</b> smaller than a different equal-length list {@code y} if
 * and only if, for the earliest index at which the two lists differ, {@code x}'s element at that index is smaller than
 * {@code y}'s element at that index.
 */
class ElementSwapping {

  /**
   * Determines the lexicographically smallest sequence which may be obtained from it after performing at most {@code k}
   * element swaps.
   *
   * @param input an input array
   * @param k a max number of swaps to perform
   *
   * @return the lexicographically smallest sequence
   */
  int[] findMinArray(final int[] input, final int k) {
    final int minIndex = ArraysHelper.getMinIndex(input, k);

    for (int i = minIndex; i > 0; i--) {
      ArraysHelper.swap(input, i - 1, i);
    }

    return input;
  }
}
