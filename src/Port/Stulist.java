package Port;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Stulist {
    public void stlis(Scanner sc){
        ResultSet rs = null;
        String SNM, SID, SDATE, SPW;
        int SNO, STATE;
        Statement stmt1 = null;

                try {
                    String sql = "SELECT SNO, SNM, SID, SPW, SDATE, STATE FROM student";
                    // sql += "(kor+eng+mat) AS tot,"; // 문자 인덱스 사용을 위해 별칭 필요
                    // sql += "(kor+eng+mat)/3 AS ave "; // 문자 인덱스 사용을 위해 별칭 필요
                    // sql += " FROM score ORDER BY hak";
                    stmt1 = Portcnn.createStatement();
                    rs = stmt1.executeQuery(sql);

                    while (rs.next()) {
                        SNO = rs.getInt("SNO");
                        SNM = rs.getString("SNM");
                        SID = rs.getString("SID");
                        SPW = rs.getString("SPW");
                        SDATE = rs.getString("SDATE");
                        STATE = rs.getInt("STATE");

                        System.out.println("학생정보 [학번=" + SNO +
                                ", 이름=" + SNM +
                                ", 아이디=" + SID +
                                ", 비밀번호=" + SPW +
                                ", 입학일자=" + SDATE +
                                ", 상태=" + (STATE == 1 ? "사이트가입" : "사이트미가입") + "]");
                    }
                    rs.close();
                    stmt1.close();
                } catch (Exception e) {
                    System.out.println(e.toString());

                }
        }
    }

