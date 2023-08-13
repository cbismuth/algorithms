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

import com.github.cbismuth.algorithms.facebook.utils.MutableBinaryNode;

/**
 * <b>Number of Visible Nodes</b>
 * <p>
 * There is a binary tree with {@code N} nodes. You are viewing the tree from its left side and can see only the
 * leftmost nodes at each level. Return the number of visible nodes.
 *
 * <b>Note</b>: You can see only the leftmost nodes, but that doesn't mean they have to be left nodes. The leftmost
 * node at a level could be a right node.
 */
class NumberOfVisibleNodes {

  /**
   * Determines the depth of a tree from a node at a given level.
   *
   * @param node a node
   * @param level a level
   *
   * @return the depth
   */
  private int count(final MutableBinaryNode node, final int level) {
    if (node == null) {
      return level - 1;
    } else {
      return Math.max(count(node.left, level + 1),
                      count(node.right, level + 1));
    }
  }

  /**
   * Returns the number of visible leftmost nodes.
   * <p>
   * As soon as a level exists, a leftmost node can be found. Therefore, the number of visible leftmost nodes is equal
   * to the tree depth.
   *
   * @param root a root node
   *
   * @return the number of visible leftmost nodes
   */
  int visibleNodes(final MutableBinaryNode root) {
    return count(root, 1);
  }
}
