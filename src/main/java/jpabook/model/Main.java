package jpabook.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.model.entity.Member;
import jpabook.model.entity.Team;

/**
 * Created by 1001218 on 15. 4. 5..
 */
public class Main {
    public static void main(String[] args) {

    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
       
    	//엔티티 매니저 팩토리 생성
    	EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
    	
    	EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            //TODO 비즈니스 로직
            teamsave(em);
        	Team team1 = new Team("team1", "팀1"); 
        	em.persist(team1);
        	
        	//회원1저장 ,2 저장 
        	Member member1 = new Member("1234L", "회원1");
        	
        	
        	member1.setTeam(team1);
        	//em2.persist(member1);
        	
        	Member member2 = new Member("2345L","회원2");
        	member2.setTeam(team1);
        	//em2.persist(member2);
        	
        	List<Member> ll = new ArrayList<Member>();
        	ll.add(member1);
        	ll.add(member2);
        
        	ll.stream().forEach(g -> em.persist(g));
            
        	
        	
        	
            tx.commit();//트랜잭션 커밋
            
            queryLogicJoin(em);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("롤백함~~");
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }
    
    //public static void logic(EntityManager em) {
    public static void teamsave(EntityManager em) {
    	EntityManager em2 = em; //엔티티 매니저 생성
    	
    	Team team2 = new Team("team2", "팀2"); 
    	em2.persist(team2);
    	
    	//회원1저장 ,2 저장 
    	Member member3 = new Member("3333L", "회원3");
    	
    	
    	member3.setTeam(team2);
    	//em2.persist(member1);
    	
    	Member member4 = new Member("444L","회원4");
    	member4.setTeam(team2);
    	//em2.persist(member2);
    	
    	List<Member> ll = new ArrayList<Member>();
    	ll.add(member3);
    	ll.add(member4);
    
    	ll.stream().forEach(g -> em2.persist(g));
    	
    	
    	
    }
    
    
    public static void queryLogicJoin(EntityManager em) {
    	String jpql = "select m from Member m join m.team t where "
    			+ " t.name = :teamName";
    	List<Member> resultList = em.createQuery(jpql, Member.class)
    			.setParameter("teamName", "팀2")
    			.getResultList();
    	System.out.println(resultList.size());
    	resultList.stream().forEach(g -> System.out.println(g.getUsername()));
    }
    
    
    
    
    
    
    
    
    
    
    
    

}
