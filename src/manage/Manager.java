package manage;

import DangNhap.DangNhap;

import java.text.ParseException;
import java.util.Scanner;

public class Manager {
    public void Quanly() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String chon;
        boolean kt;
        do {
            DangNhap dangNhap = new DangNhap();
            QLKhuVuiChoi qlKVC = new QLKhuVuiChoi();
            QLTroChoi qlTC = new QLTroChoi();
            QLVe qlVe = new QLVe();
            chon = null;
            kt = true;
            //Menu chính
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("\t\t\t\t\t:==========================================================================" +
                    "===============:");
            System.out.println("\t\t\t\t\t|                        TRƯỜNG ĐẠI HỌC SỰ PHẠM KĨ THUẬT HƯNG YÊN          " +
                    "               |");
            System.out.println("\t\t\t\t\t|                                Khoa Công Nghệ Thông Tin                  " +
                    "               |");
            System.out.println("\t\t\t\t\t|__________________________________________________________________________" +
                    "_______________|");
            System.out.println("\t\t\t\t\t|                                                                          " +
                    "               |");
            System.out.println("\t\t\t\t\t|                            CHƯƠNG tRÌNH QUẢN LÝ KHU VUI CHƠI             " +
                    "               |");
            System.out.println("\t\t\t\t\t|                                                                          " +
                    "               |");
            System.out.println("\t\t\t\t\t|==========================================================================" +
                    "===============|");
            System.out.println("\t\t\t\t\t| [Num 1] | Quản lý thông tin khu vui chơi                                 " +
                    "               |");
            System.out.println("\t\t\t\t\t|---------|----------------------------------------------------------------" +
                    "--------------|");
            System.out.println("\t\t\t\t\t| [Num 2] | Quản lí thông tin trò chơi                                     " +
                    "               |");
            System.out.println("\t\t\t\t\t|---------|----------------------------------------------------------------" +
                    "---------------|");
            System.out.println("\t\t\t\t\t| [Num 3] | Quản lý thông tin vé                                           " +
                    "               |");
            System.out.println("\t\t\t\t\t|---------│----------------------------------------------------------------" +
                    "---------------|");
            System.out.println("\t\t\t\t\t| [Num 4] | Thống kê                                                       " +
                    "               |");
            System.out.println("\t\t\t\t\t|---------'----------------------------------------------------------------" +
                    "---------------|");
            System.out.println("\t\t\t\t\t|                                        0.[Trở về]                        " +
                    "               |");
            System.out.println("\t\t\t\t\t'==========================================================================" +
                    "==============='");
            System.out.println("");
            do {
                try {
                    System.out.print("\t\tLựa Chọn: ");
                    chon = scanner.nextLine();
                    if (chon.compareTo("0") == -1 || chon.compareTo("4") == 1) {
                        throw new Exception("");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (chon.compareTo("0") == -1 || chon.compareTo("4") == 1);
            switch (chon) {
                case "1" -> qlKVC.MenuKVC();
                case "2" -> qlTC.MenuTC();
                case "3" -> qlVe.MenuVe();
                case "4" -> qlVe.MenuThongKE();
                case "0" -> dangNhap.MenuUpdate();
                default -> System.err.println("Nhập sai rồi !");
            }
        } while (kt);
    }
}
