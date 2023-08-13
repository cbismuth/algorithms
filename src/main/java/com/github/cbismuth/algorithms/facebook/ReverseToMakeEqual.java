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

import com.github.cbismuth.algorithms.facebook.utils.ArraysHelper;

/**
 * <b>Reverse to Make Equal</b>
 * <p>
 * Given two arrays {@code A} and {@code B} of length {@code N}, determine if there is a way to make {@code A} equal to
 * {@code B} by reversing any subarrays from array {@code B} any number of times.
 */
class ReverseToMakeEqual {

  /**
   * Finds the first value that matches {@code expected} in a given array from the index {@code i+1} and swap it with
   * the value located at the index {@code i}.
   *
   * @param array an input array
   * @param i the index of the value to permute
   * @param expected an expected value to match
   *
   * @return {@code true} if permutation succeeded, {@code false} otherwise.
   */
  private boolean permutes(final int[] array, final int i, final int expected) {
    for (int j = i + 1; j < array.length; j++) {
      if (array[j] == expected) {
        ArraysHelper.swap(array, i, j);
        return true;
      }
    }

    return false;
  }

  /**
   * Given two arrays {@code A} and {@code B} of length {@code N}, determines if there is a way to make {@code A} equal
   * to {@code B} by reversing any subarrays from array {@code B} any number of times.
   * <p>
   * Cyclomatic complexity is {@code O(n^2)} as the input array may be partially iterated once for each element it
   * contains.
   *
   * @param array1 a first input array
   * @param array2 a second input array
   *
   * @return {@code true} if there is a way to make {@code A} equal to {@code B}, {@code false} otherwise.
   */
  boolean areTheyEqual(final int[] array1, final int[] array2) {
    if (array1.length != array2.length) {
      return false;
    }

    for (int i = 0; i < array1.length; i++) {
      final int expected = array1[i];

      if (array2[i] != expected) {
        if (!permutes(array2, i, expected)) {
          return false;
        }
      }
    }

    return true;
  }
}
