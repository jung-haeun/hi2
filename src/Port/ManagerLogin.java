package Port;

import java.util.Scanner;

public class ManagerLogin {
	public static String id;
	public static void managerMode(Scanner sc) {
		int selNum = 0;
		Stulist stli = new Stulist();
		Stuadd stuad = new Stuadd();


		while (true) {

			if (selNum == 0) {

				System.out.println("관리자 메뉴 시작");
				System.out.println("1. 관리자 로그인 2. 관리자 가입 3. 홈으로");
				selNum = sc.nextInt();


			} else if (selNum == 1) {

				System.out.println("관리자 로그인 메뉴");

				System.out.print("아이디 입력>>");
				id = sc.next().toLowerCase();

				System.out.print("비번 입력 >>");
				String pw = sc.next().toLowerCase();

				PortSVC2 portSVC2 = new PortSVC2();
				int result = portSVC2.login(id, pw);
				System.out.println(result);
				System.out.println("관리자님 환영합니다.");
				while (true) {
					if (result == 0) {
						System.out.println("관리자메뉴선택 : 1.학생등록 2.학생목록 3.관리자목록 4.상태변경 5.역할변경 6.로그아웃");
						switch (sc.nextInt()) {
							case 1: //1. 학생등록
								stuad.stad(sc);
								break;
							case 2: //2. 학생목록
								stli.stlis(sc);
								break;
							case 3: // 3. 관리자목록
								break;
							case 4: // 4. 상태변경
								StateC.Statechange(sc);
								break;
							case 5: // 5. 역할변경

								break;
							default: // 6. 로그아웃
								return;
						}
					} else {
						if (result == 1) System.out.println("관리자가 아닙니다.");
						selNum = 0;
						break;
					}

				} if (selNum == 2) {
						//회원가입
						System.out.print("아이디 입력 >>");
						String mid = sc.next().toLowerCase();
						while (mid.length() >= 20) {
							System.out.println("최대 20Byte 이하로 입력하셔야 합니다.");
							System.out.print("아이디 입력 >>");
							mid = sc.next().toLowerCase();
						}
						System.out.print("비번 입력 >>");
						String mpw = sc.next().toLowerCase();
						while (mpw.length() >= 20) {
							System.out.println("최대 20Byte 이하로 입력하셔야 합니다.");
							System.out.print("비번 입력 >>");
							mpw = sc.next().toLowerCase();
						}
						System.out.print("이름 입력 >>");
						String mnm = sc.next().toLowerCase();
						while (mnm.length() >= 200) {
							System.out.println("최대 200Byte 이하로 입력하셔야 합니다.");
							System.out.print("이름 입력 >>");
							mnm = sc.next().toLowerCase();
						}
						System.out.println("가입성공");

					}
				}
			}

		}
//	public void studentMode(){
//		return;
//	}
	}

