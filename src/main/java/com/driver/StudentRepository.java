package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    private HashMap<String, List<String>> hm;
    private HashMap<String,Student> studentDb;
    private HashMap<String,Teacher> teacherDb;

    public StudentRepository() {
        this.hm = new HashMap<String,List<String>>();
        this.studentDb = new HashMap<String,Student>();
        this.teacherDb = new HashMap<String,Teacher>();
    }

    public List<String> getListMovieList(){
        return new ArrayList<>(studentDb.keySet());
    }

    public void addStudent(Student std){
        String key = std.getName();
        studentDb.put(key,std);
    }
    public void addTeacher(Teacher t){
        String key = t.getName();
        teacherDb.put(key,t);
    }
    public Teacher getTeacherByName(String name){
        if(teacherDb.containsKey(name)){
            return teacherDb.get(name);
        }
        return null;
    }
    public Student getStudentByName(String name){
        if(studentDb.containsKey(name)){
            return studentDb.get(name);
        }
        return null;
    }
    public void addPair(String stdName,String tName){
        if(teacherDb.containsKey(tName) && studentDb.containsKey(stdName)) {
            List<String> studentList = new ArrayList<>();
            if(hm.containsKey(tName)){
                studentList = hm.get(tName);
            }
            studentList.add(stdName);
            hm.put(tName,studentList);
        }
    }
    public List<String> getStudentsByTeacherName(String name){
        return hm.get(name);
    }
    public void deleteTeacherByName(String name){
        List<String> student = hm.get(name);
        for(String s : student){
            studentDb.remove(s);
        }
        hm.remove(name);
        teacherDb.remove(name);
    }
    public void deleteAll(){
        for(String teacher : hm.keySet()) {
            deleteTeacherByName(teacher);
        }
        teacherDb.clear();
    }
}
