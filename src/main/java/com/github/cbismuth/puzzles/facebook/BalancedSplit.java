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

import java.util.Arrays;

/**
 * <b>Balanced Split</b>
 * <p>
 * Given an array of integers (which may include repeated integers), determine if there's a way to split the array into
 * two subsequences {@code A} and {@code B} such that the sum of the integers in both arrays is the same, and all of the
 * integers in {@code A} are strictly smaller than all of the integers in {@code B}.
 * <p>
 * Note: Strictly smaller denotes that every integer in {@code A} must be less than, and not equal to, every integer in
 * {@code B}.
 */
class BalancedSplit {

  /**
   * Determines if there's a way to split the array into two subsequences.
   *
   * @param input an input array
   *
   * @return {@code true} if there's a way to split, {@code false} otherwise.
   */
  boolean balancedSplitExists(final int[] input) {
    Arrays.sort(input);

    final long expectation = Arrays.stream(input).asLongStream().sum() / 2;

    long accumulator = 0;
    for (int i = 0; i < input.length - 1; i++) {
      accumulator += input[i];

      if (accumulator == expectation) {
        return input[i] < input[i + 1];
      }
    }

    return false;
  }
}
