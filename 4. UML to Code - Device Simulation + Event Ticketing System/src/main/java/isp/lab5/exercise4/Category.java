package isp.lab5.exercise4;

public enum Category {

    THEATER("Theater"),
    OPERA("Opera"),
    MOVIE("Movie");

    private String displayCategory;

    Category(String displayCategory) {
        this.displayCategory = displayCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "displayCategory='" + displayCategory + '\'' +
                '}';
    }
}
