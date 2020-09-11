package zigzag ;

public class ZigZag {
	
/*
Good morning! Here's your coding interview problem for today.

This problem was asked by PayPal.

Given a string and a number of lines k, print the string in zigzag form. In
zigzag, characters are printed out diagonally from top left to bottom right
until reaching the kth line, then back up to top right, and so on. 

For example, given the sentence "thisisazigzag" and k = 4, you should print:

t     a     g
 h   s z   a
  i i   i z
   s     g 
*/

	private String inputStr ;
	private int rows ;
	char[][] printArr ;

	public static void main( String[] args ) {

		String str ;
		int rows ;

		java.util.Scanner kb = new java.util.Scanner( System.in ) ;

		System.out.print( "Please enter a string to render as a zig-zag: " ) ;
		str = kb.nextLine() ;
		System.out.print( "How many rows would you like in the zig-zag? " ) ;
		rows = kb.nextInt() ;
		kb.nextLine() ;

		ZigZag app = new ZigZag( str , rows ) ;

		app.run() ;

		app = null ;
		kb.close() ;

	}

	public ZigZag( String str , int rows ) {

		this.inputStr = str ;
		this.rows = rows ;
		this.printArr = new char[ rows ][ str.length() ] ;

		for ( char[] row : this.printArr ) {
			java.util.Arrays.fill( row , ' ' ) ;
		}

	}

	private void run() {

		int direction = -1 ;
		// turned positive by first iteration of for-loop
		for ( int i = 0 , row = 0 ; i < this.inputStr.length() ; i++ ) {
			this.printArr[ row ][ i ] = this.inputStr.charAt( i ) ;
			if ( row == ( this.rows - 1 ) || row == 0 ) {
				direction *= -1 ;
			}
			row += direction ;
		}

		for ( char[] row : this.printArr ) {
			for ( char letter : row ) {
				System.out.print( letter ) ;
			}
			System.out.println() ;
		}

	}

}
