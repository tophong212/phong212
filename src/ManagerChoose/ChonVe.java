package ManagerChoose;

import java.util.ArrayList;
import java.util.Scanner;

public class ChonVe {
    ArrayList<String> cveList = new ArrayList<>();

    public ChonVe() {
    }

    public void inputMnVe() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("============================================");
            System.out.print("||Nhập Tên vé cần thêm: ");
            String VE = scanner.nextLine();
            cveList.add(VE);
            System.err.print("||(Enter): Nhập thêm | ( 1 ): Thoát ");
            String n = scanner.nextLine();
            if (n.equals("1")) break;
        }
    }

    public void danhSachVe() {
        System.err.println("||==================================================||");
        System.err.println("||___________________DANH SÁCH vÉ___________________||");
        System.out.println("||                                                  ||");
        for (String s : cveList) {
            System.out.print("\t|" + s + "|");
        }
        System.out.println(" ");
    }

    public boolean checkVe(String VE) {
        for (String s : cveList) {
            if (s.equalsIgnoreCase(VE)) {
                return true;
            }
        }
        return false;
    }
}
