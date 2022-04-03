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

import java.util.Arrays;

/**
 * <b>Slow Sums</b>
 * <p>
 * Suppose we have a list of {@code N} numbers, and repeat the following operation until we're left with only a single
 * number: choose any two numbers and replace them with their sum. Moreover, we associate a penalty with each operation
 * equal to the value of the new number, and call the penalty for the entire list as the sum of the penalties of each
 * operation.
 * <p>
 * For example, given the list {@code [1, 2, 3, 4, 5]}, we could choose {@code 2} and {@code 3} for the first operation,
 * which would transform the list into {@code [1, 5, 4, 5]} and incur a penalty of {@code 5}. The goal in this problem
 * is to find the <b>highest</b> possible penalty for a given input.
 */
class SlowSums {

  /**
   * Reduces a sorted array by summing the last two elements.
   *
   * @param sorted an input sorted array
   * @param accumulator a sum of all previous penalties
   *
   * @return the sum of all previous penalties plus the sum of the last two elements
   */
  private int reduce(final int[] sorted, final int accumulator) {
    if (sorted.length == 2) {
      return sorted[1] + sorted[0] + accumulator;
    }

    final int penalty = sorted[sorted.length - 1] + sorted[sorted.length - 2];
    final int penalties = accumulator + penalty;

    final int[] reduced = new int[sorted.length - 1];
    System.arraycopy(sorted, 0, reduced, 0, sorted.length - 2);
    reduced[reduced.length - 1] = penalty;

    return reduce(reduced, penalties);
  }

  /**
   * Finds the <b>highest</b> possible penalty for a given input.
   * <p>
   * This implementation first sorts the given input array and then reduces it from right to left.
   *
   * @param input an input array
   *
   * @return the <b>highest</b> possible penalty
   */
  int getTotalTime(final int[] input) {
    Arrays.sort(input);

    return reduce(input, 0);
  }
}
