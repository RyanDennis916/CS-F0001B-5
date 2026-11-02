/**
 * Interface for cards.
 * 
 * @author Baba Kofi Weusijana
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CardInterface {
	/**
	 * The suits of a card.
	 */
	public enum Suit {
		/**
		 * club suit such as ♣
		 */
		clubs,
		/**
		 * diamond suit such as ♦
		 */
		diamonds,
		/**
		 * heart suit such as ♥
		 */
		hearts,
		/**
		 * spade suit such as ♠
		 */
		spades
	}

	/**
	 * The ranks of a card. 'T' is for 10, 'J' is for Jacks, and 'X' is for Jokers.
	 */
	public static final char[] RANKS = { '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A', 'X' };
	/**
	 * The default rank for a card.
	 */
	public static final char DEFAULT_RANK = 'A';
	/**
	 * The default suit for a card.
	 */
	public static final Suit DEFAULT_SUIT = Suit.spades;
	/**
	 * The total number of possible ranks a card can have.
	 */
	public static final int NUM_RANKS = RANKS.length;
	/**
	 * The total number of possible suite a card can have.
	 */
	public static final int NUM_SUITS = Suit.values().length;

	/**
	 * @param card A card object
	 * @return true if the card objects have the same internal property values,
	 *         false otherwise
	 */
	public boolean equals(Card card);

	/**
	 * @return The card's current rank
	 */
	public char getRank();

	/**
	 * @return The card's current suit
	 */
	public Suit getSuit();

	/**
	 * @return true if the card has any invalid internal property values, false
	 *         otherwise
	 */
	public boolean isErrorFlag();

	/**
	 * Set's the rank and suit of the card and returns true if the values that were
	 * just set were valid, false otherwise.
	 * 
	 * @param rank The rank value being set to the card.
	 * @param suit The suit value being set to the card.
	 * @return true if the values that were just set were valid, false otherwise
	 */
	public boolean set(char rank, Suit suit);

	/**
	 * @return Returns a string non-null representation of the card object.
	 */
	public String toString();
}
