package ManagerChoose;

import java.util.ArrayList;
import java.util.Scanner;

public class ChonTro {
    ArrayList<String> troList = new ArrayList<>();

    public ChonTro() {

    }

    public void inputMnTro() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("============================================");
            System.out.print("||Nhập tên trò cần thêm: ");
            String ten = scanner.nextLine();
            troList.add(ten);
            System.err.print("||(Enter): Nhập thêm | ( 1 ): Thoát ");
            String n = scanner.nextLine();
            if (n.equals("1")) break;
        }
    }

    public void danhSachTro() {
        System.err.println("||======================================================================================||");
        System.err.println("||____________________________________DANH SÁCH TRÒ_____________________________________||");
        System.out.println("||                                                                                      ||");
        for (String s : troList) {
            System.out.print("\t|" + s + "|");

        }
    }

    public boolean checkTro(String tro) {
        for (String s : troList) {
            if (s.equalsIgnoreCase(tro)) {
                return true;
            }
        }
        return false;
    }
}