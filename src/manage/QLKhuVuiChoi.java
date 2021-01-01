package manage;

import ManagerChoose.ChonKhu;
import model.KhuVuiChoi;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class QLKhuVuiChoi {

    ArrayList<KhuVuiChoi> kvcList;

    public Scanner scanner = new Scanner(System.in);

    public QLKhuVuiChoi() {
        kvcList = new ArrayList<>();
    }

    //Nhập thông tin khu
    public void input(ChonKhu chonKhu)  {
        System.out.println("==================================================");
        System.out.println("||\t\t\tNHẬP THÔNG TIN KHU VUI CHƠI\t\t\t||");
        System.out.print("|| Số lượng: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.printf("|| Nhập thông tin Khu %-26s||\n", (i + 1));
            KhuVuiChoi kvc = new KhuVuiChoi();
            kvc.input(chonKhu);
            kvcList.add(kvc);
        }
    }

    //Hiển thị thông tin
    public void display() {
        System.out.println("\t:------------------------------------DANH SÁCH KHU VUI CHƠI-------------------------" +
                "-------:");
        System.out.print("\t|_____________________________________________________________________________________" +
                "_____|");
        System.out.printf("\n\t| %-7s| %-25s| %-15s| %-10s| %-11s|%-12s|\n", "Mã Khu", "Tên Khu", "Vị trí", "Diện tích",
                "Giờ mở cửa", "Giờ đóng cửa");
        System.out.print("\t|________|__________________________|________________|___________|____________|________" +
                "____|");
        for (KhuVuiChoi khuVuiChoi : kvcList) {
            khuVuiChoi.display();
            System.out.println();
            System.out.print("\t|________|__________________________|________________|___________|____________|____" +
                    "________|");
        }
    }

    //Sắp xếp (Mã)
    public void Sort() {
        Collections.sort(kvcList, ((o1, o2) -> o1.getMaKhu().compareToIgnoreCase(o2.getMaKhu())));
        System.out.println("Danh sách sau khi sắp xếp theo mã: ");
        display();
    }

    //Tìm thông tin (tên hoặc mã):
    public void find() {
        int ds = 0;
        System.out.println("||\t TÌM THÔNG TIN");
        System.out.print("Nhập tên hoặc mã: ");
        String tk = scanner.nextLine();
        for (KhuVuiChoi kvc : kvcList) {
            if (kvc.getTenKhu().equalsIgnoreCase(tk) || kvc.getMaKhu().equalsIgnoreCase(tk)) {
                System.out.print("\t_________________________________________________________________________________" +
                        "____________");
                kvc.display();
                System.out.println();
                System.out.println("\t|________|__________________________|________________|___________|____________|" +
                        "____________|");
                ds++;
            }
        }
        if (ds == 0) {
            System.err.println("Nhập sai tên hoặc (" + tk + ") không tồn tại !");
        }
    }

    //Sửa chữa thông tin theo mã khu
    public void update() {
        int ds = 0;
        System.out.println("||\tCẬP NHẬT");
        System.out.print("||Nhập mã hoặc tên khu: ");
        String ud = scanner.nextLine();
        for (KhuVuiChoi kvc : kvcList) {
            if (kvc.getMaKhu().equals(ud) || kvc.getTenKhu().equalsIgnoreCase(ud)) {
                kvc.input();
                ds++;
                System.out.println("Thông tin sau khi sửa!");
                display();
            }
        }
        if (ds == 0) {
            System.err.println("Không tìm thấy mã ( " + ud + " ) cần sửa !");
        }
    }

    //Xóa Theo mã khu
    public void remove() {
        int ds = 0;
        System.out.println("=================================================");
        System.out.println("||\t\t\t\tXOÁ THÔNG TIN KHU\t\t\t\t|");
        System.out.print("||Nhập mã hoặc tên: ");
        String makhu = scanner.nextLine();
        for (int i = 0; i < kvcList.size(); i++) {
            if (kvcList.get(i).getMaKhu().equalsIgnoreCase(makhu)) {
                KhuVuiChoi kvc = kvcList.remove(i);
                ds++;
                System.out.println("Danh sách sau khi xóa mã: " + makhu);
                display();
            }
        }
        if (ds == 0) {
            System.err.println("Nhập sai mã | Hoặc mã ( " + makhu + " )Không tồn tại !");
        }
    }

    static File file = new File("C:\\Users\\Admin\\Downloads\\QLKVC\\KhuVuiChoi.txt");

    //Đọc file C:\Users\Admin\Downloads\QLKVC\KhuVuiChoi.txt
    public void readFile(ArrayList<KhuVuiChoi> kvcList) {
        try {
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    kvcList.add(new KhuVuiChoi(line.split("#")[0],
                            line.split("#")[1],
                            line.split("#")[2],
                            line.split("#")[3],
                            line.split("#")[4],
                            line.split("#")[5]));
                }
                fileReader.close();
                bufferedReader.close();
            }
        } catch (IOException e) {
            System.err.println("Lỗi đọc file " + e);
        }
    }

    //Ghi file C:\Users\Admin\Downloads\QLKVC\KhuVuiChoi.txt
    public void writeFile(ArrayList<KhuVuiChoi> kvcList) {
        try {
            if (file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            for (KhuVuiChoi kvc : kvcList) {
                fileWriter.write(kvc.toString());

            }
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Lỗi ghi file: " + e);
        }
    }

    public void MenuSxTK() {
        Scanner scanner = new Scanner(System.in);
        String choose;
        boolean kt;
        do {
            kt = true;
            choose = null;
            System.out.println("\n");
            System.out.println("\t\t:=====================================================================:");
            System.out.println("\t\t|                       TRA CỨU, SẮP XẾP, SỬA, XOÁ                    |");
            System.out.println("\t\t|==================================::=================================|");
            System.out.println("\t\t| 1.[ Tìm kiếm thông tin Khu ]     || 3.[ Sắp xếp thông tin Khu ]     |");
            System.out.println("\t\t|==================================||=================================|");
            System.out.println("\t\t| 2.[ Cập nhật lại thông tin ]     || 4.[ Xoá Thông tin ]             |");
            System.out.println("\t\t|-------------------------------===][===------------------------------|");
            System.out.println("\t\t===============================[0.Thoát]===============================");
            System.out.println("");
            do {
                try {
                    System.out.print("\t\tLựa chọn: ");
                    System.out.println("");
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
                    writeFile(kvcList);
                }
                case "3" -> Sort();
                case "4" -> remove();
                case "0" -> kt = false;
                default -> System.err.println("Nhập sai!!!");
            }
        } while (kt);
    }

    public void MenuKVC()  {
        Scanner scanner = new Scanner(System.in);
        ChonKhu chonKhu = new ChonKhu();
        readFile(kvcList);
        String choose;
        boolean kt;
        do {
            kt = true;
            choose = null;
            System.out.println("\n");
            System.out.println("\t\t\t:============================================================================:");
            System.out.println("\t\t\t|                            QUẢN LÝ KHU VUI CHƠI                            |");
            System.out.println("\t\t\t|============================================================================|");
            System.out.println("\t\t\t|| 1.[Nhập Tên khu vui chơi]          ||  2.[Nhập thông tin khu vui chơi]   ||");
            System.out.println("\t\t\t||====================================||====================================||");
            System.out.println("\t\t\t|| 3.[Hiển thị danh sách khu ]        ||  4.[Sắp xếp, sửa, xoá, tìm kiếm ]  ||");
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
                case "1" -> chonKhu.inputMnKhu();
                case "2" -> {
                    input(chonKhu);
                    writeFile(kvcList);
                }
                case "3" -> display();
                case "4" -> MenuSxTK();
                case "0" -> {
                    kt = false;
                    System.out.println("Menu Chính !");
                }
                default -> System.err.println("Nhập sai!!!");
            }
        } while (kt);
    }
}