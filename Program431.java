// Customised Database Management System

class node {
    private static int counter = 1;
    public int Rno;
    public String Name;
    public String City;
    public int Marks;

    public node next;

    public node(String B, String C, int D) {
        Rno = counter;
        counter++;
        Name = B;
        City = C;
        Marks = D;
        next = null;
    }
}

class DBMS {
    private node first;

    public DBMS() {
        first = null;
        System.out.println("DBMS initailised succesfully...");
        System.out.println("Student Table gets created succesfully...");
    }

    // InsertLast
    // insert into table student values(1,'Amit','Pune',89);
    public void InsertIntoTable(String Name, String City, int Marks) {
        node newn = new node(Name, City, Marks);

        if (first == null) {
            first = newn;
        } else {
            node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newn;
        }
        System.out.println("One record gets inserted succesfully...");
    }

    // Display
    // select * from student
    public void SelectStarFrom() {
        System.out.println("Data from the student table is : ");

        node temp = first;

        System.out.println("--------------------------------------------------------------");
        while (temp != null) {
            System.out.println(temp.Rno + "\t" + temp.Name + "\t" + temp.City + "\t" + temp.Marks);
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
    }

    // select * from student where city = "________";
    public void SelectStarFromWhereCity(String str) {
        System.out.println("Data from the student table where city is : " + str);

        node temp = first;

        System.out.println("--------------------------------------------------------------");
        while (temp != null) {
            if (str.equals(temp.City)) {
                System.out.println(temp.Rno + "\t" + temp.Name + "\t" + temp.City + "\t" + temp.Marks);
            }
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
    }

    // select count(Marks) from student;

    public void SelectCount() {
        node temp = first;
        int iCnt = 0;
        while (temp != null) {
            iCnt++;
            temp = temp.next;
        }
        System.out.println("Number of records in the table  : " + iCnt);
    }

    public void SelectSum() {
        node temp = first;
        int iSum = 0;
        while (temp != null) {
            iSum = iSum + temp.Marks;
            temp = temp.next;
        }
        System.out.println("Summation of marks column is  : " + iSum);
    }

    public void SelectAvg() {
        node temp = first;
        int iSum = 0;
        int iCnt = 0;
        while (temp != null) {
            iSum = iSum + temp.Marks;
            temp = temp.next;
            iCnt++;
        }
        System.out.println("Average of marks column is : " + (iSum / iCnt));
    }

    // selcet Max(marks) from studnet;
    public void SelectMax() {
        node temp = first;
        int iMax = 0;
        if (temp != null) {
            iMax = temp.Marks;
        }

        while (temp != null) {
            if (iMax < temp.Marks) {
                iMax = temp.Marks;
            }
            temp = temp.next;
        }
        System.out.println("The Maximum Marks is : " + iMax);
    }

    public void SelectMin() {
        node temp = first;
        int iMin = 0;
        if (temp != null) {
            iMin = temp.Marks;
        }

        while (temp != null) {
            if (iMin > temp.Marks) {
                iMin = temp.Marks;
            }
            temp = temp.next;
        }
        System.out.println("The Minimum Marks is : " + iMin);
    }

    // select * from student where name = "____";
    public void SelectStarFromName(String str) {
        System.out.println("Information of all student where Name is : " + str);

        node temp = first;

        System.out.println("--------------------------------------------------------------");
        while (temp != null) {
            if (str.equals(temp.Name)) {
                System.out.println(temp.Rno + "\t" + temp.Name + "\t" + temp.City + "\t" + temp.Marks);
            }
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
    }
    // update student set city="_____" where Rno = ___;

    public void UpdateCity(int iNo, String str) {
        node temp = first;
        while (temp != null) {
            if (iNo == temp.Rno) {
                temp.City = str;
                break;
            }
            temp = temp.next;
        }
        System.out.println("Record is Updated");
    }

    // delete from student where Rno = ___;
    public void DeleteFrom(int iNo) {
        node temp = first;

        // ifLL is empty
        if (temp == null) {
            return;
        }
        // if first node is the targerted node
        if (temp.Rno == iNo) {
            first = first.next;
            return;
        }
        while (temp.next != null) {
            if (temp.next.Rno == iNo) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }

    }
}

class Program431 {
    public static void main(String Arg[]) {
        DBMS obj = new DBMS();

        obj.InsertIntoTable("Amit", "Pune", 89);
        obj.InsertIntoTable("Pooja", "Mumbai", 95);
        obj.InsertIntoTable("gauri", "Pune", 90);
        obj.InsertIntoTable("Amit", "nagar", 81);
        obj.InsertIntoTable("Rahul", "Satara", 80);
        obj.InsertIntoTable("Neha", "Pune", 78);

        obj.SelectStarFrom();

        obj.SelectStarFromWhereCity("Pune");

        obj.SelectCount();

        obj.SelectSum();

        obj.SelectAvg();
        obj.SelectMax();
        obj.SelectMin();
        obj.SelectStarFromName("Amit");
        obj.UpdateCity(3, "Nashik");

        obj.SelectStarFrom();
        obj.DeleteFrom(5);
        obj.SelectStarFrom();
        obj.InsertIntoTable("Rukanini", "kolhapur", 77);
        obj.SelectStarFrom();
    }
}

/*
 * 
 * supported Queries
 * 
 * 1) Inset into student value('amit','pune',89)
 * 2) select * from student;
 * 3) select * from student where city = 'pune';
 * 4) select count(Marks) from student;
 * 5) select sum(Marks) from student;
 * 6) select avg(Marks ) from student;
 * 7) select Max (Marks ) from student;
 * 8) select min(Marks) from student;
 * 9) select * from student where name = "____";
 * 10) update student set city="_____" where Rno = ___;
 * 11) delete from student where Rno = ___;
 */