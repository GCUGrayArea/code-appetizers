package samenecklaceeasy ;

import java.util.ArrayList ;

public class SameNecklaceEasy {

	public static void main( String[] args ) {

		String str1 ;
		String str2 ;

		java.util.Scanner kb = new java.util.Scanner( System.in ) ;
		System.out.print( "Enter the first word: " ) ;
		str1 = kb.nextLine().toUpperCase() ;
		System.out.print( "Enter the second word: " ) ;
		str2 = kb.nextLine().toUpperCase() ;

		SameNecklaceEasy test = new SameNecklaceEasy();
		test.testNecklaces( str1 , str2 );

		test = null ;
		kb.close() ;

	}

	private void testNecklaces( String necklace1 , String necklace2 ) {

		String sameNotSame = "" ;

		if ( !sameNecklace( necklace1 , necklace2 ) ) {
			sameNotSame += "NOT " ;
		}
		System.out.printf( 
				"%s and %s are %son the same necklace%n" ,
				necklace1 , 
				necklace2 , 
				sameNotSame ) ;

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
