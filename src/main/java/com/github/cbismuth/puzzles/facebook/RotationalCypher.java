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
 * <b>Rotational Cipher</b>
 * <p>
 * One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a
 * character means replacing it with another character that is a certain number of steps away in normal alphabetic or
 * numerical order.
 * <p>
 * For example, if the string {@code Zebra-493?} is rotated 3 places, the resulting string is {@code Cheud-726?}. Every
 * alphabetic character is replaced with the character 3 letters higher (wrapping around from {@code Z} to {@code A}),
 * and every numeric character replaced with the character 3 digits higher (wrapping around from {@code 9} to
 * {@code 0}). Note that the non-alphanumeric characters remain unchanged.
 * <p>
 * Given a string and a rotation factor, return an encrypted string.
 */
class RotationalCypher {

  /**
   * Encrypts a string by rotating each alphanumeric character.
   * <p>
   * Cyclomatic complexity is {@code O(n)} as the input string characters have to be iterated over only once. Besides,
   * no initial copy of the input string is required.
   *
   * @param input an input string
   * @param rotationFactor a rotation factor
   *
   * @return the encrypted string
   */
  String rotationalCipher(final String input, final int rotationFactor) {
    System.out.printf("Encrypting input string [%s] ...%n", input);

    final char[] inputChars = input.toCharArray();
    final char[] encryptedChars = new char[inputChars.length];
    for (int i = 0; i < encryptedChars.length; i++) {
      encryptedChars[i] = encryptChar(rotationFactor, 'a', 'z', inputChars[i]);
      encryptedChars[i] = encryptChar(rotationFactor, 'A', 'Z', encryptedChars[i]);
      encryptedChars[i] = encryptChar(rotationFactor, '0', '9', encryptedChars[i]);
    }

    final String encrypted = String.valueOf(encryptedChars);
    System.out.printf("Input string [%s] successfully encrypted to [%s]%n", input, encrypted);

    return encrypted;
  }

  /**
   * Encrypts a single character.
   *
   * @param rotationFactor a rotation factor
   * @param startChar an alphanumeric start character
   * @param endChar an alphanumeric end character
   * @param inputChar an input character
   *
   * @return the encrypted character
   */
  private char encryptChar(final int rotationFactor,
                           final char startChar,
                           final char endChar,
                           final char inputChar) {
    final char encryptedChar;

    if (inputChar >= startChar && inputChar <= endChar) {
      // Trailing `+ 1` as arrays are 0-based in Java
      final int effectiveRotationFactor = rotationFactor % (endChar - startChar + 1);

      final char tmp = (char) (inputChar + effectiveRotationFactor);
      if (tmp > endChar) {
        // Trailing `- 1` as arrays are 0-based in Java
        encryptedChar = (char) (tmp - endChar + startChar - 1);
      } else {
        encryptedChar = tmp;
      }

      System.out.printf("input char [%c] within [%c] and [%c] and encrypted to [%c] with a rotation factor of [%d] (effective of: [%d])%n",
                        inputChar, startChar, endChar, encryptedChar, rotationFactor, effectiveRotationFactor);
    } else {
      encryptedChar = inputChar;
    }

    return encryptedChar;
  }
}
