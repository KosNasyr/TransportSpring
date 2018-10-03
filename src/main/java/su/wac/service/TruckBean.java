package su.wac.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.wac.model.jpa.Truck;

import javax.persistence.Query;

@Service
public class TruckBean {

    private SessionFactory sessionFactory;

    @Autowired
    public  void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory =sessionFactory;
    }

    @Transactional
    public void createNewTruck(Truck truck){
        Session session = this.sessionFactory.getCurrentSession();
        Query q = session.createNamedQuery("add_truck")
                .setParameter(1,truck.getId())
                .setParameter(2,truck.getTankAverage())
                .setParameter(3,truck.getCargo())
                .setParameter(4,truck.getDriver())
                .setParameter(5,truck.getRegistrationPlate());
        q.getSingleResult();
    }

    @Transactional
    public Truck getTruck(int id){
        Session session = this.sessionFactory.getCurrentSession();
        return session.find(Truck.class,id);
    }

    @Transactional
    public void updateTruck(Truck truck) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(truck);
        session.flush();
    }

    @Transactional
    public void deleteTruck(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Query q = session.createNamedQuery("del_truck")
                .setParameter(1,id);
        q.getSingleResult();
    }
}
