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

/**
 * <b>Change in a Foreign Currency</b>
 * <p>
 * You likely know that different currencies have coins and bills of different denominations. In some currencies, it's
 * actually impossible to receive change for a given amount of money. For example, Canada has given up the 1-cent penny.
 * If you're owed 94 cents in Canada, a shopkeeper will graciously supply you with 95 cents instead since there exists a
 * 5-cent coin.
 * <p>
 * Given a list of the available denominations, determine if it's possible to receive exact change for an amount of
 * money {@code targetMoney}. Both the denominations and target amount will be given in generic units of that currency.
 */
class ChangeForeignCurrency {

  /**
   * Accumulates sums of all coin combinations and exit when target amount is reached or exceeded.
   *
   * @param targetMoney a target money amount
   * @param denominations an array of available denomination
   * @param accumulator an accumulated sum
   *
   * @return {@code true} if it's possible, {@code false} otherwise.
   */
  private boolean canGetExactChange(final int targetMoney, final int[] denominations, final int accumulator) {
    if (accumulator == targetMoney) {
      return true;
    }

    if (accumulator > targetMoney) {
      return false;
    }

    for (final int denomination : denominations) {
      if (canGetExactChange(targetMoney, denominations, accumulator + denomination)) {
        return true;
      }
    }

    return false;
  }

  /**
   * Given a list of the available denominations, determine if it's possible to receive exact change for an amount of
   * money {@code targetMoney}.
   *
   * @param targetMoney a target money amount
   * @param denominations an array of available denomination
   *
   * @return {@code true} if it's possible, {@code false} otherwise.
   */
  boolean canGetExactChange(final int targetMoney, final int[] denominations) {
    return canGetExactChange(targetMoney, denominations, 0);
  }
}
