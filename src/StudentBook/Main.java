package StudentBook;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Group group1 = new Group();
        ClassContainer CON = new ClassContainer();
        Group class1 = CON.addClass("class1", 34);
        Group class2 = CON.addClass("class2", 24);
        Group class3 = CON.addClass("class3", 20);
        Group class4 = CON.addClass("class4", 30);
        Group class5 = CON.addClass("class5", 25);

        Student stu1 = new Student("Marta", "Green", StudentCondition.Sick, 1996, 5);
        Student stu2 = new Student("Lily", "Jobs", StudentCondition.Absent, 1996, 4.5);
        Student stu3 = new Student("Lucy", "Jobs", StudentCondition.Present, 1994, 3);
        Student stu4 = new Student("Max", "Bush", StudentCondition.Present, 1995, 4);
        Student stu5 = new Student("Jone", "Bush", StudentCondition.Present, 1995, 4.5);
        Student stu6 = new Student("Marta", "aba", StudentCondition.Present, 1996, 4.5);

        class1.addStudent(stu1);
        class1.addStudent(stu2);
        class1.addStudent(stu3);


        class2.addStudent(stu4);
        class2.addStudent(stu5);
        class2.addStudent(stu6);

        // class1.addPoints(stu1,3);
        System.out.println("search Max");
        ArrayList search = class2.search("Max");
        System.out.println(search.toString());


        System.out.println("search by fragment Ma");
        ArrayList searchP = class2.searchPartial("Ma");
        System.out.println(searchP.toString());


        System.out.println("sortByName");
        ArrayList sortByName = class2.sortByName();
        System.out.println(sortByName.toString());

        System.out.println("sortByscore");
        ArrayList sortByscore = class2.sortByPoints();
        System.out.println(sortByscore.toString());

        System.out.println("MAX score");
        Student MAX = class1.max();
        System.out.println(MAX.toString());

        System.out.println("class container summary");
        CON.summary();

        System.out.println("find  empty");
        ArrayList EMPTY = CON.findEmpty();
        System.out.println(EMPTY.toString());


        CON.removeClass("class1");
        CON.removeClass("class5");

        System.out.println("ID class"+CON.getClassByID(1));
    }
}
