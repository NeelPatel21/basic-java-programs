/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatetest;
import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author Neel Patel
 */
@Embeddable
public class Add implements Serializable{
    @Column (name = "int_X")
    private int xin;
    @Column (name = "String_Y")
    private String yst;
    Add(int x,String y){
        this.xin=x;
        this.yst=y;
    }
    Add(){}
}
