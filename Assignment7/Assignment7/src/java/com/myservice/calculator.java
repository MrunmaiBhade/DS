/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "calculator")
public class calculator {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addition")
    public double addition(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        //TODO write your implementation code here:
        return num1 + num2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "substraction")
    public double substraction(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        //TODO write your implementation code here:
        return  num1 - num2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Multiplication")
    public double Multiplication(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        //TODO write your implementation code here:
        return num1 * num2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Division")
    public double Division(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        //TODO write your implementation code here:
        return num1 / num2;
    }
}
