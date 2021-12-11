package StudentBook;

import java.text.DecimalFormat;
import java.util.*;

public class ClassContainer {


    Map<String, Group> ClassContainer = new HashMap<>();
    List<Group> groupList = new ArrayList<Group>();

    public ClassContainer() {
        infill();
    }

    @Override
    public String toString() {
        return "ClassContainer{" +
                "ClassContainer=" + ClassContainer +
                '}';
    }

    public Group getClassByID(int id) {
        return groupList.get(id);
    }

    public Group getClassByName(String name) {
        return ClassContainer.get(name);
    }

    public int getGroupSize() {
        return ClassContainer.size();
    }

    //a. addClass(String, double) - add new group with given name and given capacity to the list of of groups
    public Group addClass(String GroupName, int capacity) {
        Group group = new Group();
        group.setGroupName(GroupName);
        group.setMaxNumberStu(capacity);
        ClassContainer.put(GroupName, group);
        groupList.add(group);
        return group;
    }

    //b. removeClass(String) - removing the group with given name
    public void removeClass(String GroupName) {
        ClassContainer.remove(GroupName);
    }
    public void removeClassBYid(int id) {
        groupList.remove(id);
        ClassContainer.remove(groupList.get(id).getGroupName());
    }
    //c. findEmpty() - returning list of empty groups
    public ArrayList findEmpty() {
        ArrayList<Group> EmptyGroup = new ArrayList<>();
        Set<Map.Entry<String, Group>> set = ClassContainer.entrySet();
        for (Map.Entry<String, Group> entry : set) {
            String key = entry.getKey();
            Group value = entry.getValue();
            if (value.StudentsList.isEmpty()) {
                EmptyGroup.add(value);
            }
        }
        return EmptyGroup;
    }

    // D.. summary() - prints to standard output the information containing:
// group name and percentage filling Add other useful methods and variables
    //nf.format(0.47)
    public void summary() {
        Set<Map.Entry<String, Group>> set = ClassContainer.entrySet();
        DecimalFormat df1 = new DecimalFormat("##.00%");    //##.00%   百分比格式，后面不足2位的用0补齐
        for (Map.Entry<String, Group> entry : set) {
            String key = entry.getKey();
            Group value = entry.getValue();
            //double  percentage=value.getMaxNumberStu()/value.StudentNum();
            double percentage = (double) value.StudentNum() / value.getMaxNumberStu();
            System.out.println("group name:" + key + "\n percentage filling" + "\n" + df1.format(percentage));
        }


    }

    private void infill() {
        Student stu1 = new Student("Marta", "Green", StudentCondition.Sick, 1996, 5);
        Student stu2 = new Student("Lily", "Jobs", StudentCondition.Absent, 1996, 4.5);
        Student stu3 = new Student("Lucy", "Jobs", StudentCondition.Present, 1994, 3);
        Student stu4 = new Student("Max", "Bush", StudentCondition.Present, 1995, 4);
        Student stu5 = new Student("Jone", "Bush", StudentCondition.Present, 1995, 4.5);
        Student stu6 = new Student("Marta", "aba", StudentCondition.Present, 1996, 4.5);

        addClass("class1", 10);
        addClass("class2", 20);
        addClass("class3", 30);

        getClassByName("class1").addStudent(stu1);
        getClassByName("class1").addStudent(stu2);
        getClassByName("class1").addStudent(stu3);
        getClassByName("class1").addStudent(stu4);

        getClassByName("class2").addStudent(stu5);
        getClassByName("class2").addStudent(stu6);



    }

}
