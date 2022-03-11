
public class SmartNotePair {

    private String text;
    private int usageCount;

    public SmartNotePair() {
        usageCount = 0;
    }

    public String getText() {
        ++usageCount;
        return text;
    }

    @Override
    public String toString() {
        return text + " / " + usageCount;
    }

    public void setText(String note) {
        this.text = note;
    }

    public int getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(int usageCount) {
        this.usageCount = usageCount;
    }
}
