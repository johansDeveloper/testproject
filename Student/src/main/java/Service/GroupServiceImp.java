package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.GroupDAO;
import Model.Group;

@Service
@Transactional
public class GroupServiceImp implements GroupService {

    @Autowired
    private GroupDAO groupDao;

    @Override
    public List<Group> getGroupByID(Group group) {
        return groupDao.getGroupByID(group);
    }

    @Override
    public List<Group> getGroups() {
        return groupDao.getGroups();
    }
}
