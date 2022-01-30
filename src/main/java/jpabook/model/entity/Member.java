package jpabook.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by holyeye on 2014. 3. 11..
 */
@Entity
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    
    private String username;
    public Member() {
		// TODO Auto-generated constructor stub
	}
    public Member(String id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	@ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;
    
    public void setTeam(Team team)
    {
    	this.team= team;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
    

//    private String name;
//
//    private String city;
//    private String street;
//    private String zipcode;
//
//    @OneToMany(mappedBy = "member")
//    private List<Order> orders = new ArrayList<Order>();
//
//    //Getter, Setter
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getZipcode() {
//        return zipcode;
//    }
//
//    public void setZipcode(String zipcode) {
//        this.zipcode = zipcode;
//    }
//
//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }
}
