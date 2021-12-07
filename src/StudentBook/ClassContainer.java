package StudentBook;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ClassContainer {


    Map<String, Group> ClassContainer = new HashMap<>();



    @Override
    public String toString() {
        return "ClassContainer{" +
                "ClassContainer=" + ClassContainer +
                '}';
    }
public  Group getClassByID(int id){
      return ClassContainer.get(id);
}
public int getGroupSize(){
        return ClassContainer.size();
}
    //a. addClass(String, double) - add new group with given name and given capacity to the list of of groups
    public Group addClass(String GroupName, int capacity) {
        Group group=new Group();
        group.setGroupName(GroupName);
        group.setMaxNumberStu(capacity);
        ClassContainer.put(GroupName, group);
        return  group;
    }

    //b. removeClass(String) - removing the group with given name
    public void removeClass(String GroupName) {
        ClassContainer.remove(GroupName);
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
    public void summary(){
        Set<Map.Entry<String, Group>> set = ClassContainer.entrySet();
        DecimalFormat df1 = new DecimalFormat("##.00%");    //##.00%   百分比格式，后面不足2位的用0补齐
        for (Map.Entry<String, Group> entry : set) {
            String key = entry.getKey();
            Group value = entry.getValue();
           //double  percentage=value.getMaxNumberStu()/value.StudentNum();
               double  percentage=(double)value.StudentNum()/value.getMaxNumberStu();
            System.out.println("group name:"+key+"\n percentage filling"+"\n"+df1.format(percentage));
        }


    }

}
