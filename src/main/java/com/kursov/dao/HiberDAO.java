package com.kursov.dao;
import com.kursov.model.Cars;
import com.kursov.model.Person;
import java.util.List;
import java.util.Random;
import javax.persistence.*;

import com.kursov.model.Role;
import com.kursov.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class HiberDAO {
    
    // 1--@Autowired
    // 1--EntityManagerFactory emf;

    @PersistenceContext EntityManager em; // --2

    private Random r = new Random();
    private String lastStatus;
    public HiberDAO() {
    }

@Transactional
public Person addPerson(Person p) {
    // 1--EntityManager em = emf.createEntityManager();
    //Person p = new Person(fam, name, ot, dr);
    // 1--em.getTransaction().begin();
    /////////c.setName("Cat"+r.nextInt(100));
    ////////////c.setWeight(1.0f+r.nextInt(40)/10.0f);
    em.persist(p);
    // 1--em.getTransaction().commit();
    lastStatus = "Чувак добавлен!";
    return p;
}

    @Transactional
    public User addUser(User u) {
        // 1--EntityManager em = emf.createEntityManager();
        //Person p = new Person(fam, name, ot, dr);
        // 1--em.getTransaction().begin();
        /////////c.setName("Cat"+r.nextInt(100));
        ////////////c.setWeight(1.0f+r.nextInt(40)/10.0f);
        em.persist(u);
        // 1--em.getTransaction().commit();
        lastStatus = "Чувак добавлен!";
        return u;
    }

    @Transactional
    public Cars addCars(String name, String model, String korobka, String year) {
        // 1--EntityManager em = emf.createEntityManager();
        Cars cars = new Cars(name, model, korobka, year);
        // 1--em.getTransaction().begin();
        /////////c.setName("Cat"+r.nextInt(100));
        ////////////c.setWeight(1.0f+r.nextInt(40)/10.0f);
        em.persist(cars);
        // 1--em.getTransaction().commit();
        lastStatus = "Тачка добавлена!";
        return cars;
    }

    public List<Cars> getAllCars() {
        // 1-- EntityManager em = emf.createEntityManager();
        List<Cars> res = em.createQuery("select c from Cars c",Cars.class).getResultList();
        return res;
    }

    @Transactional
    public List<Person> getAllPersons() {
        // 1--EntityManager em = emf.createEntityManager();
          List<Person> res = em.createQuery("select p from Person p",Person.class).getResultList();
       //  List<Person> res = em.createQuery("select p from Person p LEFT JOIN FETCH p.cats",Person.class).getResultList();
        /*
        for (Person p: res ) {
            p.getCars().size();
        }
        */
        return res;
    }

    @Transactional
    public void init() {
        // 1--EntityManager em = emf.createEntityManager();
        //em.createQuery("delete from Cat c where c.id>0").executeUpdate();
        //Cat c;
        // 1--em.getTransaction().begin();
//        em.createQuery("delete from Cat c where c.id>0").executeUpdate();
//        em.createQuery("delete from Person c where c.id>0").executeUpdate();
        Role r1 = new Role("ROLE_USER");
        Role r2 = new Role("ROLE_ADMIN");
        em.persist(r1);
        em.persist(r2);

        em.getTransaction().commit();

    }

    /// проблема с многопоточным доступом! 
    public String pullStatus() {
        return lastStatus;
    }

    //public Cat getCatById(int i) {
     //   return new Cat("??", 0f, null);
    //}

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
    public Person findPerson(long i) {
        // 1--EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select p from Person p where p.id=:paramName ");
        query.setParameter("paramName", i);
        Person res = (Person)query.getSingleResult();
        //resultList.forEach(System.out::println);
        // em.close();
        // EntityManager em = emf.createEntityManager();
        // Cat res = em.createQuery("select c from Cat c where c.id=:paramName ",Cat.class).getSingleResult();
        // Query query = session.createQuery("from ContactEntity where firstName = :paramName");
        return res;
    }

    @Transactional
    public Person findPersonByUsername(String username) {
        // 1--EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select p from Person p where p.username=:paramName ");
        query.setParameter("paramName", username);
        Person res = (Person)query.getSingleResult();
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
        Query query = em.createQuery("select p from users p where p.username=:paramName ");
        query.setParameter("paramName", username);
        User res = (User)query.getSingleResult();
        return res;
    }

    @Transactional
    public Person findPersonById(long i, EntityManager em) {
        //EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select c from Person c where c.id=:paramName ");
        query.setParameter("paramName", i);
        Person res = (Person)query.getSingleResult();
        return res;
    }

    @Transactional
    public void deleteCar(long id) {
        // 1--EntityManager em = emf.createEntityManager();
        // 1--em.getTransaction().begin();
        Cars c = findCar( id);
        c=em.merge(c);
        em.remove(c);
        // 1--em.getTransaction().commit();
        lastStatus = "Тачка удалена!";
    }

    @Transactional
    public void deletePerson(long id) {
        // 1--EntityManager em = emf.createEntityManager();
        // 1--em.getTransaction().begin();
        //em.createQuery("delete  from Person p where p.id=:?").setParameter(1,id).executeUpdate();
//                Query query = em.createQuery("DELETE FROM Person p WHERE p.id = :param ");
//                query.setParameter("param", id);
//                int rowsDeleted = query.executeUpdate();
        Person p = findPersonById(id, em);
        p=em.merge(p);
        em.remove(p);

        // 1--em.getTransaction().commit();
        lastStatus = "Персона удалена!";
    }

    @Transactional
    public void changePerson(long pid, long cid) {
        // 1--EntityManager em = emf.createEntityManager();
        // 1-- em.getTransaction().begin();
        Cars c = findCarById(cid, em) ;
        Person p = findPersonById(pid, em);
        System.out.print("Тачку " + c + " передаем персоне ");
        System.out.println(p);
        c.setOwner(p);
        //em.createQuery("delete  from Person p where p.id=:?").setParameter(1,id).executeUpdate();
        //Query query = em.createQuery("DELETE FROM Person p WHERE p.id = :param ");
        //query.setParameter("param", id);
        //int rowsDeleted = query.executeUpdate();
        // 1--em.getTransaction().commit();
        lastStatus = "Тачка переприсвоена!";
    }

}