/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.wonder.test.presentation.rest;

import com.cput.my.wonder.domain.Customer;
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
import org.testng.annotations.Test;

/**
 *
 * @author Khanya
 */
public class CustomerRestController {
    
   private final RestTemplate restTemplate = new RestTemplate();
    private final static String URL = "http://localhost:8084/wonder/";

    @Test
    public void tesCreate() {
        Customer customer = new Customer.Builder("32").build();
        HttpEntity<Customer> requestEntity = new HttpEntity<>(customer, getContentType());
//        Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(URL + "rest/customer/create", HttpMethod.POST, requestEntity, String.class);

        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

    
    @Test
    public void testreadCustomerByNameName() {
        String CustomerName = "zodwa";
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Customer> responseEntity = restTemplate.exchange(URL + "rest/customer/name/" + CustomerName, HttpMethod.GET, requestEntity, Customer.class);
        Customer Customer = responseEntity.getBody();

        Assert.assertNotNull(Customer);

    }

    @Test
    public void testreadCustomerById() {
        String CustomerId = "2";
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Customer> responseEntity = restTemplate.exchange(URL + "rest/customer/id/" + CustomerId, HttpMethod.GET, requestEntity, Customer.class);
        Customer Customer = responseEntity.getBody();

        Assert.assertNotNull(Customer);

    }

    @Test
    public void testgetAllCustomers() {
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Customer[]> responseEntity = restTemplate.exchange(URL + "api/Customer/Customers", HttpMethod.GET, requestEntity, Customer[].class);
        Customer[] customers = responseEntity.getBody();
        for (Customer customer : customers) {
            System.out.println("The Customer Name is " + customer.getCustName());

        }

        Assert.assertTrue(customers.length > 0);
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
