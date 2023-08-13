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

/**
 * <b>Contiguous Subarrays</b>
 * <p>
 * You are given an array of {@code N} integers. For each index {@code i}, you are required to determine the number of
 * contiguous subarrays that fulfill the following conditions:
 *
 * <ul>
 *   <li>the value at index {@code i} must be the maximum element in the contiguous subarrays,</li>
 *   <li>and these contiguous subarrays must either start from or end on index {@code i}.</li>
 * </ul>
 */
class ContiguousSubarrays {

  /**
   * Counts subarrays from an input array.
   * <p>
   * Cyclomatic complexity is {@code O(n*(n+n))=O(n^2)} as the input array is iterated twice for each element it
   * contains.
   *
   * @param input an input array
   *
   * @return the array containing contiguous subarrays count for each input array element
   */
  int[] countSubarrays(final int[] input) {
    final int[] output = new int[input.length];

    for (int i = 0; i < input.length; i++) {
      // Initialized to 1 as each element is a subarray on its own
      int count = 1;

      for (int j = i - 1; j >= 0 && input[j] < input[i]; j--) {
        if (input[j] < input[i]) {
          count++;
        }
      }

      for (int j = i + 1; j < input.length && input[j] < input[i]; j++) {
        if (input[j] < input[i]) {
          count++;
        }
      }

      output[i] = count;
    }

    return output;
  }
}
