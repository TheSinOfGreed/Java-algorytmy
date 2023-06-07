public class Task {
    private int progress;
    private String description;

    public Task(String description) {
        this.description = description;
        this.progress = 0;

    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        if (progress > 100 || progress < 0) {
            throw new IllegalArgumentException("Zła wartość");
        } else {
            this.progress = progress;
        }
    }

}
