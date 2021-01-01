package DangNhap;

import manage.Manager;
import model.NguoiDung;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.Scanner;

public class DangNhap {
    ArrayList<NguoiDung> ndList = new ArrayList<>();

    public Scanner scanner = new Scanner(System.in);

    public void dangKy() {
        System.out.println("\t\t\t==========================================");
        System.out.println("\t\t\t||\t\t\tĐĂNG KÝ TÀI KHOẢN\t\t\t||");
        NguoiDung nd = new NguoiDung();
        nd.Dangky();
        System.out.println("\t\t\t||______________________________________||");
        ndList.add(nd);
    }

    public void login() throws ParseException {
        int ds = 0;
        System.out.println("\t\t\t==========================================");
        System.out.println("\t\t\t||\t\t\t\tĐĂNG NHẬP\t\t\t\t||");
        for (NguoiDung nd : ndList) {
            System.out.println("\t\t\t||______________________________________||");
            System.out.print("\t\t\t||\tTài Khoản: ");
            String tk = scanner.nextLine();
            System.out.println("\t\t\t||______________________________________||");
            System.out.print("\t\t\t||\tMật khẩu: ");
            String mk = scanner.next();
            if (nd.getUsername().equalsIgnoreCase(tk) && nd.getPassword().equals(mk)) {
                System.out.println("\t\t\t||______________________________________||");
                MenuUpdate();
                ds++;
            }
        }
        if (ds == 0) {
            System.err.print("\t\t\tTài khoản hoặc mật khẩu không tồn tại !");
        }
    }

    public void display() {
        System.out.println("\t\t\t==========================================");
        System.out.println("\t\t\t||\t\t\tTHÔNG TIN TÀI KHOẢN\t\t\t||");
        System.out.println("\t\t\t||______________________________________||");
        for (NguoiDung nguoiDung : ndList) {
            nguoiDung.display();
            System.out.println("\t\t\t||______________________________________||");
        }
    }

    //link file
    public File file = new File("C:\\Users\\Admin\\Downloads\\QLKVC\\Nguoidung");

    //Đọc file C:\Users\Administrator\IdeaProjects\Nguoidung.txt
    public void readFile(ArrayList<NguoiDung> ndList) {
        try {
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    ndList.add(new NguoiDung(line.split("#")[0],
                            line.split("#")[1],
                            line.split("#")[2],
                            line.split("#")[3],
                            line.split("#")[4],
                            line.split("#")[5]));
                }
                bufferedReader.close();
                fileReader.close();
            }
        } catch (IOException e) {
            System.err.println("Lỗi đọc file " + e);
        }
    }

    //Ghi file C:\Users\Administrator\IdeaProjects\Nguoidung.txt
    public void writeFile(ArrayList<NguoiDung> ndList) {
        try {
            if (file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            for (NguoiDung nd : ndList) {
                fileWriter.write(nd.toString());
            }
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Lỗi ghi file " + e);
        }
    }
    public void updatepw() {
        int ds = 0;
        System.out.println("\t\t\t==========================================");
        System.out.println("\t\t\t||\t\t\tTHAY ĐỔI MẬT KHẨU\t\t\t||");
        System.out.print("\t\t\t|| Nhập Mật khẩu cũ: ");
        String mk = scanner.nextLine();
        System.out.println("\t\t\t||======================================||");
        for (NguoiDung nd : ndList) {
            if (nd.getPassword().equalsIgnoreCase(mk)) {
                nd.Doimk();
                ds++;
                System.out.println("\t\t\t||______________________________________||");
            }
        }
        if (ds == 0) {
            System.err.println("\t\t\tNhập sai mật khẩu !");
        }
    }

    public void update() {
        int ds = 0;
        System.out.println("\t\t\t==========================================");
        System.out.println("\t\t\t||\t\t\tTHAY ĐỔI THÔNG TIN\t\t\t||");
        System.out.print("\t\t\t|| Nhập Mật khẩu: ");
        String mk = scanner.nextLine();
        System.out.println("\t\t\t||======================================||");
        for (NguoiDung nd : ndList) {
            if (nd.getPassword().equalsIgnoreCase(mk)) {
                nd.update();
                System.out.println("\t\t\t||______________________________________||");
                ds++;
            }
        }
        if (ds == 0) {
            System.err.println("\t\t\tNhập sai mật khẩu !");
        }
    }

    public void MenuUpdate() throws ParseException {
        Manager manager = new Manager();
        String choose;
        do {
            choose = null;
            display();
            System.out.println(":===================================================================:");
            System.out.println("| 1. Thay đổi thông tin|| 2.Đổi mật khẩu       || 3.Menu Quản lý    |");
            System.out.println("|______________________||______________________||___________________|");
            System.out.println("============================[0.Đăng Xuất]============================");
            do {
                try {
                    choose = scanner.nextLine();
                    if (choose.compareTo("0") == -1 || choose.compareTo("3") == 1) {
                        throw new Exception("");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (choose.compareTo("0") == -1 || choose.compareTo("3") == 1);
            switch (choose) {
                case "1" -> {
                    update();
                    writeFile(ndList);
                }
                case "2" -> {
                    updatepw();
                    writeFile(ndList);
                }
                case "3" -> manager.Quanly();
                case "0" -> {
                    System.out.println("Tạm biệt!");
                    System.exit(0);

                }
            }
        }while (true);
    }

    public void MenuNDDN() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        readFile(ndList);
        String chon;
        boolean kt;
        do {
            chon = null;
            kt = true;
            System.out.println("\n");
            System.out.println("\t\t\t:============================================:");
            System.out.println("\t\t\t|\t\t\t<TÀI KHOẢN NGƯỜI DÙNG>\t\t\t |");
            System.out.println("\t\t\t|=====================::=====================|");
            System.out.println("\t\t\t|     1.Đăng Nhập     ||      2.Đăng ký      |");
            System.out.println("\t\t\t|_____________________||_____________________|");
            System.out.println("\t\t\t===================[0.Thoát]==================");
            System.out.print("\t\t\tNhập: ");
            do {
                try {
                    chon = scanner.nextLine();
                    if (chon.compareTo("0") == -1 || chon.compareTo("2") == 1) {
                        throw new Exception("");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (chon.compareTo("0") == -1 || chon.compareTo("2") == 1);
            switch (chon) {
                case "1":
                    login();
                    break;
                case "2":
                    dangKy();
                    writeFile(ndList);
                    break;
                case "0":
                    kt = false;
            }
        } while (kt);
    }
}
