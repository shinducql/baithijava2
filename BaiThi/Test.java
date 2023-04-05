package SQL.BaiThi;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException {


        ControllerStudents cs = new ControllerStudents();
        Scanner scanner = new Scanner(System.in);
        int x ;
            do {
                System.out.println("1. Add student records\n 2. Display student records\n 3. Save \n 4. Exit\n ");

                System.out.printf("Nhập Chức Năng Bạn Muốn: ");
                x = scanner.nextInt();


                switch (x) {
                    case 1:
                        cs.Add();
                        break;

                    case 2:
                        System.out.println("Danh Sách Học Sinh Đã Nhập.");
                        cs.display();
                        break;

                    case 3:
                        cs.Update();

                        break;





                }


            }while (x<4);


    }
}


