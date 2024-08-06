/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybean;

import javax.ejb.Stateless;

/**
 *
 * @author Admin
 */
@Stateless
public class CCBean {

    public CCBean(){}
    public double RtoD(double r){return r/83.90;}
    public double DtoR(double d){return d*83.90;}
    
}
