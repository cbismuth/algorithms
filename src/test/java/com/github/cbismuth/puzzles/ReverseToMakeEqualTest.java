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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReverseToMakeEqualTest {

  private static Stream<Arguments> data() {
    return Stream.of(Arguments.arguments(new int[] { }, new int[] { }, true),
                     Arguments.arguments(new int[] { 1 }, new int[] { 1 }, true),
                     Arguments.arguments(new int[] { 1 }, new int[] { 2 }, false),
                     Arguments.arguments(new int[] { 1, 2, 3, 4 }, new int[] { 1, 4, 3, 2 }, true),
                     Arguments.arguments(new int[] { 1, 2, 3, 4 }, new int[] { 1, 4, 3, 2, 2 }, false),
                     Arguments.arguments(new int[] { 1, 2, 3, 4 }, new int[] { 1, 4, 3, 3 }, false));
  }

  private final ReverseToMakeEqual reverseToMakeEqual = new ReverseToMakeEqual();

  @ParameterizedTest
  @MethodSource("data")
  void testNumberOfWays(final int[] a, final int[] b, final boolean expected) {
    final boolean actual = reverseToMakeEqual.areTheyEqual(a, b);

    Assertions.assertEquals(expected, actual);
  }
}
