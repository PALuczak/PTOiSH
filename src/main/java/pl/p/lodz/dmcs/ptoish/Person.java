package pl.p.lodz.dmcs.ptoish;

import java.io.*;
import java.util.Date;

public class Person implements Serializable, Externalizable {
    private String name;
    private String surname;
    private Date birthday;
    private int age;

    public Person(){}

    public Person(String name, String surname, Date birthday, int age) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
        out.writeUTF(this.surname);
        out.writeObject(this.birthday);
        out.writeInt(this.age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.surname = in.readUTF();
        this.birthday = (Date) in.readObject();
        this.age = in.readInt();
    }
}
