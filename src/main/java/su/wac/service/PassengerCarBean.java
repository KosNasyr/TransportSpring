package su.wac.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.wac.model.jpa.PassengerCar;

import javax.persistence.Query;

@Service
public class PassengerCarBean{
    private SessionFactory sessionFactory;

    @Autowired
    public  void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory =sessionFactory;
    }

    @Transactional
    public void createNewPC(PassengerCar pc){
        Session session = this.sessionFactory.getCurrentSession();
        Query q = session.createNamedQuery("add_passengercar")
                    .setParameter(1,pc.getId())
                    .setParameter(2,pc.getTankAverage())
                    .setParameter(3,pc.getDriver())
                    .setParameter(4,pc.getRegistrationPlate());
            q.getSingleResult();
    }

    @Transactional
    public PassengerCar getPassengerCar(int id){
        Session session = this.sessionFactory.getCurrentSession();
        return session.find(PassengerCar.class,id);
    }

    @Transactional
    public void updatePassengerCar(PassengerCar pc) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(pc);
        session.flush();
    }

    @Transactional
    public void deletePassengerCar(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Query q = session.createNamedQuery("del_passengercar")
                    .setParameter(1,id);
            q.getSingleResult();
    }
}
