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

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b>Seating Arrangements</b>
 * <p>
 * There are {@code n} guests attending a dinner party, numbered from {@code 1} to {@code n}. The ith guest has a height
 * of {@code input[i-1]} inches.
 * <p>
 * The guests will sit down at a circular table which has {@code n} seats, numbered from {@code 1} to {@code n} in
 * clockwise order around the table. As the host, you will choose how to arrange the guests, one per seat. Note that
 * there are {@code n!} possible permutations of seat assignments.
 * <p>
 * Once the guests have sat down, the awkwardness between a pair of guests sitting in adjacent seats is defined as the
 * absolute difference between their two heights. Note that, because the table is circular, seats {@code 1} and {@code
 * n} are considered to be adjacent to one another, and that there are therefore {@code n} pairs of adjacent guests.
 * <p>
 * The overall awkwardness of the seating arrangement is then defined as the maximum awkwardness of any pair of adjacent
 * guests. Determine the minimum possible overall awkwardness of any seating arrangement.
 */
class SeatingArrangements {

  /**
   * Determines the overall awkwardness of the seating arrangement.
   *
   * @param input a seating arrangement
   *
   * @return the overall awkwardness
   */
  private int maxAwkwardness(final int[] input) {
    final int n = input.length;

    int max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      max = Math.max(max, Math.abs(input[i] - input[(i + 1) % n]));
    }

    return max;
  }

  /**
   * Determines all permutations from a seating arrangement and the resolves the min between the max awkwardness of each
   * permutation and the accumulated min value.
   *
   * @param input a seating arrangement
   * @param depth current recursion depth (a recursion stops when {@code depth == input.length - 1})
   * @param min an accumulated min value
   *
   * @return the accumulated value
   */
  private int minOverallAwkwardness(final int[] input,
                                    final int depth,
                                    final AtomicInteger min) {
    if (depth == input.length - 1) {
      return min.accumulateAndGet(maxAwkwardness(input), Integer::min);
    } else {
      for (int i = depth; i < input.length; i++) {
        ArraysHelper.swap(input, depth, i);
        min.accumulateAndGet(minOverallAwkwardness(input, depth + 1, min), Integer::min);
        ArraysHelper.swap(input, depth, i);
      }

      return min.get();
    }
  }

  /**
   * Determines the minimum possible overall awkwardness of any seating arrangement.
   *
   * @param input a seating arrangement
   *
   * @return the minimum possible overall awkwardness of any seating arrangement
   */
  int minOverallAwkwardness(final int[] input) {
    return minOverallAwkwardness(input, 0, new AtomicInteger(Integer.MAX_VALUE));
  }
}
