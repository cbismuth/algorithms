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

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b>Encrypted Words</b>
 * <p>
 * You've devised a simple encryption method for alphabetic strings that shuffles the characters in such a way that the
 * resulting string is hard to quickly read, but is easy to convert back into the original string.
 * <p>
 * When you encrypt a string {@code S}, you start with an initially-empty resulting string {@code R} and append
 * characters to it as follows:
 * <ul>
 *   <li>Append the middle character of {@code S} (if {@code S} has even length, then we define the middle character as the left-most of the two central characters)</li>
 *   <li>Append the encrypted version of the substring of {@code S} that's to the left of the middle character (if non-empty)</li>
 *   <li>Append the encrypted version of the substring of {@code S} that's to the right of the middle character (if non-empty)</li>
 * </ul>
 * <p>
 * For example, to encrypt the string {@code "abc"}, we first take {@code "b"}, and then append the encrypted version of {@code "a"} (which is just {@code "a"}) and the encrypted version of {@code "c"} (which is just {@code "c"}) to get {@code "bac"}.
 * <p>
 * If we encrypt {@code "abcxcba"} we'll get {@code "xbacbca"}. That is, we take {@code "x"} and then append the encrypted version {@code "abc"} and then append the encrypted version of {@code "cba"}.
 */
class EncryptedWords {

  /**
   * Finds encrypted word in such a way that the resulting string is hard to quickly read, but is easy to convert back
   * into the original string.
   *
   * @param input an input array of characters
   * @param output an output array of characters
   * @param index an index at which to append the shuffled character in the output array
   */
  private void encrypt(final char[] input, final char[] output, final AtomicInteger index) {
    final int m;
    if (input.length % 2 == 1) {
      m = input.length / 2;
    } else {
      m = (input.length / 2) - 1;
    }

    if (m >= 0) {
      output[index.getAndIncrement()] = input[m];

      if (input.length > 1) {
        encrypt(Arrays.copyOfRange(input, 0, m), output, index);
        encrypt(Arrays.copyOfRange(input, m + 1, input.length), output, index);
      }
    }
  }

  /**
   * Finds encrypted word in such a way that the resulting string is hard to quickly read, but is easy to convert back
   * into the original string.
   *
   * @param s a string to encrypt
   *
   * @return the encrypted string
   */
  String findEncryptedWord(final String s) {
    final char[] input = s.toCharArray();
    final char[] output = new char[s.length()];

    encrypt(input, output, new AtomicInteger());

    return String.valueOf(output);
  }
}
