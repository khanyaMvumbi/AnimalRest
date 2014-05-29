/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.presentation.rest;

import com.cput.my.wonder.domain.Animal;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Khanya
 */
public class AnimalControllerTest {
        
    private final RestTemplate restTemplate = new RestTemplate();
    private final static String URL = "http://localhost:8084/wonder/";

    @Test
    public void tesCreate() {
        Animal animal = new Animal.Builder(12).build();
        HttpEntity<Animal> requestEntity = new HttpEntity<>(animal, getContentType());
//        Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(URL + "rest/animal/create", HttpMethod.POST, requestEntity, String.class);

        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void tesAnimalUpdate() {
         Animal Animal = new Animal.Builder(12).Name("lion").build();
        HttpEntity<Animal> requestEntity = new HttpEntity<>(Animal, getContentType());
//        Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(URL + "rest/animal/update", HttpMethod.POST, requestEntity, String.class);
        System.out.println(" THE RESPONSE BODY " + responseEntity.getBody());
        System.out.println(" THE RESPONSE STATUS CODE " + responseEntity.getStatusCode());
        System.out.println(" THE RESPONSE IS HEADERS " + responseEntity.getHeaders());
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }
    @Test
    public void testreadAnimalByNameName() {
        String AnimalName = "lion";
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Animal> responseEntity = restTemplate.exchange(URL + "rest/animal/name/" + AnimalName, HttpMethod.GET, requestEntity, Animal.class);
        Animal Animal = responseEntity.getBody();

        Assert.assertNotNull(Animal);

    }

    @Test
    public void testreadAnimalById() {
        String AnimalId = "2";
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Animal> responseEntity = restTemplate.exchange(URL + "rest/animal/id/" + AnimalId, HttpMethod.GET, requestEntity, Animal.class);
        Animal Animal = responseEntity.getBody();

        Assert.assertNotNull(Animal);

    }

    @Test
    public void testgetAllAnimals() {
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Animal[]> responseEntity = restTemplate.exchange(URL + "api/Animal/Animals", HttpMethod.GET, requestEntity, Animal[].class);
        Animal[] Animals = responseEntity.getBody();
        for (Animal Animal : Animals) {
            System.out.println("The Animal Name is " + Animal.getName());

        }

        Assert.assertTrue(Animals.length > 0);
    }
    @Test
    private HttpEntity<?> getHttpEntity() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }
    @Test
    private HttpHeaders getContentType() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;

    }

}