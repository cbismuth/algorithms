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

import com.github.cbismuth.algorithms.facebook.utils.IntCharQuery;
import com.github.cbismuth.algorithms.facebook.utils.MutableNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class NodesInSubtreeTest {

  private static final MutableNode root1 = new MutableNode(1);
  private static final List<IntCharQuery> queries1 = new ArrayList<>();
  private static final String string1 = "aba";

  private static final MutableNode root2 = new MutableNode(1);
  private static final List<IntCharQuery> queries2 = new ArrayList<>();
  private static final String string2 = "abaacab";

  static {
    root1.addChild(new MutableNode(2));
    root1.addChild(new MutableNode(3));
    queries1.add(new IntCharQuery(1, 'a'));

    root2.addChild(new MutableNode(2));
    root2.addChild(new MutableNode(3));
    root2.addChild(new MutableNode(7));
    root2.getChildren().get(0).addChild(new MutableNode(4));
    root2.getChildren().get(0).addChild(new MutableNode(5));
    root2.getChildren().get(1).addChild(new MutableNode(6));
    queries2.add(new IntCharQuery(1, 'a'));
    queries2.add(new IntCharQuery(2, 'b'));
    queries2.add(new IntCharQuery(3, 'a'));
  }

  private static Stream<Arguments> data() {
    return Stream.of(Arguments.arguments(root1, queries1, string1, new int[] { 2 }),
                     Arguments.arguments(root2, queries2, string2, new int[] { 4, 1, 2 }));
  }

  private final NodesInSubtree service = new NodesInSubtree();

  @ParameterizedTest
  @MethodSource("data")
  void test(final MutableNode root, final List<IntCharQuery> queries, final String string, final int[] expected) {
    final int[] actual = service.countOfNodes(root, queries, string);

    Assertions.assertArrayEquals(expected, actual);
  }
}
