package ManagerChoose;

import java.util.ArrayList;
import java.util.Scanner;

public class ChonKhu {
    ArrayList<String> khuList = new ArrayList<>();

    public ChonKhu() {

    }

    public void inputMnKhu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("============================================");
            System.out.print("||Nhập Tên khu cần thêm: ");
            String khu = scanner.nextLine();
            khuList.add(khu);
            System.err.print("||(Enter): nhập thêm | ( 1 ) thoát: ");
            String n = scanner.nextLine();
            if (n.equals("1")) break;
        }
    }

    public void danhSachKhu() {
        System.err.println("||======================================================================================||");
        System.err.println("||____________________________________DANH SÁCH KHU_____________________________________||");
        System.out.println("||                                                                                      ||");
        for (String s : khuList) {
            System.out.print("\t|" + s + "|");
        }
        System.out.println(" ");
    }

    public boolean checkKhu(String khu) {
        for (String s : khuList) {
            if (s.equalsIgnoreCase(khu)) {
                return true;
            }
        }
        return false;
    }
}