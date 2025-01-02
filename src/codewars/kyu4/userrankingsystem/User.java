package codewars.kyu4.userrankingsystem;

public class User {

    private int rank;
    private int progress;

    public User() {
        rank = 1;
        progress = 20;
    }

    public void incProgress(int rank) {
        if (rank < -8 || rank == 0 || rank > 8) {
            throw new IllegalArgumentException();
        }

       int rankDifference =
               (rank>0 && this.rank<0) ? rank - this.rank -1 :
               (rank<0 && this.rank>0) ? rank - this.rank + 1 : rank - this.rank;

       int progressAdvance =
                       rankDifference > 0 ? (10 * rankDifference * rankDifference) :
                       rankDifference == 0 ? 3 :
                       rankDifference == -1 ? 1 : 0;

       progress += progressAdvance;
       while (progress >= 100) {
           progress -= 100;
           adjustRank();
       }

        if (this.rank == 8) {
            progress = 0;
        }
    }

    private void adjustRank () {
        if (rank == -1) {
            rank = 1;
        } else if (rank < 8) {
            rank++;
        }
    }

    public int getRank() {
        return rank;
    }

    public int getProgress() {
        return progress;
    }
}
