package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository stdrepo;
    public  void addStudent(Student std) {
        stdrepo.addStudent(std);
    }
    public  void addTeacher(Teacher t) {
        stdrepo.addTeacher(t);
    }
    public void addStudentTeacherPair(String stdName,String tName){

        stdrepo.addPair(stdName,tName);
    }
    public Student getStudentByName(String name){
        return stdrepo.getStudentByName(name);
    }
    public Teacher getTeacherByName(String name){
        return stdrepo.getTeacherByName(name);
    }
    public List<String> getStudentsByTeacherName(String name){
        return stdrepo.getStudentsByTeacherName(name);
    }
    public List<String> getAllStudents(){
        return stdrepo.getListMovieList();
    }
    public void deleteTeacherByName(String name){
        stdrepo.deleteTeacherByName(name);
    }
    public void deleteAll(){
        stdrepo.deleteAll();
    }
}
