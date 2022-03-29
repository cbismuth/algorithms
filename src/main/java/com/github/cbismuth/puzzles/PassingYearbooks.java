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

import java.util.Arrays;

/**
 * <b>Passing Yearbooks</b>
 * <p>
 * There are n students, numbered from 1 to n, each with their own yearbook. They would like to pass their yearbooks
 * around and get them signed by other students.
 * <p>
 * You're given a list of n integers input[1..n], which is guaranteed to be a permutation of 1..n (in other words, it
 * includes the integers from 1 to n exactly once each, in some order). The meaning of this list is described below.
 * <p>
 * Initially, each student is holding their own yearbook. The students will then repeat the following two steps each
 * minute: Each student i will first sign the yearbook that they're currently holding (which may either belong to
 * themselves or to another student), and then they'll pass it to student input[i-1]. It's possible that input[i-1] = i
 * for any given i, in which case student i will pass their yearbook back to themselves. Once a student has received
 * their own yearbook back, they will hold on to it and no longer participate in the passing process.
 * <p>
 * It's guaranteed that, for any possible valid input, each student will eventually receive their own yearbook back and
 * will never end up holding more than one yearbook at a time.
 * <p>
 * You must compute a list of n integers output, whose element at i-1 is equal to the number of signatures that will be
 * present in student i's yearbook once they receive it back.
 */
class PassingYearbooks {

  /**
   * Passes yearbooks until each student is given back their own year book.
   *
   * @param passId a pass identifier
   * @param permutation a given permutation
   * @param signatures a given {@code signatures[i]} contains the signature count in yearbook of student {@code i+1}
   * @param yearbooks a given {@code yearbooks[i]} is held by student {@code i+1}
   * @param accumulator an accumulator incremented each time a student is given back his own yearbook
   */
  void passYearbooks(final int passId, final int[] permutation, final int[] signatures, final int[] yearbooks, int accumulator) {
    final int n = permutation.length;

    if (accumulator == n) {
      return;
    }

    System.out.printf("Pass #%d:%n", passId);

    final int[] passedYearbooks = new int[n];

    for (int i = 1; i < n + 1; i++) {
      System.out.printf("\tStudent: %s%n", i);

      System.out.printf("\t\tPermutation: %s%n", Arrays.toString(permutation));
      System.out.printf("\t\tSignature counts: %s%n", Arrays.toString(signatures));
      System.out.printf("\t\tYearbooks: %s%n", Arrays.toString(yearbooks));
      System.out.printf("\t\tPassed yearbooks: %s%n", Arrays.toString(passedYearbooks));

      final boolean doPassYearbook;
      if (i == yearbooks[i - 1]) {
        if (signatures[i - 1] == 0) {
          System.out.printf("\t\tStudent %d holds his own yearbook without any signature: he signs it%n", i);
          signatures[i - 1] += 1;
          doPassYearbook = true;
        } else {
          System.out.printf("\t\tStudent %d holds his own yearbook with %d signature(s): he holds on it and no longer participates%n", i, signatures[i - 1]);
          passedYearbooks[i - 1] = yearbooks[i - 1];
          doPassYearbook = false;
          accumulator++;
        }
      } else {
        System.out.printf("\t\tStudent %d holds yearbook of student %d: he signs it%n", i, yearbooks[i - 1]);
        signatures[yearbooks[i - 1] - 1] += 1;
        doPassYearbook = true;
      }

      if (doPassYearbook) {
        final int student = permutation[i - 1];

        System.out.printf("\t\tStudent %d passes yearbook of student %d to student %d%n", i, yearbooks[i - 1], student);
        passedYearbooks[student - 1] = yearbooks[i - 1];
      }
    }

    passYearbooks(passId + 1, permutation, signatures, passedYearbooks, accumulator);
  }

  /**
   * Finds signature counts from a given permutation.
   * <p>
   * Cyclomatic complexity is O(n+n^2)=<b>O(n^2)</b> as each student may sign at most all yearbooks once.
   * <p>
   * Worst case is {@code n} recursions each one containing a loop of {@code n} iterations, plus initialization loop.
   *
   * @param permutation a permutation
   *
   * @return the array containing signature counts
   */
  int[] findSignatureCounts(final int[] permutation) {
    final int[] signatures = new int[permutation.length];

    final int[] yearbooks = new int[permutation.length];

    // Initially each student is holding their own yearbook
    for (int i = 0; i < yearbooks.length; i++) {
      yearbooks[i] = i + 1;
    }

    passYearbooks(1, permutation, signatures, yearbooks, 0);

    return signatures;
  }
}
