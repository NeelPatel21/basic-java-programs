/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatetest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.*;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 *
 * @author Neel Patel
 */
@Entity 
@Table(name = "abc")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Lob
    @Column (name = "f_name")
    private String name;
    //@Column (columnDefinition = "DateTime")
    private LocalDateTime ld;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride (name = "xin",column = @Column(name = "n")),
        @AttributeOverride (name = "yst",column = @Column(name = "nc")),
    })
    private Add add;
    
    @ElementCollection
    @GenericGenerator (name = "temp", strategy = "sequence")
    @JoinTable(name = "st",joinColumns = @JoinColumn(name = "idx"))
    @CollectionId (generator = "temp", type = @Type(type = "int")
              ,columns = @Column(name = "mg"))
    private Collection<String> s=new ArrayList<>();
    
    public User(){}
    public User(int id,String name) {
        //this.id = id;
        this.name = name;
        this.ld=LocalDateTime.now();
        this.add=new Add(id+5,"next "+name);
        s.add(name+" 1");
        s.add(name+" "+id);
        s.add(name+" 3");
    }
    
    @Override
    public String toString(){
        return id+" "+name+" "+ld;
    }
}
