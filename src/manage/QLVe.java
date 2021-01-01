package manage;

import ManagerChoose.ChonVe;
import model.Ve;

import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QLVe {
    ArrayList<Ve> veList;

    public QLVe() {
        veList = new ArrayList<>();
    }

    public Scanner scanner = new Scanner(System.in);

    //Nhập thông tin cho danh sách
    public void input(ChonVe chonVe) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Số lượng vé: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("=======>NHẬP THÔNG TIN VÉ<=======");
            System.out.println("|_______________._______________|");
            System.out.println("| 1.Vé Trẻ em   | 2.Vé Người lớn|");
            System.out.println("'---------------^---------------'");
            System.out.print("|Chọn: ");
            String chon = scanner.nextLine();
            Ve ve = new Ve();
            if (chon.equals("1")) {
                ve.inputTE(chonVe);
                veList.add(ve);
            } else {
                ve.inputNL(chonVe);
                veList.add(ve);
            }
        }
    }

    //Hiển thị danh sách khu vui chơi ra
    public void display() {
        System.out.println("\t:---------------------------------------THÔNG TIN DANH SÁCH VÉ------------------------" +
                "----------------:");
        System.out.print("\t|_______________________________________________________________________________________" +
                "______________|");
        System.out.printf("\n\t| %-7s| %-20s| %-12s| %-12s| %-12s| %-12s| %-13s|\n", "Mã Vé", "Tên Vé", "Số trẻ em",
                "Số Người lớn", "Vé trẻ em", "Vé người lớn", "Thành tiền");
        System.out.print("\t|________|_____________________|_____________|_____________|_____________|_____________|" +
                "______________|");
        for (Ve ve : veList) {
            ve.display();
            System.out.println();
            System.out.print("\t|________|_____________________|_____________|_____________|_____________|__________" +
                    "___|______________|");
        }
    }

    //Tìm vé Theo mã
    public void find() {
        int ds = 0;
        System.out.print("Nhập mã vé cần tìm: ");
        String tim = scanner.nextLine();
        for (Ve ve : veList) {
            if (ve.getMaVe().equalsIgnoreCase(tim)||ve.getTenVe().equalsIgnoreCase(tim)) {
                System.out.print("\t._______________________________________________________________________________" +
                        "_______________________.");
                System.out.printf("\n\t| %-7s| %-20s| %-12s| %-12s| %-12s| %-12s| %-13s|\n", "Mã Vé", "Tên Vé",
                        "Số trẻ em", "Số Người lớn", "Vé trẻ em", "Vé người lớn", "Thành tiền");
                System.out.print("\t|________|_____________________|_____________|_____________|_____________|______" +
                        "_______|______________|");
                ve.display();
                System.out.println();
                System.out.print("\t|________|_____________________|_____________|_____________|_____________|______" +
                        "_______|______________|");
                ds++;
            }
        }
        if (ds == 0) {
            System.err.println("Tên hoặc Mã ( " + tim + " ) Không tồn tại !");
        }
    }

    //Xóa thông tin vé theo mã
    public void remove() {
        int ds = 0;
        System.out.println("||\t XOÁ THÔNG TIN");
        System.out.print("||Nhập vào mã vé: ");
        String mave = scanner.nextLine();
        for (int i = 0; i < veList.size(); i++) {
            if (veList.get(i).getMaVe().equals(mave)) {
                Ve ve = veList.remove(i);
                ds++;
                System.out.println("Danh sách sau khi xóa 1 mã: " + mave);
                display();
            }
        }
        if (ds == 0) {
            System.err.println("Nhập sai | Hoặc mã ( " + mave + " ) không có trong danh sách !");
        }
    }

    //Sắp xếp theo mã
    public void Sort() {
        Collections.sort(veList, (o1, o2) -> o1.getMaVe().compareToIgnoreCase(o2.getMaVe()));

        System.out.println("Danh sách sau khi được sắp xếp theo mã: ");
        display();
    }

    //B1: TẠO ĐỐI TƯỢNG LUỒNG VÀ LIÊN KẾT DỮ LIỆU
    public File file = new File("C:\\Users\\Admin\\Downloads\\QLKVC\\Ve.txt");

    // Ghi fileC:\Users\Admin\Downloads\QLKVC\Ve.txt
    public void writeFile(ArrayList<Ve> veList) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            //Bước 2: GHI DỮ LIỆU
            for (Ve ve : veList) {
                fileWriter.write(ve.toString());
            }
            //Bước 3: ĐÓNG LUỒNG
            fileWriter.close();
            System.out.println("Đã ghi file");
        } catch (IOException e) {
            System.err.println("Lỗi ghi file: " + e);
        }
    }

    // Đọc file C:\Users\Admin\Downloads\QLKVC\Ve.txt
    public void readFile(ArrayList<Ve> veList) {
        try {
            //kIỂM TRA XEM FILE CÓ TỒN TẠI HAY KHÔNG
            if (file.exists()) {
                //Bước 1: TẠO ĐỐI TƯỢNG LUỒNG VÀ LIÊN KẾT LUỒNG DỮ LIỆU
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    //Bước 2: ĐỌC DỮ LIỆU
                    veList.add(new Ve(line.split("#")[0], line.split("#")[1],
                            Integer.parseInt(line.split("#")[2]),
                            Integer.parseInt(line.split("#")[3]),
                            Integer.parseInt(line.split("#")[4]),
                            Integer.parseInt(line.split("#")[5])));
                }
                bufferedReader.close();
                //Bước 3: ĐÓNG LUỒNG
                fileReader.close();
            }
        } catch (IOException e) {
            System.err.println("Lỗi đọc file " + e);
        }
    }
    
    //Tính tổng tiền vé
    public void TongVe() {
        int ste = 0, snl = 0, vte = 0, vnl = 0, all = 0;
        for (Ve ve : veList) {
            ve.display();
            ste += ve.getSoTE();
            snl += ve.getSoNL();
            vte += ve.getVeTE();
            vnl += ve.getVeNL();
            all += ve.tienAll();
        }
        System.out.print("\n\t|==============================|=============|=============|=============|=============" +
                "|==============|");
        System.out.printf("\n\t|\t\t\t\t%-15s| %-12s| %-12s| %-12s| %-12s| %-13s|\n", "Tổng", ste, snl, vte, vnl, all);
    }

    //Thống kê theo tên vé
    public void ThongkeTen() {
        int ds = 0, s = 0, s1 = 0, s2 = 0;
        int s3 = 0, s4 = 0;
        System.out.print("\t||\t\t\tTên vé: ");
        String ten = scanner.nextLine();
        for (Ve ve : veList) {
            if (ve.getTenVe().equalsIgnoreCase(ten)) {
                s += ve.getSoTE();
                s1 += ve.getVeTE();
                s2 += ve.getSoNL();
                s3 += ve.getVeNL();
                s4 += ve.tienAll();
                ds++;
            }
        }
        System.out.println("\t||=======================================================||");
        System.out.printf("\t|| %-11s%-15s| %-11s%-15s||\n", "Số trẻ em:", s, "Giá Vé TE:", s1);
        System.out.println("\t||---------------------------|---------------------------||");
        System.out.printf("\t|| %-14s%-12s| %-11s%-15s||\n", "Số người lớn:", s2, "Giá vé NL:", s3);
        System.out.println("\t||---------------------------|---------------------------||");
        System.out.println("\t||=======================================================||");
        System.out.printf("\t||\t\t\t\t%-12s%-29s||\n", "Thành tiền:", s4);
        if (ds == 0) {
            System.err.println("Nhập sai ten !");
        }
    }

    //Thống kê Vé Trẻ em
    public void ThongKeTE() {
        int s = 0, s1 = 0, s2 = 0;
        for (Ve ve : veList) {
            ve.displayTE();
            s += ve.getSoTE();
            s1 += ve.getVeTE();
            s2 += ve.tienTE();
        }
        System.out.print("\n\t|========================|=============|=============|=============|");
        System.out.printf("\n\t|\t\t\t%-13s| %-12s| %-12s| %-12s|\n", "Tổng", s, s1, s2);
    }

    //Thống kê vé Người lớn
    public void ThongKeNL() {
        int s = 0, s1 = 0, s2 = 0;
        for (Ve ve : veList) {
            ve.displayNL();
            s += ve.getSoNL();
            s1 += ve.getVeNL();
            s2 += ve.tienNL();
        }
        System.out.print("\n\t|========================|=============|=============|=============|");
        System.out.printf("\n\t|\t\t\t%-13s| %-12s| %-12s| %-12s|\n", "Tổng", s, s1, s2);
    }

    //Menu Thống Kê tiền vé
    public void MenuThongKE() {
        readFile(veList);
        int chon;
        do {
            System.out.println("\n");
            System.out.println("\t\t\t*==========================================================*");
            System.out.println("\t\t\t|                     THỐNG KÊ TIỀN VÉ                     |");
            System.out.println("\t\t\t|============================::============================|");
            System.out.println("\t\t\t| 1. Thống kê theo tên vé    || 2. Thống kê vé trẻ em      |");
            System.out.println("\t\t\t|----------------------------{}----------------------------|");
            System.out.println("\t\t\t| 3. Thống kê vé người lớn   || 4. Thống kê Tổng Danh Sách |");
            System.out.println("\t\t\t*============================::============================*");
            System.out.print("\t\t\tLựa chọn: ");
            chon = Integer.parseInt(scanner.nextLine());
            switch (chon) {
                case 1 -> {
                    System.out.println("\t::-----------------<Thống KÊ THEO TÊN VÉ>----------------:: ");
                    System.out.println("\t||.......................................................||");
                    ThongkeTen();
                    System.out.print("\t||_______________________________________________________||");
                }
                case 2 -> {
                    System.out.println("\t:---------------------<THỐNG VÉ KÊ VÉ TRẺ EM>----------------------:");
                    System.out.print("\t|==================================================================|");
                    System.out.printf("\n\t| %-6s| %-15s| %-12s| %-12s| %-12s|",
                            "Mã Vé", "Tên Vé", "Số trẻ em", "Đơn giá", "Thành Tiền");
                    System.out.print("\n\t|-------|----------------|-------------|-------------|-------------|");
                    ThongKeTE();
                    System.out.println("\t|________________________|_____________|_____________|_____________|");
                }
                case 3 -> {
                    System.out.println("\t:---------------------<THỐNG VÉ KÊ VÉ TRẺ EM>----------------------:");
                    System.out.print("\t|==================================================================|");
                    System.out.printf("\n\t| %-6s| %-15s| %-12s| %-12s| %-12s|",
                            "Mã Vé", "Tên Vé", "Số Người lớn", "Đơn giá", "Thành Tiền");
                    System.out.print("\n\t|-------|----------------|-------------|-------------|-------------|");
                    ThongKeNL();
                    System.out.println("\t|________________________|_____________|_____________|_____________|");
                }
                case 4 -> {
                    System.out.println("\t:------------------------------------|THỐNG KÊ TỔNG DANH SÁCH VÉ|----------" +
                            "---------------------------:");
                    System.out.print("\t|============================================================================" +
                            "=========================|");
                    System.out.printf("\n\t| %-7s| %-20s| %-12s| %-12s| %-12s| %-12s| %-13s|\n", "Mã Vé", "Tên Vé",
                            "Số Trẻ em", "Số Người lớn", "Đơn Giá TE", "Đơn Giá NL", "Thành tiền");
                    System.out.print("\t|________|_____________________|_____________|_____________|_____________|___" +
                            "__________|______________|");
                    TongVe();
                    System.out.print("\t|______________________________|_____________|_____________|_____________|___" +
                            "__________|______________|");
                }
            }
        } while (chon != 0);
    }

    public void MenuVe() {
        ChonVe chonVe = new ChonVe();
        String choose;
        boolean kt;
        readFile(veList);
        do {
            kt = true;
            choose = null;
            System.out.println("\n");
            System.out.println("\t\t\t:============================================================================:");
            System.out.println("\t\t\t|                                 QUẢN LÝ VÉ                                 |");
            System.out.println("\t\t\t|============================================================================|");
            System.out.println("\t\t\t|| 1.[Nhập Tên Vé]                    ||  2.[Nhập thông tin vé]             ||");
            System.out.println("\t\t\t||====================================||====================================||");
            System.out.println("\t\t\t|| 3.[Hiển thị danh sách vé]          ||  4.[Xóa thông tin theo mã]         ||");
            System.out.println("\t\t\t||====================================||====================================||");
            System.out.println("\t\t\t|| 5.[Tìm kiếm Thông tin ]            ||  6.[Sắp xếp Thông tin ]            ||");
            System.out.println("\t\t\t||---------------------------------===][===---------------------------------||");
            System.out.println("\t\t\t==================================[0.Thoát]===================================");
            System.out.println("");
            do {
                try {
                    System.out.print("\t\t\tLựa chọn: ");
                    choose = scanner.nextLine();
                    if (choose.compareTo("0") == -1 || choose.compareTo("6") == 1) {
                        throw new Exception("");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (choose.compareTo("0") == -1 || choose.compareTo("6") == 1);
            switch (choose) {
                case "1" -> chonVe.inputMnVe();
                case "2" -> {
                    input(chonVe);
                    writeFile(veList);
                }
                case "3" -> display();
                case "4" -> remove();
                case "5" -> find();
                case "6" -> Sort();
                case "0" -> {
                    kt = false;
                    System.out.println("Menu Chính!");
                }
                default -> System.err.println("Nhập sai!");
            }
        } while (kt);
    }
}