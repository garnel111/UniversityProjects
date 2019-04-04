/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.data.BicycleDB;
import lapr.project.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lapr.project.model.Park;

import static org.mockito.Mockito.*;


/**
 * @author Vitor Paiva
 */
public class RequestBicycleControllerTest {

    RequestBicycleController requestControllerTest;

    public RequestBicycleControllerTest() {
    }


    /**
     * Test of requestBicycle method, of class RequestBicycleController.
     * @throws java.lang.Exception
     */
    @Test
    public void testRequestBicycle() throws Exception {
        System.out.println("requestBicycle");
        requestControllerTest= new RequestBicycleController();

        BicycleDB bDBMocked = mock(BicycleDB.class);



        User numberOne = new User();
        numberOne.setCardNumber("155555521");
        numberOne.setEmail("1140951@isep.ipp.pt");
        numberOne.setHeight(1.69);
        numberOne.setIdUser(5);
        numberOne.setInitialCost(50);
        numberOne.setWeight(74);
        numberOne.setUsername("Vitor");
        numberOne.setPoints(29);

        Park winterworld = new Park();
        winterworld.setName("Isep_Park");
        winterworld.setAdmin_Id(30);
        winterworld.setId(1);
        winterworld.setLatitude(41.179025F);
        winterworld.setLongitude(-8.607782F);
        winterworld.setMaxCapacityElectric(50);
        winterworld.setMaxCapacityNonElectric(150);
        requestControllerTest.setUser(numberOne);
        requestControllerTest.setPark(winterworld);
        requestControllerTest.setBicycletype("Electric");
        if(requestControllerTest.getUser()==null){
            throw new RuntimeException("utilizador invalido");
        }

        String typeBicycle = "Electric";
        requestControllerTest = new RequestBicycleController(numberOne,winterworld,"Electric");
        requestControllerTest.setRequestbicycleDB(bDBMocked);
        
        if(requestControllerTest.getBicycletype()==null){
            throw new RuntimeException("identificador de bicicleta invalido");
        }
        if(requestControllerTest.getPark()==null){
            throw new RuntimeException();
        }
        when(bDBMocked.UserRequestBicycle(winterworld, typeBicycle, numberOne)).thenReturn((long) 452);
        long expResult = 452;
        long requestBicycleResult = requestControllerTest.requestBicycle(numberOne, winterworld, typeBicycle);

        assertEquals(expResult, requestBicycleResult);
        verify(bDBMocked).UserRequestBicycle(winterworld, typeBicycle, numberOne);



    }


}
