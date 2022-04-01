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

package com.github.cbismuth.puzzles.utils;

/**
 * Utility class enclosing array method helpers.
 */
public final class ArraysHelper {

  /**
   * Finds the max element of an input array.
   *
   * @param input an input array
   *
   * @return the max
   */
  public static MutablePair<Integer, Integer> max(final int[] input) {
    // A mutable pair of {index, value} of the max element of the input array
    final MutablePair<Integer, Integer> max = new MutablePair<>(Integer.MIN_VALUE, Integer.MIN_VALUE);

    for (int i = 0; i < input.length; i++) {
      if (input[i] > max.getRight()) {
        max.set(i, input[i]);
      }
    }

    return max;
  }

  /**
   * Finds the min element of an input array.
   *
   * @param input an input array
   *
   * @return the min
   */
  public static MutablePair<Integer, Integer> min(final int[] input) {
    // A mutable pair of {index, value} of the min element of the input array
    final MutablePair<Integer, Integer> min = new MutablePair<>(Integer.MAX_VALUE, Integer.MAX_VALUE);

    for (int i = 0; i < input.length; i++) {
      if (input[i] < min.getRight()) {
        min.set(i, input[i]);
      }
    }

    return min;
  }

  private ArraysHelper() {
    // NOP
  }
}
