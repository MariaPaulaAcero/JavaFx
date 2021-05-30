package sample.logic.entities;

public class Report {
    private String criteria;
    private int count;
    private String description;

    public Report() {

    }

    public Report(String criteria, int count, String description) {
        this.criteria = criteria;
        this.count = count;
        this.description = description;
    }

    public String getCriteria() {
        return criteria;
    }

    public int getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }

    public void incrementCount(){
        this.count += 1;
    }
}
