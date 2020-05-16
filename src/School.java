/*
Linked List
*/

public class School {
    public static int counter = 0;

    //static objeler program kapatılıncaya kadar bellekte durur

    static Student head, tail;

    public static void main(String[] args) {
        Student students[] = {new Student("Gökhan",3), 
        new Student("Abdulkerim",3), 
        new Student("Mehmet Faruk",3), 
        new Student("Muhammed Hüseyin",3),
        new Student("Mustafa",3),
        new Student("Sena",3),
        new Student("Zehra Şevval",3),
        new Student("Bilge Sena",3) };

        /*
        ☺->
         h        t
         |        |
         ☻->☻->☻->☻->♦
         */
        for (Student student : students)
            setStudent(student);

            //Döngü ile erişim
        // Student temp = head;
        // int count = 0;
        // while(temp!=null){
        //     System.out.println(temp.toString());
        //     temp = temp.next;
        //     count++;
        // }
        // System.out.println(count);
        // System.out.println("Head: "+head.toString());
        // System.out.println("Tail: "+tail.toString());

        access2StudentsWithFunc(head);
        System.out.println("------------------ortaya ekleme----------------------");
        addStudent2(5, new Student("MSP",3));
        access2StudentsWithFunc(head);
        System.out.println("------------------başa ekleme----------------------");
        addStudent2Begin(new Student("Tuğçe",3));
        access2StudentsWithFunc(head);
        System.out.println("------------------sona ekleme----------------------");
        addStudent2Tail(new Student("Zeynep",3));
        access2StudentsWithFunc(head);

        System.out.println("------------------ortadan silme----------------------");
        removeStudent2(3);
        access2StudentsWithFunc(head);

        System.out.println("------------------baştan silme----------------------");
        removeStudent2Begin();
        access2StudentsWithFunc(head);

        System.out.println("------------------sondan silme----------------------");
        removeStudent2Tail();
        access2StudentsWithFunc(head);

        //removeSrudent2XByStudent()
        System.out.println("------------------ortadan isimle silme ----------------------");
        removeStudent2ByName("Muhammed Hüseyin");
        access2StudentsWithFunc(head);
        
    }

    //access with recursion function
    public static void access2StudentsWithFunc(Student student){
        if(student!=null)
        {
            System.out.println(student.toString());
            access2StudentsWithFunc(student.next);
        }
        else
            return;
    }

    //sıralı ekliyor
    public static void setStudent(Student student){
        if(head == null){
            head = student;
            tail = student;
            return;
        }
        tail.next = student;
        tail = student;
    }

    /*
    Araya Ekleme - Silme
    * |   ☻-> (adding)
    * |☻->    ☻->     ☻-> ☻-> ☻-> ☻-> ♦
    * |          ☻-> (removing)
    */
    public static void addStudent2(int s, Student student){
        int count = 1;
        Student temp = head;

        while(temp != null){
            if(count == s){
                student.next=temp.next;
                temp.next = student;
                return;
            }
            temp = temp.next;
            count++;
        }
    }
    public static void removeStudent2(int s){
        int count = 1;
        Student temp = head;

        while(temp != null){
            if(count == s - 1 ){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
            count++;
        }
    }
    public static void removeStudent2ByName(String name){
        Student temp = head;

        while(temp != null){
            if(temp.next.getName().equals(name)){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    /*
    Baştan-Sondan Ekleme-Silme
        <- h                t
    * |☻-> |                |   ☻->
    * |    ☻->☻->☻->☻-> ☻-> ☻-> ♦
    * |    ☻-x              ☻-x
              |
              h
    */
    public static void addStudent2Begin(Student student){
        student.next = head;
        head = student;
    }
    public static void addStudent2Tail(Student student){
        tail.next=student;
        tail = student;
    }

    public static void removeStudent2Begin(){
        head=head.next;
    }

    public static void removeStudent2Tail(){
        Student temp=head;
        while(temp !=null){
            if(temp.next == tail){
                temp.next = null;
                tail=temp;
                return;
            }
            temp=temp.next;
        }
    }
}