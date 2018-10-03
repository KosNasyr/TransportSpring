package su.wac.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import su.wac.model.jpa.Management;

import javax.persistence.Query;

@Service
public class ManagementBean {
    private SessionFactory sessionFactory;

    @Autowired
    public  void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory =sessionFactory;
    }

    @Transactional
    public void createNewManagement(Management man){
        Session session = this.sessionFactory.getCurrentSession();
        Query q = session.createNamedQuery("add_manager")
                .setParameter(1,man.getManager())
                .setParameter(2,man.getAddress());
        q.getSingleResult();
    }

    @Transactional
    public Management getManagement(int id){
        Session session = this.sessionFactory.getCurrentSession();
        return session.find(Management.class,id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateManagement(Management man) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(man);
        session.flush();
    }

    @Transactional
    public void deleteManagement(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Query q = session.createNamedQuery("del_manager")
                .setParameter(1,id);
        q.getSingleResult();
    }

}

