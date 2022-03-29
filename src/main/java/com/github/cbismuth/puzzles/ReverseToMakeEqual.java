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

/**
 * <b>Reverse to Make Equal</b>
 * <p>
 * Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays
 * from array B any number of times.
 */
class ReverseToMakeEqual {

  /**
   * Swaps values at indices {@code index1} and {@code index2} in a given array.
   *
   * @param array an input array
   * @param index1 a first index
   * @param index2 a second index
   */
  private void swap(final int[] array, final int index1, final int index2) {
    final int tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
  }

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
        swap(array, i, j);
        return true;
      }
    }

    return false;
  }

  /**
   * Given two arrays A and B of length N, determines if there is a way to make A equal to B by reversing any subarrays
   * from array B any number of times.
   * <p>
   * Cyclomatic complexity is <b>O(n^2)</b> as the input array may be partially iterated once for each element it
   * contains.
   *
   * @param array1 a first input array
   * @param array2 a second input array
   *
   * @return {@code true} if there is a way to make A equal to B, {@code false} otherwise.
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
