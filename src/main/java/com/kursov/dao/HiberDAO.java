package com.kursov.dao;
import com.kursov.model.*;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HiberDAO {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserDao userDao;
    @Autowired
    CarsDao carsDao;
    // 1--@Autowired
    // 1--EntityManagerFactory emf;
    @PersistenceContext EntityManager em; // --2
    private Random r = new Random();
    private String lastStatus;
    public HiberDAO() {
    }

    @Transactional
    public User addUser(User u) {
        em.persist(u);
        return u;
    }

    @Transactional
    public Cars addCars(String name, String model, String korobka, String year, boolean availiable, float price) {
        // 1--EntityManager em = emf.createEntityManager();
        Cars cars = new Cars(name, model, korobka, year, availiable, price);
        em.persist(cars);
        // 1--em.getTransaction().commit();
        lastStatus = "Автомобиль добавлен!";
        return cars;
    }

    public List<Cars> getAllCars() {
        // 1-- EntityManager em = emf.createEntityManager();
        List<Cars> res = em.createQuery("select c from Cars c",Cars.class).getResultList();
        return res;
    }

    @Transactional
    public List<User> getAllUsers() {
        // 1--EntityManager em = emf.createEntityManager();
          List<User> res = em.createQuery("select u from User u",User.class).getResultList();
        return res;
    }

    @Transactional
    public Cars findCarById(long i, EntityManager em) {
        //EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select c from Cars c where c.car_id=:paramName ");
        query.setParameter("paramName", i);
        Cars res = (Cars)query.getSingleResult();
        //resultList.forEach(System.out::println);
        // em.close();
        // EntityManager em = emf.createEntityManager();
        // Cat res = em.createQuery("select c from Cat c where c.id=:paramName ",Cat.class).getSingleResult();
        // Query query = session.createQuery("from ContactEntity where firstName = :paramName");
        return res;
    }

    @Transactional
    public Cars findCar(long i) {
        // 1--EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select c from Cars c where c.car_id=:paramName ");
        query.setParameter("paramName", i);
        Cars res = (Cars)query.getSingleResult();
        //resultList.forEach(System.out::println);
       // em.close();
       // EntityManager em = emf.createEntityManager();
       // Cat res = em.createQuery("select c from Cat c where c.id=:paramName ",Cat.class).getSingleResult();
       // Query query = session.createQuery("from ContactEntity where firstName = :paramName");
        return res;
    }

    @Transactional
    public User findPerson(long i) {
        // 1--EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select p from User p where p.id=:paramName ");
        query.setParameter("paramName", i);
        User res = (User)query.getSingleResult();
        //resultList.forEach(System.out::println);
        // em.close();
        // EntityManager em = emf.createEntityManager();
        // Cat res = em.createQuery("select c from Cat c where c.id=:paramName ",Cat.class).getSingleResult();
        // Query query = session.createQuery("from ContactEntity where firstName = :paramName");
        return res;
    }

    @Transactional
    public User findUserByUsername(String username) {
        // 1--EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select p from User p where p.enabled = true and  p.username=:paramName ");
        query.setParameter("paramName", username);
        User res = (User)query.getSingleResult();
        return res;
    }

    @Transactional
    public List<Jurnal> findJurnalByUserId(long id) {
        // 1--EntityManager em = emf.createEntityManager();
        User user = userDao.findUserById(id);
        Query query = em.createQuery("select j from Jurnal j where j.user=:id",Jurnal.class);
        query.setParameter("id", user);
        log.info("МЫ В HIBERDAO" + Long.toString(id));
        log.info(query.toString());
        List<Jurnal> res = (List<Jurnal>) query.getResultList();
        //List<Jurnal> res = em.createQuery("select j from Jurnal j",Jurnal.class).getResultList();
        return res;
    }

    @Transactional
    public void deleteCar(long id) {
        // 1--EntityManager em = emf.createEntityManager();
        // 1--em.getTransaction().begin();
        Cars c = findCar( id);
        ///c=em.merge(c);
        em.remove(c);
        // 1--em.getTransaction().commit();
        //lastStatus = "Автомобиль удален!";
    }

    @Transactional
    public void addCarToUser( Jurnal jurnal, User user){
        em.persist(jurnal);
        em.persist(user);
    }

    @Transactional
    public Jurnal delCarToUser(User user, Cars bestBeforeCar){
        //        log.info("idUser="+user.getId());
        //        log.info("idCar="+bestBeforeCar.getId());
        //Query query = em.createQuery("select p from users p where p.username=:paramName ");
        Query query = em.createQuery("select p from Jurnal p where p.user=:idUser and p.cars=:idCar and p.eliminDate is null ");
        query.setParameter("idUser", user);
        query.setParameter("idCar", bestBeforeCar);
        //query.setParameter("paramName", "BalagutdinovIF");
        //User res = (User)query.getSingleResult();
        Date date = new Date();
        Jurnal jurnal = (Jurnal)query.getSingleResult();
        jurnal.setEliminDate(new Date(date.getTime()));
        if (bestBeforeCar!=null){bestBeforeCar.setAvailable(true);}
        em.persist(jurnal);
        return jurnal;
    }

    @Transactional
    public void costJurnal(Jurnal jurnal){
        em.persist(jurnal);
    }

    /// проблема с многопоточным доступом!
    public String pullStatus() {
        return lastStatus;
    }

    public void setLastStatus(String str){
        this.lastStatus = str;
    }

    @Transactional
    public void updateCar(Cars cars) {
        em.merge(cars);
    }

    @Transactional
    public void updateUser(User user) { em.merge(user);
    }
}