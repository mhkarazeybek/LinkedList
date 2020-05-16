/**
 * Students
 * hello everyone :) hello  
 */ 
public class Student {
    private String name;
    private int ogrNo;
    private int sinif;
    public Student next;

    public Student() {
        super();
    }

    public Student(String name, int sinif) {
        super();
        this.name = name;
        this.sinif = sinif;
        this.ogrNo = ++School.counter;
    }

    public String getName(){return this.name;}

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return ""+this.name+" 0317900"+this.ogrNo+" "+this.sinif;
    }
}              