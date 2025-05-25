package Port;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class Port1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = Portcnn.getConnection();
        ManagerLogin manigerMode = new ManagerLogin();
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("메뉴선택 :1. 관리자 2. 학생 3. 시스템종료");


            int menu = Integer.parseInt(sc.next());
            switch (menu) {
                case 1:
                    ManagerLogin.managerMode(sc);
                    break;
                case 2:

                    break;
                case 3:
                    return;

                default:
                    System.out.println("명령 입력이 잘못되었습니다. 다시 입력해주세요.");
            }
        }
    }
}