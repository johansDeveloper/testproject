package Service;

import java.util.List;

import Model.Group;

public interface GroupService {
    public List<Group> getGroupByID(Group student);
    public List<Group> getGroups();
}
