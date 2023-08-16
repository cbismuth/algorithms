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
 * <b>Revenue Milestones</b>
 * <p>
 * We keep track of the revenue Facebook makes every day, and we want to know on what days Facebook hits certain revenue
 * milestones. Given an array of the revenue on each day, and an array of milestones Facebook wants to reach, return an
 * array containing the days on which Facebook reached every milestone.
 */
class RevenueMilestones {

  /**
   * Returns a {@code length-K} array where {@code K[i]} is the day on which FB first had {@code milestones[i]} total
   * revenue. If the milestone is never met, return {@code -1}.
   *
   * @param revenues an array of revenues
   * @param milestones an array of milestones
   *
   * @return the array of milestone hits
   */
  int[] getMilestoneDays(final int[] revenues, final int[] milestones) {
    final int[] output = new int[milestones.length];
    Arrays.fill(output, -1);

    int sum = 0;
    for (int i = 0; i < revenues.length; i++) {
      sum += revenues[i];

      for (int j = 0; j < milestones.length; j++) {
        if (output[j] == -1 && sum >= milestones[j]) {
          final int day = i + 1;

          output[j] = day;
        }
      }
    }

    return output;
  }
}
