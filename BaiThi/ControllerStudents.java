package SQL.BaiThi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerStudents {
    ArrayList<Students> list = new ArrayList<>();
    String StudentID, Name,Address, Phone;
    Scanner scanner = new Scanner(System.in);
    public int  Add(){
        System.out.printf("Nhập StudentID: ");
        StudentID = scanner.nextLine();
        System.out.printf("Nhập Name: ");
        Name = scanner.nextLine();
        System.out.printf("Nhập Address: ");
        Address = scanner.nextLine();
        System.out.printf("Nhập Phone: ");
        Phone = scanner.nextLine();

        Students st = new Students(StudentID, Name,Address, Phone);
        list.add(st);

        return 0;
    }

    public void display() {
        for (Students st : list) {
            System.out.println(st.toString());
        }
    }


    public void Update() {

        for (Students st : list) {

            try (
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "");

            ) {


                PreparedStatement pstmt = conn.prepareStatement("insert into students values (?, ?, ?, ?)");


                pstmt.setString(1, st.getStudentID());
                pstmt.setString(2, st.getName());
                pstmt.setString(3, st.getAddress());
                pstmt.setString(4, st.getPhone());

                int check = pstmt.executeUpdate();
                if (check >= 1) {
                    System.out.println("Update row " );
                } else {
                    System.out.println("No Update");
                }

            }

            catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
        list.clear();

    }


}
