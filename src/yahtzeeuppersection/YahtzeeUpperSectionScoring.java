package yahtzeeuppersection ;

public class YahtzeeUpperSectionScoring {
	/*
	 * [2019-11-11] Challenge #381 [Easy] Yahtzee Upper Section Scoring Description
	 * The game of Yahtzee is played by rolling five 6-sided dice, and scoring the
	 * results in a number of ways. You are given a Yahtzee dice roll, represented
	 * as a sorted list of 5 integers, each of which is between 1 and 6 inclusive.
	 * Your task is to find the maximum possible score for this roll in the upper
	 * section of the Yahtzee score card. Here's what that means.
	 * 
	 * For the purpose of this challenge, the upper section of Yahtzee gives you six
	 * possible ways to score a roll. 1 times the number of 1's in the roll, 2 times
	 * the number of 2's, 3 times the number of 3's, and so on up to 6 times the
	 * number of 6's. For instance, consider the roll [2, 3, 5, 5, 6]. If you scored
	 * this as 1's, the score would be 0, since there are no 1's in the roll. If you
	 * scored it as 2's, the score would be 2, since there's one 2 in the roll.
	 * Scoring the roll in each of the six ways gives you the six possible scores:
	 * 
	 * 0 2 3 0 10 6 The maximum here is 10 (2x5), so your result should be 10.
	 * 
	 * Examples yahtzee_upper([2, 3, 5, 5, 6]) => 10 yahtzee_upper([1, 1, 1, 1, 3])
	 * => 4 yahtzee_upper([1, 1, 1, 3, 3]) => 6 yahtzee_upper([1, 2, 3, 4, 5]) => 5
	 * yahtzee_upper([6, 6, 6, 6, 6]) => 30
	 */

	private int[] diceCount ;

	public YahtzeeUpperSectionScoring( int[] inputArr ) {

		this.diceCount = this.countDice( inputArr ) ;

	}

	public static void main( String[] args ) {

		int[] dice = new int[ 5 ] ;
		java.util.Scanner kb = new java.util.Scanner( System.in ) ;

		for ( int i = 0 ; i < dice.length ; i++ ) {
			System.out.printf( "Enter die %d of %d: " , i + 1 , dice.length ) ;
			dice[ i ] = kb.nextInt() ;
			kb.nextLine() ;
		}

		YahtzeeUpperSectionScoring app = new YahtzeeUpperSectionScoring( dice ) ;
		app.score() ;

		app = null ;
		kb.close() ;

	}

	private int[] countDice( int[] inputArr ) {

		int count = 0 ;
		int[] outputArr = new int[ 6 ] ;
		for ( int i = 1 ; i <= 6 ; i++ ) {
			for ( int die = 0 ; die < inputArr.length ; die++ ) {
				if ( inputArr[ die ] == i ) {
					count++ ;
				}
			}
			outputArr[ i - 1 ] = count ;
			count = 0 ;
		}

		return outputArr ;

	}

	private void score() {
		int maxScoreIndex = 0;
		String plural = "";
		
		for(int i = 0; i < this.diceCount.length;i++) {
			if ((i+1)*this.diceCount[i] > this.diceCount[maxScoreIndex] * (maxScoreIndex + 1)) {
				maxScoreIndex = i;
			}
		}
		
		if ( this.diceCount[maxScoreIndex] > 1 ) {
			plural += "'s";
		}
		
		System.out.printf(
				"The highest possible score for these rolls is %d %d%s for a total of %d.%n" ,
				this.diceCount[maxScoreIndex] ,
				maxScoreIndex + 1 ,
				plural ,
				this.diceCount[maxScoreIndex] * (maxScoreIndex + 1));
	}

}
