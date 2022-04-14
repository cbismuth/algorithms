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

import com.github.cbismuth.puzzles.CountingTriangles.Sides;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class CountingTrianglesTest {

  private static final List<Sides> input1 = new ArrayList<>();
  private static final List<Sides> input2 = new ArrayList<>();

  static {
    input1.add(new Sides(7, 6, 5));
    input1.add(new Sides(5, 7, 6));
    input1.add(new Sides(8, 2, 9));
    input1.add(new Sides(2, 3, 4));
    input1.add(new Sides(2, 4, 3));

    input2.add(new Sides(3, 4, 5));
    input2.add(new Sides(8, 8, 9));
    input2.add(new Sides(7, 7, 7));
  }

  private static Stream<Arguments> data() {
    return Stream.of(Arguments.arguments(input1, 3),
                     Arguments.arguments(input2, 3));
  }

  private final CountingTriangles service = new CountingTriangles();

  @ParameterizedTest
  @MethodSource("data")
  void test(final List<Sides> input, final int expected) {
    final int actual = service.countDistinctTriangles(input);

    Assertions.assertEquals(expected, actual);
  }
}
