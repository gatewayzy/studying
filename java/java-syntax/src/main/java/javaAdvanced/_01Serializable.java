package javaAdvanced;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class _01Serializable {

    static class Employee implements java.io.Serializable {

        private static final long serialVersionUID = -602932866640093016L;
        public String name;
        public String address;
        public transient int SSN;
        public int number;

        public void print() {
            System.out.println("name：" + name + "\naddress：" + address + "\nSSN：" + SSN + "\nnumber：" + number);
        }
    }

    public static void main(String[] args) throws Exception {
        serialization();
        ser();
    }

    // 序列化，使用java.io.ObjectOutputStream获取输出流，然后使用writeObject()方法序列化对象
    static void serialization() throws Exception {
        System.out.println("====== 开始序列化");
        Employee employee = new Employee();
        employee.name = "name-Ali";
        employee.address = "address-Where";
        employee.SSN = 11122333;
        employee.number = 101;

        FileOutputStream fileOut = new FileOutputStream("/employee.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(employee);

        out.close();
        fileOut.close();
    }

    // 反序列化，使用java.io.ObjectInputStream获取输入流，然后使用readObject()方法反序列化对象
    static void ser() throws Exception {
        System.out.println("====== 开始反序列化");
        Employee employee = null;

        FileInputStream fileIn = new FileInputStream("/employee.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        employee = (Employee) in.readObject();

        in.close();
        fileIn.close();
        employee.print();
    }
}
