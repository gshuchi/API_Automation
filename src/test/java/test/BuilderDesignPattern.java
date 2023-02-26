package test;

import com.github.javafaker.Faker;
import data.StudentBuilder;
import org.testng.annotations.Test;

public class BuilderDesignPattern {

    public static Faker faker = new Faker();
    public static String name = faker.name().fullName();
    public static String position = faker.job().position();
    public static String country = faker.address().country();

    public static StudentBuilder getStudentinfo() {

        return StudentBuilder.builder()
                .name(name)
                .position(position)
                .country(country).build();
    }
    @Test
    public void printStudentinfo() {
        StudentBuilder design = getStudentinfo();
        System.out.println("Name:-    "+design.getName());
        System.out.println("Postion:- "+design.getPosition());
        System.out.println("Country:- "+design.getCountry());
    }



}
