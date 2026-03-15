package com.jb.coupon3.controllers;

import com.jb.coupon3.beans.ClientType;
import com.jb.coupon3.exceptions.CustomExceptions;
import com.jb.coupon3.service.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminControllerTest {
    @Autowired
    private AdminService adminService;
    //private Company company = new Company(1, "samsung", "sam@sung.com", "s2m5un6", new HashSet<>());

    @Test
    void loginPass() {
        Assert.isTrue(true);
    } 

    @Test
    void addCompany() {

    }

    @Test
    void updateCompany() {
    }

    @Test
    void deleteCompany() {
    }

    @Test
    void getAllCompanies() {
    }

    @Test
    void getOneCompany() {
    }

    @Test
    void addCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void getOneCustomer() {
    }

    @Test
    void getAllCustomers() {
    }

    @Test
    void deleteCustomer() {
    }
}