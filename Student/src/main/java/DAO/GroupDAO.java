package DAO;

import java.util.List;

import Model.Group;

public interface GroupDAO {
    public List<Group> getGroupByID(Group group);
    public List<Group> getGroups();
}
