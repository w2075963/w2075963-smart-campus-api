/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus;

import org.glassfish.jersey.server.ResourceConfig;

public class MyApplicationConfig extends ResourceConfig {

    public MyApplicationConfig() {
        packages("com.mycompany.smartcampusapi");
    }
}
