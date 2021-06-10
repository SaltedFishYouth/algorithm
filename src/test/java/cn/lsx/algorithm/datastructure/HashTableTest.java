package cn.lsx.algorithm.datastructure;

import cn.lsx.algorithm.datastructure.hashlist.HashTable;
import cn.lsx.algorithm.datastructure.hashlist.Student;

import java.util.Scanner;

/**
 * @author linShengxi
 * @date 2021/6/10
 */

public class HashTableTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashTable table = new HashTable();
        int index = 0;
        while (true) {
            System.out.println("1:插入 2:查询  6:展示全部 0:退出");
            index = scan.nextInt();

            switch (index) {
                case 1:
                    Student student = new Student();
                    System.out.println("输入插入学生的id");
                    student.setId(scan.nextInt());
                    System.out.println("输入插入学生的名字");
                    student.setName(scan.next());
                    table.add(student);
                    break;
                case 2:
                    System.out.println("输入获取学生的id");
                    Student studentById = table.findStudentById(scan.nextInt());
                    if (studentById == null) {
                        System.out.println("不存在该学生");
                        break;
                    }
                    System.out.println("取出数据:id" + studentById.getId()+"姓名"+studentById.getName());
                    break;
                case 6:
                    table.show();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("输入错误");
            }
        }
    }
}
