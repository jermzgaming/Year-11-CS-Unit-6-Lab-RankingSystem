public class User {
    private int rank;
    private int progress;

    public User() {
        rank = -8;
        progress = 0;
    }

    public int getRank() {
        return rank;
    }

    public int getProgress() {
        return progress;
    }

    public String toString() {
        return "User{rank=" + rank + ", progress=" + progress + "}";
    }

    public void incProgress(int activity) {
        if (activity < -8 || activity == 0 || activity > 8) {
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }
        if (rank == activity) {
            progress += 3;
        }
        if (rank - 1 == activity) {
            progress += 1;
        }
        if (rank == 1) {
            if (rank - 2 == activity) {
                progress += 1;
            }
        }
        int d;
        if (activity > 0 && rank < 0) {
            d = activity - rank - 1;
        }
        else if (activity < 0 && rank > 0) {
            d = activity - rank + 1;
        }
        else {
            d = activity - rank;
        }
        if (rank != 1) {
            progress += (10 * d * d);
        }

        while (progress >= 100) {
            if (rank == -1) {
                rank = 1;
            }
            else if (rank < 8) {
                rank++;
            }
            progress -= 100;
        }

        if (rank == 8) {
            progress = 0;
        }
    }
}
