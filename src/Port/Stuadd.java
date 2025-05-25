package Port;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class Stuadd {
    public void stad(Scanner sc){
            try {

                String sid = null; // 아디
                String spw = null; // 비번
                String sdate = " "; // 입학일자
                String state = "0";
                String sql = "INSERT INTO student ( sno, snm , sid , spw , sdate , state ) " + "values(?,?,?,?,?,?)";
                PreparedStatement stmt = Portcnn.prepareStatement(sql);

                System.out.println("학생 등록 메뉴");

                System.out.print("학번입력(예: 202410001)>>");

                int sno = sc.nextInt();
                sc.nextLine(); // 씹힘 방지

                System.out.print("이름 입력>>");
                String snm = sc.nextLine();

                System.out.print("입학 일자(예: 20240302)>>");
                sdate = sc.nextLine();

                stmt.setInt(1, sno);
                stmt.setString(2, snm);
                stmt.setString(3, sid);
                stmt.setString(4, spw);
                stmt.setString(5, sdate);
                stmt.setString(6, state);

                stmt.executeUpdate();

                System.out.println("등록 성공");

                stmt.close();
            } catch (Exception e) {
                System.err.println(e.toString());
            } finally {
                System.out.println("끝");

            }
        }

    }


