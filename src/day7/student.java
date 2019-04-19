package day7;

/**
 * 成绩降序			zs	99
 * 			        ls	12
 * 姓名降序
 *
 * ID升序
 *
 *
 * 判断前面的大于后面的成绩返回1   否则返回0      //返回1不用交换
 *
 * 判断前面的姓名的字典序大于后面的字典序返回1 否则返回0   // 返回1不用交换
 *
 * 判断前面的ID是否小于后面的ID 返回1 否则返回0   //返回1不用交换
 * author:MIMO
 *
 */
public class student implements Comparable {
    private String name;
    private int id;
    private int grade;

    public student(String name, int id, int grade) {
        this.grade = grade;
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        int value = 0;
        if (o instanceof student) {
            if (this.grade != ((student) o).grade) {
                if (this.grade >= ((student) o).grade)   //成绩大于要比较的对象返回1
                {
                    return value = 1;
                } else return value;                     //成绩小于要比较的数返回0

            } else if (this.name.compareTo(((student) o).name) != 0) {

                if ((this.name.compareTo(((student) o).name) >= 0)) {
                    //字典序大于要比较的数返回
                    return value = 1;
                } else
                    return value;  //字典序小于要比较的数返回0
            } else if (this.id != ((student) o).id) {
                if (this.id < ((student) o).id)  //
                    return value = 1;
                else return value;

            }
        }
        return 0;
    }

    public String toString() {

        return "name:" + name + "id:" + id + "grade:" + grade;
    }

    public void swap(Object s) {
        if (s instanceof student) {
            String tempname;
            int tempid;
            int tempgrade;
            tempgrade = ((student) s).grade;
            tempid = ((student) s).id;
            tempname = ((student) s).name;
            ((student) s).grade = this.grade;
            ((student) s).name = this.name;
            ((student) s).id = this.id;
            this.grade = tempgrade;
            this.name = tempname;
            this.id = tempid;
        }
    }

    public static void main(String[] args) {

        student[] s = new student[5];
        s[0] = new student("zs", 123, 99);
        s[1] = new student("zs", 234, 55);
        s[2] = new student("zs", 456, 89);
        s[3] = new student("zs", 111, 67);
        s[4] = new student("zs", 145, 45);
        int i = 1;
        for (i = 0; i < s.length - 1; i++) {
            for (int j = i; j < s.length - 1; j++) {
                if (s[i].compareTo(s[j]) == 0)
                    s[i].swap(s[j]);
            }
        }
        for (student S : s) {
            System.out.println(S);
        }
    }
}
