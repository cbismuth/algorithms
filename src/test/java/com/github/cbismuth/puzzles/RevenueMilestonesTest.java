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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RevenueMilestonesTest {

  private static Stream<Arguments> data() {
    return Stream.of(Arguments.arguments(new int[] { 100, 200, 300, 400, 500 }, new int[] { 300, 800, 1000, 1400 }, new int[] { 2, 4, 4, 5 }),
                     Arguments.arguments(new int[] { 700, 800, 600, 400, 600, 700 }, new int[] { 3100, 2200, 800, 2100, 1000 }, new int[] { 5, 4, 2, 3, 2 }));
  }

  private final RevenueMilestones service = new RevenueMilestones();

  @ParameterizedTest
  @MethodSource("data")
  void test(final int[] revenues, final int[] milestones, final int[] expected) {
    final int[] actual = service.getMilestoneDays(revenues, milestones);

    Assertions.assertArrayEquals(expected, actual);
  }
}
