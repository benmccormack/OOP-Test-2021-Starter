package ie.tudublin;

public class Note {
    private int note;
    private char duration;

    public int getNote() {
        return note;
    }
    public void setNote(int note) {
        this.note = note;
    }
    public char getDuration() {
        return duration;
    }
    public void setDuration(char duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Note [duration=" + duration + ", note=" + note + "]";
    }
}
