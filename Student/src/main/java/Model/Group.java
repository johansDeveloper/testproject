package Model;

import javax.persistence.*;

@Entity
@Table(name = "groupTable")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;
    private String groupNumber;
    private String faculty;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
