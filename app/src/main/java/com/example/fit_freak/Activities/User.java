package com.example.fit_freak.Activities;

import android.widget.RadioButton;
class User {

    private static String name;
    private static String username;
    private static String password;
    private static String con_password;
    private static String gender;
    private static double weight;
    private static int height;
    private static int age;
    private static String bodytype;
    private static String medical;
    private static String target;
    private static String diet_plan;
    private static String workout;
    private static String intensity;
    private static double calories;
    private static String date;





    /*public User() {
    }*/


    /*public User(String name, String username, String password, String con_password, String gender, double weight, int height, int age, String bodytype, String medical, String target, String diet_plan, String workout, String intensity) {
        User.name = name;
        User.username = username;
        User.password = password;
        User.con_password = con_password;
        User.gender = gender;
        User.weight = weight;
        User.height = height;
        User.age = age;
        User.bodytype = bodytype;
        User.medical = medical;
        User.target = target;
        User.diet_plan = diet_plan;
        User.workout = workout;
        User.intensity = intensity;
    }*/

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static String getCon_password() {
        return con_password;
    }

    public static void setCon_password(String con_password) {
        User.con_password = con_password;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        User.gender = gender;
    }

    public static double getWeight() {
        return weight;
    }

    public static void setWeight(double weight) {
        User.weight = weight;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        User.height = height;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        User.age = age;
    }

    public static String getBodytype() {
        return bodytype;
    }

    public static void setBodytype(String bodytype) {
        User.bodytype = bodytype;
    }

    public static String getMedical() {
        return medical;
    }

    public static void setMedical(String medical) {
        User.medical = medical;
    }

    public static String getTarget() {
        return target;
    }

    public static void setTarget(String target) {
        User.target = target;
    }

    public static String getWorkout() {
        return workout;
    }

    public static void setWorkout(String workout) {
        User.workout = workout;
    }

    public static String getDiet_plan() {
        return diet_plan;
    }

    public static void setDiet_plan(String diet_plan) {
        User.diet_plan = diet_plan;
    }


    public static String getIntensity() {
        return intensity;
    }

    public static void setIntensity(String intensity) {
        User.intensity = intensity;
    }

    public static double getCalories() {
        return calories;
    }

    public static void setCalories(double calories) {
        User.calories = calories;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        User.date = date;
    }
}
