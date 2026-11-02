import java.util.Random;

/**
 * 1 object of this class represents driver program that demonstrates queues of playing cards
 * The program displays cards in first-in-first-out order, uses one double ended queue as a stack, a queue, and a mixture of both
 *
 * @author Ryan Dennis
 * @author Atharv Dua
 */
public class Foothill {
    /**
     * runs the demonstrations for both assignment options
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        demonstrateOptionA();
        demonstrateOptionB();
    }

    /**
     * displays a queue of cards then removes them in order and catches attempts to remove from the empty queue
     */
    private static void demonstrateOptionA() {
        CardQueue queue = new CardQueue();
        queue.addCard(new Card('A', Card.Suit.spades));
        queue.addCard(new Card('2', Card.Suit.hearts));
        queue.addCard(new Card('3', Card.Suit.hearts));
        queue.addCard(new Card('4', Card.Suit.clubs));

        System.out.println("Option A: card queue");
        System.out.println("Queue from oldest to youngest: " + queue);
        System.out.println("Removing from the front:");
        try {
            for (int i = 0; i < 6; i++) {
                System.out.println(queue.removeCard());
            }
        } catch (QueueEmptyException exception) {
            System.out.println("Caught QueueEmptyException: " + exception.getMessage());
        }
        System.out.println("Empty queue: [" + queue + "]");
        queue.addCard(new Card('K', Card.Suit.diamonds));
        try {
            System.out.println("Reused queue: " + queue.removeCard());
        } catch (QueueEmptyException exception) {
            System.out.println("Caught QueueEmptyException: " + exception.getMessage());
        }
    }

    /**
     * uses a single double ended queue as a stack and a queue then performs mixed operations at both ends
     */
    private static void demonstrateOptionB() {
        DEQueue queue = new DEQueue();
        Card[] cards = {
            new Card('A', Card.Suit.spades),
            new Card('2', Card.Suit.hearts),
            new Card('3', Card.Suit.hearts),
            new Card('4', Card.Suit.clubs)
        };

        System.out.println("\nOption B: one double ended queue");
        System.out.println("Stack: add to front, remove from front");
        for (Card card : cards) {
            queue.addToFront(new CardNode2(card));
        }
        System.out.println("Front to back: " + queue);
        try {
            for (int i = 0; i < cards.length; i++) {
                System.out.println(queue.removeFromFront());
            }

            System.out.println("Queue: add to back, remove from front");
            for (Card card : cards) {
                queue.addToBack(new CardNode2(card));
            }
            System.out.println("Front to back: " + queue);
            for (int i = 0; i < cards.length; i++) {
                System.out.println(queue.removeFromFront());
            }
        } catch (QueueEmptyException exception) {
            System.out.println("Caught QueueEmptyException: " + exception.getMessage());
        }

        demonstrateMixedOperations(queue);
        System.out.println("Drain from back:");
        try {
            while (true) {
                System.out.println(queue.removeFromBack());
            }
        } catch (QueueEmptyException exception) {
            System.out.println("Caught QueueEmptyException at back: " + exception.getMessage());
        }
        try {
            queue.removeFromFront();
        } catch (QueueEmptyException exception) {
            System.out.println("Caught QueueEmptyException at front: " + exception.getMessage());
        }
        System.out.println("Empty double ended queue: [" + queue + "]");
    }

    /**
     * performs a repeatable random sequence of additions and removals at both ends and displays each result
     *
     * @param queue the double ended queue used by the earlier demonstrations
     */
    private static void demonstrateMixedOperations(DEQueue queue) {
        Random random = new Random(5);
        System.out.println("Mixed operations:");
        for (int i = 0; i < 16; i++) {
            int operation = random.nextInt(4);
            try {
                if (operation == 0 || operation == 1) {
                    Card card = new Card(Card.RANKS[i % Card.NUM_RANKS],
                            Card.Suit.values()[i % Card.NUM_SUITS]);
                    if (operation == 0) {
                        queue.addToFront(new CardNode2(card));
                        System.out.println("Add to front: " + card);
                    } else {
                        queue.addToBack(new CardNode2(card));
                        System.out.println("Add to back: " + card);
                    }
                } else if (operation == 2) {
                    System.out.println("Remove from front: " + queue.removeFromFront());
                } else {
                    System.out.println("Remove from back: " + queue.removeFromBack());
                }
            } catch (QueueEmptyException exception) {
                System.out.println("Caught QueueEmptyException during mixed removal: "
                        + exception.getMessage());
            }
            System.out.println("Front to back: [" + queue + "]");
        }
    }
}

