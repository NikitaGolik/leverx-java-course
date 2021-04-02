package by.golik.tictactoe.entity;

/**
 * @author Nikita Golik
 */
public enum Figure {
    X {
        public String toString() {
            return "X";
        }
    },
    O {
        public String toString() {
            return "Y";
        }
    },
    EMPTY {
        public String toString() {
            return "_";
        }
    }
}
