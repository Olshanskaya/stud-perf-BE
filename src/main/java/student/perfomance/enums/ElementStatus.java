package student.perfomance.enums;

public enum ElementStatus {
    ACTIVE("ACTIVE"), DELETED("DELETED");
    private String name;

    ElementStatus(String name) {
        this.name = name;
    }
}
