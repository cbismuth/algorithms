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

import com.github.cbismuth.puzzles.NumberOfVisibleNodes.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberOfVisibleNodesTest {

  private static final Node root1 = new Node(8);
  private static final Node root2 = new Node(10);

  static {
    root1.left = new Node(3);
    root1.right = new Node(10);
    root1.left.left = new Node(1);
    root1.left.right = new Node(6);
    root1.right.right = new Node(14);
    root1.left.right.left = new Node(4);
    root1.left.right.right = new Node(7);
    root1.right.right.left = new Node(13);

    root2.left = new Node(8);
    root2.right = new Node(15);
    root2.left.left = new Node(4);
    root2.left.left.right = new Node(5);
    root2.left.left.right.right = new Node(6);
    root2.right.left = new Node(14);
    root2.right.right = new Node(16);
  }

  private static Stream<Arguments> data() {
    return Stream.of(Arguments.arguments(root1, 4),
                     Arguments.arguments(root2, 5));
  }

  private final NumberOfVisibleNodes service = new NumberOfVisibleNodes();

  @ParameterizedTest
  @MethodSource("data")
  void test(final Node root, final int expected) {
    final int actual = service.visibleNodes(root);

    Assertions.assertEquals(expected, actual);
  }
}
