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
 * <b>Median Stream</b>
 * <p>
 * You're given a list of {@code n} integers {@code input[0..(n-1)]}. You must compute a list {@code output[0..(n-1)]}
 * such that, for each index {@code i} (between {@code 0} and {@code n-1}, inclusive), {@code output[i]} is equal to the
 * median of the elements {@code input[0..i]} (rounded down to the nearest integer).
 * <p>
 * The median of a list of integers is defined as follows. If the integers were to be sorted, then:
 * <ul>
 *   <li>If there are an odd number of integers, then the median is equal to the middle integer in the sorted order.</li>
 *   <li>Otherwise, if there are an even number of integers, then the median is equal to the average of the two middle-most integers in the sorted order.</li>
 * </ul>
 */
class MedianStream {

  /**
   * Finds the median for each element of an input array.
   *
   * @param input an input array
   *
   * @return the output array of median elements
   */
  int[] findMedian(final int[] input) {
    final int[] output = new int[input.length];

    for (int i = 0; i < input.length; i++) {
      final int[] copy = Arrays.copyOfRange(input, 0, i + 1);
      Arrays.sort(copy);

      if (i % 2 == 0) {
        output[i] = copy[i / 2];
      } else {
        final double average = (copy[i / 2] + copy[(i / 2) + 1]) / 2.0;

        output[i] = (int) Math.floor(average);
      }
    }

    return output;
  }
}
