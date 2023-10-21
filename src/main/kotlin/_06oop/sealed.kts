// suits: clubs (♣), diamonds (♦), hearts (♥), and spades (♠).
sealed class Card(val suit: Suit)

enum class Suit(val char: String){
    CLUBS("♣"),
    DIAMONDS("♦"),
    HEARTS("♥"),
    SPADES("♠");

    override fun toString(): String {
        return "$name, $char"
    }
}

// 2-10
class Pip(val number: Int, suit: Suit) : Card(suit) {
    init {
        if (number < 2 || number > 10) {
            throw RuntimeException("Illegal pip.")
        }
    }
}

// jack
class Jack(suit: Suit) : Card(suit) {
    override fun toString(): String {
        return "Jack of $suit"
    }
}

// queen
class Queen(suit: Suit) : Card(suit) {
    override fun toString(): String {
        return "Queen of $suit"
    }
}

// king
class King(suit: Suit) : Card(suit) {
    override fun toString(): String {
        return "King of $suit"
    }
}

// ace
class Ace(suit: Suit) : Card(suit)

fun processCard(card: Card) =
    when (card) {
        is Pip -> "${card.number} of ${card.suit}"
        is Jack, is Queen, is King -> "${card}"
        is Ace -> "${card.javaClass.simpleName} of ${card.suit}"
        else -> ""
    }

println(processCard(Pip(2, Suit.SPADES)))
println(processCard(Jack(Suit.CLUBS)))
println(processCard(Ace(Suit.DIAMONDS)))
/*
2 of SPADES, ♠
Jack of CLUBS, ♣
Ace of DIAMONDS, ♦
*/