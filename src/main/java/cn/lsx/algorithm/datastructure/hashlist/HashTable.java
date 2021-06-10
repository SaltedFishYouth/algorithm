package cn.lsx.algorithm.datastructure.hashlist;

/**
 * @author linShengxi
 * @date 2021/6/10
 */

public class HashTable {
    LinkedStudentList[] bucket = new LinkedStudentList[10];

    public void add(Student student) {
        LinkedStudentList list = bucket[student.getId()%10];
        if (list == null){
            list = new LinkedStudentList();
            bucket[student.getId()%10] = list;
        }
        list.add(student);
    }

    public void show(){
        for (int i = 0; i < bucket.length; i++) {
            LinkedStudentList linkedStudentList = bucket[i];
            if (linkedStudentList !=null) {
                linkedStudentList.list();
            }
        }
    }

    public Student findStudentById(int id) {
        LinkedStudentList list = bucket[id%10];
        if (list == null){
            return null;
        }
        return list.findStudentById(id);
    }
}

class LinkedStudentList{
    private Student head;

    public void add(Student student) {
        if (head == null) {
            head = student;
            return;
        }
        Student temp = head;
        while (temp.getNextStudent() != null){
            temp = temp.getNextStudent();
        }
        temp.setNextStudent(student);
    }

    public void list(){
        if (head==null){
            System.out.println("链表为空");
            return;
        }
        Student temp = head;
        int index = 0;
        while (temp!=null){
            System.out.println("第"+(index+1)+"个，学生 id="+temp.getId()+"名字="+temp.getName());
            temp = temp.getNextStudent();
            index++;
        }
    }

    public Student findStudentById(int id) {
        if (head==null){
            System.out.println("链表为空");
            return null;
        }
        Student temp = head;
        while (temp!=null){
            if (temp.getId() == id){
                return temp;
            }
            temp = temp.getNextStudent();
        }
        return null;
    }
}


