package manage;

import ManagerChoose.ChonTro;
import model.Trochoi;

import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QLTroChoi {
    ArrayList<Trochoi> tcList;

    public QLTroChoi() {
        tcList = new ArrayList<>();
    }

    public Scanner scanner = new Scanner(System.in);

    //Nhập danh sách thông tin các trò chơi
    public void input(ChonTro chonTro) {
        System.out.println("======================================================");
        System.out.println("||\t\t\t\tNHẬP THÔNG TIN TRÒ CHƠI\t\t\t\t||");
        System.out.print("||Số lượng: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.printf("|| Nhập thông tin trò chơi %-25s||\n", (i + 1));
            Trochoi tc = new Trochoi();
            tc.input(chonTro);
            tcList.add(tc);
        }
    }

    //Hiển thị danh sách thông tin trò chơi
    public void display() {
        System.out.println("\t:-------------------------------DANH SÁCH TRÒ CHƠI---------------------------------:");
        System.out.print("\t|__________________________________________________________________________________|");
        System.out.printf("\n\t| %-7s| %-20s| %-20s| %-9s| %-9s| %-6s|\n", "Mã trò", "Tên trò", "Dịch vụ",
                "Số lượng", "Đơn Giá", "Mã Khu");
        System.out.print("\t|________|_____________________|_____________________|__________|__________________|");
        for (Trochoi tc : tcList) {
            tc.display();
            System.out.println();
            System.out.print("\t|________|_____________________|_____________________|__________|__________________|");
        }
    }

    //Sắp xếp theo mã
    public void Sort() {
        Collections.sort(tcList, (o1, o2) -> o1.getMaTro().compareToIgnoreCase(o2.getMaTro()));

        System.out.println("Danh sách sau khi sắp xếp theo mã: ");
        display();
    }

    //Sửa thông tin
    public void update() {
        int ds = 0;
        System.out.println("||\tCẬP NHẬT");
        System.out.println("||Nhập Mã hoặc Tên: ");
        String ud = scanner.nextLine();
        for (Trochoi tc : tcList) {
            if (tc.getMaTro().equalsIgnoreCase(ud)|| tc.getTenTro().equalsIgnoreCase(ud)) {
                tc.input();
                ds++;
                System.err.println("Danh sách sau khi được cập nhật !");
                display();
            }
        }
        if (ds == 0) {
            System.err.println("Không tìm thấy (" + ud + ") Cần sửa !");
        }
    }

    //Xóa theo mã trò
    public void remove() {
        int ds = 0;
        System.out.println("||\tXOÁ THÔNG TIN");
        System.out.println("||Nhập mã trò cần xóa: ");
        String matro = scanner.nextLine();
        for (int i = 0; i < tcList.size(); i++) {
            if (tcList.get(i).getMaTro().equals(matro)) {
                Trochoi tc = tcList.remove(i);
                ds++;
                System.out.println("Danh sách sau khi xóa mã ( " + matro + " )");
                display();
            }
        }
        if (ds==0){
            System.err.println("Nhập sai hoặc " + matro + " không tồn tại !");
        }
    }

    //Tìm theo tên
    public void find() {
        int ds = 0;
        System.out.println("||\tTÌM THÔNG TIN");
        System.out.print("||Nhập Tên hoặc Mã: ");
        String tim = scanner.nextLine();
        for (Trochoi tc : tcList) {
//            if (tc.getTenTro().toLowerCase().contains(ten.toLowerCase())) {
            if (tc.getTenTro().equalsIgnoreCase(tim)|| tc.getMaTro().equalsIgnoreCase(tim)) {
                System.out.print("\t.__________________________________________________________________________________.");
                System.out.print("\t|__________________________________________________________________________________|");
                System.out.printf("\n\t| %-7s| %-20s| %-20s| %-9s| %-9s| %-6s|\n", "Mã trò", "Tên trò", "Dịch vụ",
                        "Số lượng", "Đơn Giá", "Mã Khu");
                System.out.print("\t|________|_____________________|_____________________|__________|__________|_______|");
                tc.display();
                System.out.print("\t|________|_____________________|_____________________|__________|__________|_______|");
                ds++;
            }
        }
        if (ds == 0) {
            System.err.println("Nhập sai tên hoặc mã (" + tim + ") Không tồn tại");
        }
    }

    public void Tongtien() {
        int sum = 0;
        for (Trochoi tc : tcList) {
            sum += tc.tienDv();
        }
        System.out.printf("\n\t|%-52s|%-14s%-15s|"," ","Tổng dịch vụ:", sum);
    }

    static File file = new File("C:\\Users\\Admin\\Downloads\\QLKVC\\TroChoi.txt");

    public void readFile(ArrayList<Trochoi> tcList) {
        try {
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    tcList.add(new Trochoi(line.split("#")[0],
                            line.split("#")[1],
                            line.split("#")[2],
                            Integer.parseInt(line.split("#")[3]),
                            Integer.parseInt(line.split("#")[4]),
                            line.split("#")[5]));
                }
                fileReader.close();
                bufferedReader.close();
            }
        } catch (IOException e) {
            System.err.println("Lỗi Đọc file " + e);
        }
    }

    public void writeFile(ArrayList<Trochoi> tcList) {
        try {
            if (file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            for (Trochoi tc: tcList) {
                fileWriter.write(tc.toString());
            }
        } catch (IOException e) {
            System.err.println("Lỗi ghi file " + e);
        }
    }

    public void MenuSxTK() {
        String choose;
        boolean kt;
        do {
            choose = null;
            kt = true;
            System.out.println("\n");
            System.out.println("\t\t:=====================================================================:");
            System.out.println("\t\t|                     TRA CỨU, SẮP XẾP, SỬA, XOÁ TRÒ                  |");
            System.out.println("\t\t|==================================::=================================|");
            System.out.println("\t\t| 1.[Tra thông tin Tro chơi ]      || 3.[Sắp xếp thông tin trò chơi ] |");
            System.out.println("\t\t|==================================||=================================|");
            System.out.println("\t\t| 2.[Cập nhật lại thông tin]       || 4.[Xoá Thông tin]               |");
            System.out.println("\t\t|-------------------------------===][===------------------------------|");
            System.out.println("\t\t===============================[0.Thoát]===============================");
            System.out.println("");
            do {
                try {
                    System.out.print("\tLựa Chọn: ");
                    choose = scanner.nextLine();
                    if (choose.compareTo("0") == -1 || choose.compareTo("4") == 1) {
                        throw new Exception("");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (choose.compareTo("0") == -1 || choose.compareTo("4") == 1);
            switch (choose) {
                case "1" -> find();
                case "2" -> {
                    update();
                    writeFile(tcList);
                }
                case "3" -> Sort();
                case "4" -> remove();
                case "0" -> kt = false;
                default -> System.err.println("Nhập sai !");
            }
        } while (kt);
    }

    public void MenuTC() {
        ChonTro chonTro = new ChonTro();
        boolean kt;
        readFile(tcList);
        String choose;
        do {
            kt = true;
            choose = null;
            System.out.println("\n");
            System.out.println("\t\t\t:============================================================================:");
            System.out.println("\t\t\t|                              QUẢN LÝ TRÒ CHƠI                              |");
            System.out.println("\t\t\t|============================================================================|");
            System.out.println("\t\t\t|| 1.[Nhập Tên trò chơi]              ||  2.[Nhập thông tin trò chơi]       ||");
            System.out.println("\t\t\t||====================================||====================================||");
            System.out.println("\t\t\t|| 3.[Hiển thị danh sách trò chơi]    ||  4.[Sắp xếp, sửa, xoá, tìm kiếm]   ||");
            System.out.println("\t\t\t||---------------------------------===][===---------------------------------||");
            System.out.println("\t\t\t==================================[0.Thoát]===================================");
            System.out.println("");
            do {
                try {
                    System.out.print("\t\t\tLựa chọn: ");
                    choose = scanner.nextLine();
                    if (choose.compareTo("0") == -1 || choose.compareTo("4") == 1) {
                        throw new Exception("");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (choose.compareTo("0") == -1 || choose.compareTo("4") == 1);
            switch (choose) {
                case "1" -> chonTro.inputMnTro();
                case "2" -> {
                    input(chonTro);
                    writeFile(tcList);
                }
                case "3" -> {
                    display();
                    Tongtien();
                }
                case "4" -> MenuSxTK();
                case "0" -> {
                    kt = false;
                    System.out.println("Menu Chính !");
                }
                default -> System.err.println("Nhập sai !");
            }
        } while (kt);
    }
}