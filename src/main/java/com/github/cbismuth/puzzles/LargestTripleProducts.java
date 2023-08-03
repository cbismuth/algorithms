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
import com.github.cbismuth.puzzles.utils.MutablePair;

import java.util.Arrays;

/**
 * <b>Largest Triple Products</b>
 * <p>
 * You're given a list of {@code n} integers {@code input[0..(n-1)]}. You must compute a list {@code output[0..(n-1)]}
 * such that, for each index {@code i} (between {@code 0} and {@code n-1}, inclusive), {@code output[i]} is equal to the
 * product of the three largest elements out of {@code input[0..i]} (or equal to {@code -1} if {@code i < 2}, as {@code
 * input[0..i]} then includes fewer than three elements).
 * <p>
 * Note that the three largest elements used to form any product may have the same values as one another, but they must
 * be at different indices in input.
 */
class LargestTripleProducts {

  /**
   * Computes the product of all elements of an input array.
   *
   * @param input an input array
   *
   * @return the product
   */
  private int product(final int[] input) {
    int output = 1;

    for (final int element : input) {
      output = Math.multiplyExact(output, element);
    }

    return output;
  }

  /**
   * Finds the max product of each element of an input array.
   *
   * @param input an input array
   *
   * @return the array containing the max product for each element.
   */
  int[] findMaxProduct(final int[] input) {
    final int[] output = new int[input.length];

    for (int i = 0; i < input.length; i++) {
      final int[] tmp = new int[3];
      Arrays.fill(tmp, -1);

      for (int j = 0; j <= i && i >= 2; j++) {
        final MutablePair<Integer, Integer> min = ArraysHelper.getMin(tmp, tmp.length);

        if (input[j] > min.getRight()) {
          tmp[min.getLeft()] = input[j];
        }
      }

      output[i] = product(tmp);
    }

    return output;
  }
}