/**
 * One object of this class represents a single playing card having a rank and a suit
 * A card can be constructed or copied then its rank and suit can be read or replaced while validation controls its error flag and display
 *
 * @author Ryan Dennis
 * @author Atharv Dua
 */
class Card implements CardInterface {
    private char rank;
    private Suit suit;
    private boolean errorFlag;

    /**
     * constructs a card with the default rank and suit
     */
    public Card() {
        set(DEFAULT_RANK, DEFAULT_SUIT);
    }

    /**
     * constructs a card with the given rank and suit
     *
     * @param rank the rank for the new card
     * @param suit the suit for the new card
     */
    public Card(char rank, Suit suit) {
        set(rank, suit);
    }

    /**
     * constructs a card that i copy of the given card
     *
     * @param card the card to copy
     */
    public Card(Card card) {
        set(card.getRank(), card.getSuit());
    }

    /**
     * constructs a card with the given rank and the default suit
     *
     * @param rank the rank for the new card
     */
    public Card(char rank) {
        set(rank, DEFAULT_SUIT);
    }

    /**
     * constructs a card with the default rank and the given suit
     *
     * @param suit the suit for the new card
     */
    public Card(Suit suit) {
        set(DEFAULT_RANK, suit);
    }

    /**
     * sets the rank and suit and updates the error flag to reflect whether those values are valid
     *
     * @param rank the rank value being set to the card
     * @param suit the suit value being set to the card
     * @return true if the values that were just set were valid, false otherwise
     */
    public boolean set(char rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        errorFlag = !isValid(rank, suit);
        return !errorFlag;
    }

    /**
     * @return the card's current rank
     */
    public char getRank() {
        return rank;
    }

    /**
     * @return the card's current suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @return true if the card has any invalid internal property values, else false
     */
    public boolean isErrorFlag() {
        return errorFlag;
    }

    /**
     * @param card a card object
     * @return true if the card objects have the same internal property values, else false
     */
    public boolean equals(Card card) {
        return card != null && rank == card.rank && suit == card.suit
                && errorFlag == card.errorFlag;
    }

    /**
     * @return a non-null string representation of the card object
     */
    @Override
    public String toString() {
        if (errorFlag) {
            return "** illegal **";
        }
        return rank + " of " + suit;
    }

    /**
     * checks whether the rank is supported and the suit is present
     *
     * @param rank the rank to validate
     * @param suit the suit to validate
     * @return true if both values are valid, false otherwise
     */
    private static boolean isValid(char rank, Suit suit) {
        if (suit == null) {
            return false;
        }
        for (char allowedRank : RANKS) {
            if (rank == allowedRank) {
                return true;
            }
        }
        return false;
    }
}

/**
 * One object of this class represents a generic node with a link to its successor
 * Derived nodes can add their own data while retaining the link used by a queue
 *
 * @author Ryan Dennis
 * @author Atharv Dua
 */
class Node {
    protected Node next;

    /**
     * constructs a node with no successor
     */
    public Node() {
        next = null;
    }

    /**
     * @return a string identifying a generic node
     */
    @Override
    public String toString() {
        return "(generic node)";
    }
}

/**
 * One object of this class represents a first-in-first-out queue of linked nodes
 * Nodes are added at the tail and removed from the head while string conversion visits them from oldest to youngest
 *
 * @author Ryan Dennis
 * @author Atharv Dua
 */
