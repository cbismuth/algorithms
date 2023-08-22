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

import java.util.Arrays;

/**
 * @see <a href="https://www.metacareers.com/profile/coding_puzzles/?puzzle=203188678289677">Cafetaria</a>
 */
public class Cafetaria {

  public long getMaxAdditionalDinersCount(final long N, final long K, final int M, final long[] S) {
    long count = 0;

    Arrays.sort(S);

    count += (S[0] - 1) / (1 + K);

    for (int i = 0; i < S.length - 1; i++) {
      count += Math.max(0, S[i + 1] - S[i] - 1 - K) / (1 + K);
    }

    count += (N - S[S.length - 1]) / (1 + K);

    return count;
  }
}
