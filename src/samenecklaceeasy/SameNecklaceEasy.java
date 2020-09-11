package samenecklaceeasy ;

import java.util.ArrayList ;

public class SameNecklaceEasy {

	public static void main( String[] args ) {

		/*
		 * via https://www.reddit.com/r/dailyprogrammer/comments/ffxabb/
		 * 20200309_challenge_383_easy_necklace_matching/ , retrieved 9/10/2020. Main
		 * challenge done, bonuses not done as of 9/10 as I started this late in the
		 * evening.
		 * 
		 * [2020-03-09] Challenge #383 [Easy] Necklace matching Challenge Imagine a
		 * necklace with lettered beads that can slide along the string. Here's an
		 * example image. In this example, you could take the N off NICOLE and slide it
		 * around to the other end to make ICOLEN. Do it again to get COLENI, and so on.
		 * For the purpose of today's challenge, we'll say that the strings "nicole",
		 * "icolen", and "coleni" describe the same necklace.
		 * 
		 * Generally, two strings describe the same necklace if you can remove some
		 * number of letters from the beginning of one, attach them to the end in their
		 * original ordering, and get the other string. Reordering the letters in some
		 * other way does not, in general, produce a string that describes the same
		 * necklace.
		 * 
		 * Write a function that returns whether two strings describe the same necklace.
		 * 
		 * Examples same_necklace("nicole", "icolen") => true same_necklace("nicole",
		 * "lenico") => true same_necklace("nicole", "coneli") => false
		 * same_necklace("aabaaaaabaab", "aabaabaabaaa") => true same_necklace("abc",
		 * "cba") => false same_necklace("xxyyy", "xxxyy") => false
		 * same_necklace("xyxxz", "xxyxz") => false same_necklace("x", "x") => true
		 * same_necklace("x", "xx") => false same_necklace("x", "") => false
		 * same_necklace("", "") => true Optional Bonus 1 If you have a string of N
		 * letters and you move each letter one at a time from the start to the end,
		 * you'll eventually get back to the string you started with, after N steps.
		 * Sometimes, you'll see the same string you started with before N steps. For
		 * instance, if you start with "abcabcabc", you'll see the same string
		 * ("abcabcabc") 3 times over the course of moving a letter 9 times.
		 * 
		 * Write a function that returns the number of times you encounter the same
		 * starting string if you move each letter in the string from the start to the
		 * end, one at a time.
		 * 
		 * repeats("abc") => 1 repeats("abcabcabc") => 3 repeats("abcabcabcx") => 1
		 * repeats("aaaaaa") => 6 repeats("a") => 1 repeats("") => 1 Optional Bonus 2
		 * There is exactly one set of four words in the enable1 word list that all
		 * describe the same necklace. Find the four words.
		 */

		String str1 ;
		String str2 ;

		java.util.Scanner kb = new java.util.Scanner( System.in ) ;
		System.out.print( "Enter the first word: " ) ;
		str1 = kb.nextLine().toUpperCase() ;
		System.out.print( "Enter the second word: " ) ;
		str2 = kb.nextLine().toUpperCase() ;

		SameNecklaceEasy test = new SameNecklaceEasy() ;
		test.testNecklaces( str1 , str2 ) ;

		test = null ;
		kb.close() ;

	}

	private void testNecklaces( String necklace1 , String necklace2 ) {

		String sameNotSame = "" ;

		if ( !sameNecklace( necklace1 , necklace2 ) ) {
			sameNotSame += "NOT " ;
		}
		System.out.printf( "%s and %s are %son the same necklace%n" , necklace1 , necklace2 , sameNotSame ) ;

	}

	private boolean sameNecklace( String necklace1 , String necklace2 ) {

		int necklaceLength = necklace1.length() ;

		if ( necklaceLength != necklace2.length() ) {
			return false ;
		}

		ArrayList < Character > letters2 ;
		ArrayList < Character > letters1 = new ArrayList < Character >() ;

		for ( int i = 0 ; i < necklaceLength ; i++ ) {
			letters1.add( necklace1.toCharArray()[ i ] ) ;
		}

		for ( int shift = 0 ; shift < necklaceLength ; shift++ ) {
			letters2 = new ArrayList < Character >() ;
			for ( int i = 0 ; i < necklaceLength ; i++ ) {
				letters2.add( necklace2.toCharArray()[ ( shift + i ) % necklaceLength ] ) ;
			}
			if ( letters2.equals( letters1 ) ) {
				return true ;
			}
		}
		return false ;

	}

}
