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

package com.github.cbismuth.puzzles.facebook.utils;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * This class represents a pair of values.
 *
 * @param <L> the type of the left value
 * @param <R> the type of the right value
 */
public class MutablePair<L, R> {

  private L left;
  private R right;

  public MutablePair(final L left, final R right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final MutablePair<?, ?> that = (MutablePair<?, ?>) o;
    return Objects.equals(left, that.left) && Objects.equals(right, that.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, right);
  }

  /**
   * Sets the values of this pair.
   *
   * @param left a left value
   * @param right a right value
   */
  public void set(final L left, final R right) {
    this.left = left;
    this.right = right;
  }

  /**
   * Returns the left value of this pair.
   *
   * @return the left value
   */
  public L getLeft() {
    return left;
  }

  /**
   * Returns the right value of this pair.
   *
   * @return the right value
   */
  public R getRight() {
    return right;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ").add("left=" + left)
                                 .add("right=" + right)
                                 .toString();
  }
}
