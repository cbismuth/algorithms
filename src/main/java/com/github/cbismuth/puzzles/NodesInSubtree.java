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

import com.github.cbismuth.puzzles.utils.IntCharQuery;
import com.github.cbismuth.puzzles.utils.MutableNode;

import java.util.Arrays;
import java.util.List;

/**
 * <b>Nodes in a Subtree</b>
 * <p>
 * You are given a tree that contains {@code N} nodes, each containing an integer {@code u} which corresponds to a
 * lowercase character {@code c} in the string s using 1-based indexing.
 * <p>
 * You are required to answer {@code Q} queries of type {@code [u, c]}, where {@code u} is an integer and {@code c} is a
 * lowercase letter. The query result is the number of nodes in the subtree of node {@code u} containing {@code c}.
 */
class NodesInSubtree {

  /**
   * Determines the number of nodes in the subtree of node {@code u} containing {@code c}.
   *
   * @param node a node
   * @param queries an array of queries to match
   * @param chars an array of characters to decode nodes
   * @param queryMatchCounts an array of query match counts
   * @param queryMatchMinLevels an array of query root match levels
   * @param level a level
   */
  private void countOfNodes(final MutableNode node,
                            final IntCharQuery[] queries,
                            final char[] chars,
                            final int[] queryMatchCounts,
                            final int[] queryMatchMinLevels,
                            final int level) {
    final int u = node.getData();
    final char c = chars[u - 1];

    for (int i = 0; i < queries.length; i++) {
      if (queries[i].getC() == c) {
        if (queries[i].getU() == u) {
          queryMatchCounts[i] = queryMatchCounts[i] + 1;
          queryMatchMinLevels[i] = level;
        } else if (queryMatchMinLevels[i] >= 0 && queryMatchMinLevels[i] < level) {
          queryMatchCounts[i] = queryMatchCounts[i] + 1;
        }
      }
    }

    for (final MutableNode child : node.getChildren()) {
      countOfNodes(child, queries, chars, queryMatchCounts, queryMatchMinLevels, level + 1);
    }
  }

  /**
   * Determines the number of nodes in the subtree of node {@code u} containing {@code c}.
   *
   * @param root a root node
   * @param queries a list of queries to match
   * @param string a string to decode nodes
   *
   * @return the array of query match counts
   */
  int[] countOfNodes(final MutableNode root, final List<IntCharQuery> queries, final String string) {
    final int[] queryMatchCounts = new int[queries.size()];

    final int[] queryMatchMinLevels = new int[queries.size()];
    Arrays.fill(queryMatchMinLevels, -1);

    final int rootLevel = 0;

    countOfNodes(root,
                 queries.toArray(new IntCharQuery[0]),
                 string.toCharArray(),
                 queryMatchCounts,
                 queryMatchMinLevels,
                 rootLevel);

    return queryMatchCounts;
  }
}
