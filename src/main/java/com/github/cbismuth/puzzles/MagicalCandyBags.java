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

import com.github.cbismuth.puzzles.utils.ArraysHelper;
import com.github.cbismuth.puzzles.utils.MutablePair;

/**
 * <b>Magical Candy Bags</b>
 * <p>
 * You have {@code N} bags of candy. The {@code ith} bag contains {@code input[i]} pieces of candy, and each of the bags
 * is magical!
 * <p>
 * It takes you {@code 1} minute to eat all of the pieces of candy in a bag (irrespective of how many pieces of candy
 * are inside), and as soon as you finish, the bag mysteriously refills. If there were {@code x} pieces of candy in the
 * bag at the beginning of the minute, then after you've finished you'll find that {@code floor(x/2)} pieces are now
 * inside.
 * <p>
 * You have {@code k} minutes to eat as much candy as possible. How many pieces of candy can you eat?
 */
public class MagicalCandyBags {

  /**
   * Computes how many pieces of candy can you eat.
   * <p>
   * Cyclomatic complexity is {@code O(k*n)} as each minute the input set of candy bags will be iterated to find the
   * biggest one.
   *
   * @param input an input set of magical bags
   * @param k a number of minutes
   *
   * @return the number of pieces of candy can you eat
   */
  int maxCandies(final int[] input, final int k) {
    int output = 0;

    for (int i = 0; i < k; i++) {
      final MutablePair<Integer, Integer> max = ArraysHelper.max(input);

      final int index = max.getLeft();
      final int value = input[index];
      final int magic = (int) Math.floor(value / 2.0);

      output += value;
      input[index] = magic;
    }

    return output;
  }
}
