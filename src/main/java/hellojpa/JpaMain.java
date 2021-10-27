package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.concurrent.locks.Lock;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //code
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        try {
//            Member member = saveMember(entityManager);
//
//            Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);
//
//            entityManager.persist(team);
//
//            Locker locker = new Locker();
//            locker.setName("testLocker");
//            entityManager.persist(locker);
//            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }

    private static Member saveMember(EntityManager entityManager) {
        Member member = new Member();
        member.setUserName("member1");
        entityManager.persist(member);
        return member;
    }
}
