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

/**
 * @see <a href="https://www.metacareers.com/profile/coding_puzzles/?puzzle=1082217288848574">All Wrong</a>
 */
public class AllWrong {

  public String getWrongAnswers(final int N, final String C) {
    final StringBuilder s = new StringBuilder();

    if (N > 0 && C != null) {
      for (int i = 0; i < N && i < C.length(); i++) {
        if (C.charAt(i) == 'A') {
          s.append("B");
        } else {
          s.append("A");
        }
      }
    }

    return s.toString();
  }
}
