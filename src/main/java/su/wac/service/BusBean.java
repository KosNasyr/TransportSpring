package su.wac.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.wac.model.jpa.Bus;

import javax.persistence.Query;

@Service
public class BusBean {
    private SessionFactory sessionFactory;

    @Autowired
    public  void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory =sessionFactory;
    }


    @Transactional
    public void createNewBus(Bus bus){
        Session session = this.sessionFactory.getCurrentSession();
        Query q =session.createNamedQuery("add_bus")
                .setParameter(1,bus.getId())
                .setParameter(2,bus.getTankAverage())
                .setParameter(3,bus.getCapacity())
                .setParameter(4,bus.getDriver())
                .setParameter(5,bus.getRegistrationPlate());
        q.getSingleResult();
    }
    @Transactional
    public Bus getBus(int id){
        Session session = this.sessionFactory.getCurrentSession();
        return session.find(Bus.class,id);
    }
    @Transactional
    public void updateBus(Bus bus) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(bus);
        session.flush();
    }
    @Transactional
    public void deleteBus(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Query q = session.createNamedQuery("del_bus")
                .setParameter(1,id);
        q.getSingleResult();
    }
}



