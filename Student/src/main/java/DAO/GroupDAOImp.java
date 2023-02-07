package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Group;

@Repository
public class GroupDAOImp implements GroupDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Group> getGroupByID(Group group) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Group> query = currentSession.createQuery("from Group where groupId=:groupId", Group.class);
        query.setParameter("groupId", group.getGroupId());
        return query.getResultList();
    }

    @Override
    public List<Group> getGroups() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Group> query = currentSession.createQuery("from Group", Group.class);
        return query.getResultList();
    }
}
