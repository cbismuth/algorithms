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

/**
 * <b>1 Billion Users</b>
 * <p>
 * We have {@code N} different apps with different user growth rates. At a given time {@code t}, measured in days, the
 * number of users using an app is {@code g^t} (for simplicity we'll allow fractional users), where {@code g} is the
 * growth rate for that app. These apps will all be launched at the same time and no user ever uses more than one of the
 * apps. We want to know how many total users there are when you add together the number of users from each app.
 * <p>
 * After how many full days will we have 1 billion total users across the {@code N} apps?
 */
class OneBillionUsers {

  /**
   * Determines how many full days will we have 1 billion total users across the {@code N} apps.
   *
   * @param growthRates an array of growth rates
   *
   * @return the number of days
   */
  int getBillionUsersDay(final float[] growthRates) {
    int days = 1;

    while (true) {
      int users = 0;

      for (final float growthRate : growthRates) {
        users += Math.pow(growthRate, days);
      }

      if (users > 1_000_000_000) {
        break;
      }

      days += 1;
    }

    return days;
  }
}
