package Port;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static dbc7.db.JdbcUtil.*;

public class StateC {
    public static void Statechange(Scanner sc){
        Connection con = Portcnn.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) cnt FROM manager WHERE ROLE = 'SUPER' AND STATE = 1 AND Mid = ?";
        try {

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ManagerLogin.id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int dbId = rs.getInt("cnt");
                if (dbId == 0) {
                    System.out.println("수정할 수 있는 권한이 없습니다.");
                    // 다시 메뉴를 선택할 수 있는 곳으로 돌아가기
                    return;
                } else {
                    //수정할 수 있는 코드를 작성하기
                    sc.nextLine();
                    System.out.print("변경할 아이디 입력>>");
                    String mid = sc.next();
                    System.out.print("변경할 상태 입력(0.사용불가 또는 대기 1.사용가능)>>");
                    int st;
                    try {
                        st = sc.nextInt();
                        sc.nextLine(); // 버퍼 비우기
                        if (st != 0 && st != 1) {
                            System.out.println("잘못된 입력입니다. 상태는 0 또는 1만 입력 가능합니다.");
                            return;
                        }
                    } catch (Exception e) {
                        sc.nextLine(); // 잘못 입력한 버퍼 비우기
                        System.out.println("숫자로만 입력하세요.");
                        return;
                    }
                    String sqp = "UPDATE manager set state = ? where MID = ?";
                    pstmt = con.prepareStatement(sqp);

                    pstmt.setInt(1, st);
                    pstmt.setString(2, mid);
                    int updateCount = pstmt.executeUpdate();
                    if (updateCount > 0) {
                        System.out.println("상태변경됨");
                    } else {
                        System.out.println("변경실패");
                    }


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
            close(con);
        }


    }
}