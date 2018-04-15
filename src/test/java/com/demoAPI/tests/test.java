package com.demoAPI.tests;

import com.google.gson.Gson;
import com.satish.utilities.APIUtility;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class test extends APIUtility {



    @Test
    public void getEmployees() throws Exception
    {
        HttpResponse response =APIUtility.getRequest("employees");
        int stscode =response.getStatusLine().getStatusCode();
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String json = org.apache.commons.io.IOUtils.toString(rd);
        System.out.println("Status Code is: "+stscode);
        System.out.println("Status Code is: "+json);
        Gson gson = new Gson();
        Employee[] employee = gson.fromJson(json, Employee[].class);

        for(Employee emp: employee)
        {

            if(emp.getEmployee_name().equals("Jamie" ) ){
                String empName = emp.getEmployee_name();
                String empID = emp.getId();
                String age = emp.getEmployee_age();
                String sal = emp.getEmployee_salary();
                System.out.println("empName  is: " + empName + "==>" + " and empSal is " + sal + "==> " + " and empAGE is " + age +
                        "==>" + " and empID is" + empID );
            }

        }



    }



    @Test
    public void PostAnEmployee( ) throws Exception
    {

        Employee emp = new Employee("111","Satish","33","12300","");


        List<NameValuePair>  urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("id", emp.getId()));
        urlParameters.add(new BasicNameValuePair("employee_name", emp.getEmployee_name()));
        urlParameters.add(new BasicNameValuePair("employee_salary", emp.getEmployee_salary()));
        urlParameters.add(new BasicNameValuePair("employee_age", emp.getEmployee_age()));
        urlParameters.add(new BasicNameValuePair("profile_image", ""));
        HttpResponse response =APIUtility.PostRequest("create",urlParameters);
        int stscode =response.getStatusLine().getStatusCode();
        System.out.println("Status Code is" + stscode);

    }

    @Test
    public void UpdateAnEmployee( ) throws Exception
    {

        List<NameValuePair>  urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("id", "1"));
        urlParameters.add(new BasicNameValuePair("employee_name", "Satish Babu Samineni"));
        urlParameters.add(new BasicNameValuePair("employee_salary", "10000"));
        urlParameters.add(new BasicNameValuePair("employee_age", "33"));
        urlParameters.add(new BasicNameValuePair("profile_image", ""));
        HttpResponse response =APIUtility.PutRequest("update/1",urlParameters);
        int stscode =response.getStatusLine().getStatusCode();
        System.out.println("Status Code is :" + stscode);

    }

    @Test
    public void DeleteAnEmployee( ) throws Exception
    {

        HttpResponse response =APIUtility.DeleteRequest("delete/1");
        int stscode =response.getStatusLine().getStatusCode();
        System.out.println("Status Code is :" + stscode);

    }


}
