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

package com.github.cbismuth.algorithms.facebook;

import java.util.Arrays;

/**
 * <b>Pair Sums</b>
 * <p>
 * Given a list of n integers {@code [0..(n-1)]}, determine the number of different pairs of elements within it which
 * sum to {@code k}.
 * <p>
 * If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs are
 * considered different if one pair includes at least one array index which the other doesn't, even if they include the
 * same values.
 */
class PairSums {

  /**
   * Determines the number of different pairs of elements within it which sum to {@code k}, then triggers a recursion
   * with the subarray containing all elements but the first one and accumulates sums.
   * <p>
   * Cyclomatic complexity is {@code O(n+(n-1)+(n-2)+...+2+1)=O(n*(n-1)/2)=O(n^2)} as the input array is iterated
   * twice for each element it contains.
   *
   * @param input an input array of integers
   * @param k an expected value
   * @param accumulator an accumulated number of different pairs
   *
   * @return the number of different pairs
   */
  private int recurse(final int[] input, final int k, final int accumulator) {
    if (input.length < 2) {
      return accumulator;
    }

    int count = accumulator;
    for (int i = 1; i < input.length; i++) {
      if ((input[0] + input[i]) == k) {
        count++;
      }
    }

    return recurse(Arrays.copyOfRange(input, 1, input.length), k, count);
  }

  /**
   * Determines the number of different pairs of elements within it which sum to {@code k}.
   *
   * @param input an input array of integers
   * @param k an expected value
   *
   * @return the number of different pairs
   */
  int numberOfWays(final int[] input, final int k) {
    return recurse(input, k, 0);
  }
}
