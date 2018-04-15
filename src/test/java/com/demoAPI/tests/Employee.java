package com.demoAPI.tests;

public class Employee {


    private String id;

    private String employee_salary;

    private String profile_image;

    private String employee_age;

    private String employee_name;

    public Employee(String id,  String employee_name,String employee_age, String employee_salary, String profile_image ){

        this.id =id;
        this.employee_name = employee_name;
        this.employee_age = employee_age;
        this.employee_salary = employee_salary;
        this.profile_image = profile_image;

    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getEmployee_salary ()
    {
        return employee_salary;
    }

    public void setEmployee_salary (String employee_salary)
    {
        this.employee_salary = employee_salary;
    }

    public String getProfile_image ()
    {
        return profile_image;
    }

    public void setProfile_image (String profile_image)
    {
        this.profile_image = profile_image;
    }

    public String getEmployee_age ()
    {
        return employee_age;
    }

    public void setEmployee_age (String employee_age)
    {
        this.employee_age = employee_age;
    }

    public String getEmployee_name ()
    {
        return employee_name;
    }

    public void setEmployee_name (String employee_name)
    {
        this.employee_name = employee_name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", employee_salary = "+employee_salary+", profile_image = "+profile_image+", employee_age = "+employee_age+", employee_name = "+employee_name+"]";
    }

}