class Queue {
    private Node head;
    private Node tail;

    /**
     * constructs an empty queue
     */
    public Queue() {
        head = null;
        tail = null;
    }

    /**
     * adds an unlinked node at the back of the queue and ignores a null node
     *
     * @param newNode the node to add
     */
    public void add(Node newNode) {
        if (newNode == null) {
            return;
        }
        newNode.next = null;
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    /**
     * removes the oldest node and detaches its link from the queue
     *
     * @return the removed node
     * @throws QueueEmptyException if the queue is empty
     */
    public Node remove() throws QueueEmptyException {
        if (head == null) {
            throw new QueueEmptyException();
        }
        Node removed = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        removed.next = null;
        return removed;
    }

    /**
     * @return the nodes from oldest to youngest separated by three spaces or an empty string if the queue is empty
     */
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Node current = head; current != null; current = current.next) {
            text.append(current).append("   ");
        }
        return text.toString();
    }
}

/**
 * One object of this class represents an attempt to remove a node from an empty queue
 * Queue removal methods throw this checked exception so the client can handle an empty queue
 *
 * @author Ryan Dennis
 * @author Atharv Dua
 */
class QueueEmptyException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * constructs an exception explaining that the queue is empty
     */
    public QueueEmptyException() {
        super("The queue is empty.");
    }
}

/**
 * One object of this class represents a node containing a playing card
 * A CardNode is a Node and uses the card's own string conversion to display its data
 *
 * @author Ryan Dennis
 * @author Atharv Dua
 */
class CardNode extends Node {
    private Card data;

    /**
     * constructs a node containing the given card
     *
     * @param card the card to store
     */
    public CardNode(Card card) {
        data = card;
    }

    /**
     * @return the card stored in the node
     */
    public Card getData() {
        return data;
    }

    /**
     * @return the stored card's string representation
     */
    @Override
    public String toString() {
        return data.toString();
    }
}

/**
 * One object of this class represents a first-in-first-out queue of playing cards
 * A CardQueue is a Queue and wraps cards in CardNode objects to use the inherited linking operations
 *
 * @author Ryan Dennis
 * @author Atharv Dua
 */
class CardQueue extends Queue {
    /**
     * adds a card at the back of the queue and ignores a null card
     *
     * @param card the card to add
     */
    public void addCard(Card card) {
        if (card != null) {
            super.add(new CardNode(card));
        }
    }

    /**
     * removes the card that has been in the queue the longest
     *
     * @return the removed card
     * @throws QueueEmptyException if the queue is empty
     */
    public Card removeCard() throws QueueEmptyException {
        return ((CardNode) super.remove()).getData();
    }
}

/**
 * One object of this class represents a node with links to both its successor and predecessor
 * A Node2 is a Node and adds a backward link so a double ended queue can remove from either end
 *
 * @author Ryan Dennis
 * @author Atharv Dua
 */
class Node2 extends Node {
    protected Node prev;

    /**
     * constructs a node with no predecessor or successor
     */
    public Node2() {
        prev = null;
    }
}

/**
 * One object of this class represents a playing card in a node with forward and backward links
 * A CardNode2 is a Node2 and delegates display of its data to the stored card
 *
 * @author Ryan Dennis
 * @author Atharv Dua
 */
class CardNode2 extends Node2 {
    private Card data;

    /**
     * constructs a node containing the given card
     *
     * @param card the card to store
     */
    public CardNode2(Card card) {
        data = card;
    }

    /**
     * @return the card stored in the node
     */
    public Card getData() {
        return data;
    }

    /**
     * @return the stored card's string representation
     */
    @Override
    public String toString() {
        return data.toString();
    }
}

/**
 * One object of this class represents a double ended queue of nodes linked in both directions
 * The head and tail allow additions and removals at either end without traversing the queue
 *
 * @author Ryan Dennis
 * @author Atharv Dua
 */
class DEQueue {
    private Node2 head;
    private Node2 tail;

