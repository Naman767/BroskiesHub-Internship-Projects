public class Student {
    private int id;
    private String name;
    private double grade;

    // Constructor
    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getter for ID (needed for removing by ID)
    public int getId() {
        return id;
    }

    // toString method for display
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
    }
}
