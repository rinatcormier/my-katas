package my.rinat.codewars.codewarsstylerankingsystem;

public class User {

    int rank = -8;
    int progress = 0;

    void incProgress(int rank) {
        if (rank == 0 || rank < -8 || rank > 8) {
            throw new IllegalArgumentException();
        }
        int points = 0;
        if (((this.rank < 0 && rank < 0) || (this.rank > 0 && rank > 0)) && (this.rank - rank >= 2)) {
            points = 0;
        }
        if (((this.rank < 0 && rank < 0) || (this.rank > 0 && rank > 0)) && (this.rank - rank == 1)
                || (this.rank == 1 && rank == -1)) {
            points = 1;
        }
        if (this.rank == rank) {
            points = 3;
        }
        if (this.rank < 0 && rank > 0) {
            rank -= 1;
        }
        if (this.rank < rank) {
            final var diff = rank - this.rank;
            points = 10 * diff * diff;
        }
        if (this.rank < 8) {
            progress += points;
            this.rank += (progress / 100);
            if (this.rank == 0) {
                this.rank = 1;
            }
            if (progress >= 100) {
                progress -= ((progress / 100) * 100);
            }
        }
    }
}