    /**
     * constructs an empty double ended queue
     */
    public DEQueue() {
        head = null;
        tail = null;
    }

    /**
     * adds unlinked node at the back and ignores a null node
     *
     * @param newNode the node to add
     */
    public void addToBack(Node2 newNode) {
        if (newNode == null) {
            return;
        }
        newNode.next = null;
        newNode.prev = tail;
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    /**
     * adds unlinked node at the front and ignores a null node
     *
     * @param newNode the node to add
     */
    public void addToFront(Node2 newNode) {
        if (newNode == null) {
            return;
        }
        newNode.prev = null;
        newNode.next = head;
        if (head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
    }

    /**
     * removes the front node and detaches both of its links
     *
     * @return the removed node
     * @throws QueueEmptyException if the queue is empty
     */
    public Node2 removeFromFront() throws QueueEmptyException {
        if (head == null) {
            throw new QueueEmptyException();
        }
        Node2 removed = head;
        head = (Node2) head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        removed.next = null;
        removed.prev = null;
        return removed;
    }

    /**
     * removes the back node and detaches both of its links
     *
     * @return the removed node
     * @throws QueueEmptyException if the queue is empty
     */
    public Node2 removeFromBack() throws QueueEmptyException {
        if (tail == null) {
            throw new QueueEmptyException();
        }
        Node2 removed = tail;
        tail = (Node2) tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        removed.next = null;
        removed.prev = null;
        return removed;
    }

    /**
     * @return the nodes from front to back separated by three spaces or an empty string if the queue is empty
     */
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Node current = head; current != null; current = current.next) {
            text.append(current).append("   ");
        }
        return text.toString();
    }
}

/*
Option A: card queue
Queue from oldest to youngest: A of spades   2 of hearts   3 of hearts   4 of clubs   
Removing from the front:
A of spades
2 of hearts
3 of hearts
4 of clubs
Caught QueueEmptyException: The queue is empty.
Empty queue: []
Reused queue: K of diamonds

Option B: one double ended queue
Stack: add to front, remove from front
Front to back: 4 of clubs   3 of hearts   2 of hearts   A of spades   
4 of clubs
3 of hearts
2 of hearts
A of spades
Queue: add to back, remove from front
Front to back: A of spades   2 of hearts   3 of hearts   4 of clubs   
A of spades
2 of hearts
3 of hearts
4 of clubs
Mixed operations:
Caught QueueEmptyException during mixed removal: The queue is empty.
Front to back: []
Add to front: 3 of diamonds
Front to back: [3 of diamonds   ]
Add to front: 4 of hearts
Front to back: [4 of hearts   3 of diamonds   ]
Remove from front: 4 of hearts
Front to back: [3 of diamonds   ]
Add to back: 6 of clubs
Front to back: [3 of diamonds   6 of clubs   ]
Remove from back: 6 of clubs
Front to back: [3 of diamonds   ]
Add to back: 8 of hearts
Front to back: [3 of diamonds   8 of hearts   ]
Remove from back: 8 of hearts
Front to back: [3 of diamonds   ]
Add to back: T of clubs
Front to back: [3 of diamonds   T of clubs   ]
Add to back: J of diamonds
Front to back: [3 of diamonds   T of clubs   J of diamonds   ]
Remove from front: 3 of diamonds
Front to back: [T of clubs   J of diamonds   ]
Remove from back: J of diamonds
Front to back: [T of clubs   ]
Add to back: A of clubs
Front to back: [T of clubs   A of clubs   ]
Add to back: X of diamonds
Front to back: [T of clubs   A of clubs   X of diamonds   ]
Remove from back: X of diamonds
Front to back: [T of clubs   A of clubs   ]
Remove from back: A of clubs
Front to back: [T of clubs   ]
Drain from back:
T of clubs
Caught QueueEmptyException at back: The queue is empty.
Caught QueueEmptyException at front: The queue is empty.
Empty double ended queue: []
*/
