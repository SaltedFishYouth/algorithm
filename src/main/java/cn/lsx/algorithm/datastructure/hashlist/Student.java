package cn.lsx.algorithm.datastructure.hashlist;

/**
 * @author linShengxi
 * @date 2021/6/10
 */
public class Student {
    private int id;
    private String name;
    private Student nextStudent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getNextStudent() {
        return nextStudent;
    }

    public void setNextStudent(Student nextStudent) {
        this.nextStudent = nextStudent;
    }
}
