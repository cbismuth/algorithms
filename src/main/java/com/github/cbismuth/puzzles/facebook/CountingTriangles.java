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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <b>Counting Triangles</b>
 * <p>
 * Given a list of {@code N} triangles with integer side lengths, determine how many different triangles there are. Two
 * triangles are considered to be the same if they can both be placed on the plane such that their vertices occupy
 * exactly the same three points.
 */
class CountingTriangles {

  record Sides(int a, int b, int c) {
    // NOP
  }

  /**
   * Determines how many triangles there are.
   *
   * @param input a list of triangles
   *
   * @return the number of triangles
   */
  int countDistinctTriangles(final List<Sides> input) {
    final long count = input.stream()
                            .mapToInt(sides -> {
                              final List<Integer> list = new ArrayList<>();
                              list.add(sides.a);
                              list.add(sides.b);
                              list.add(sides.c);

                              Collections.sort(list);

                              return list.hashCode();
                            })
                            .distinct()
                            .count();

    return Math.toIntExact(count);
  }
}
