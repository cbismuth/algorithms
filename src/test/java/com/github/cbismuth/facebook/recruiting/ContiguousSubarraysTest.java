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

package com.github.cbismuth.facebook.recruiting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ContiguousSubarraysTest {

  private static Stream<Arguments> data() {
    return Stream.of(Arguments.arguments(new int[] { 3, 4, 1, 6, 2 }, new int[] { 1, 3, 1, 5, 1 }),
                     Arguments.arguments(new int[] { 2, 4, 7, 1, 5, 3 }, new int[] { 1, 2, 6, 1, 3, 1 }));
  }

  private final ContiguousSubarrays contiguousSubarrays = new ContiguousSubarrays();

  @ParameterizedTest
  @MethodSource("data")
  void testCountSubarrays(final int[] input, final int[] expected) {
    final int[] actual = contiguousSubarrays.countSubarrays(input);

    Assertions.assertArrayEquals(expected, actual);
  }
}
