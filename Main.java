package BaiTap;
import org.w3c.dom.ls.LSOutput;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static void nhapAlbum(Album ab) {
        System.out.print("Nhập mã CD: ");
        ab.setMaCD(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhập tên CD : ");
        ab.setTenCD(sc.nextLine());
        System.out.print("Nhập tên ca sĩ : ");
        ab.setCaSy(sc.nextLine());
        System.out.print("Nhập số lượng bài hát : ");
        ab.setSoBH(sc.nextInt());
        System.out.print("Nhập giá thành : ");
        ab.setGiaThanh(sc.nextFloat());
    }
    public static void main(String[] args) {
        Album alb[] = null;
        int a, n = 0;
        boolean flag = true;
        do {
            System.out.println("Ban chon lam gi?");
            System.out.println("1.Nhap thong tin CD \n" +
                    "2.Xuat danh sach Album.\n" + "3.Tinh tong gia thanh \n" + "4.Tong so luong CD \n" +
                    "5.Sap xep giam dan theo gia thanh\n"+"6.Sap xep tang dan theo tua CD\n"+"Nhap so khac đe thoat");
            a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Nhap so luong CD : ");
                    n = sc.nextInt();
                    alb = new Album[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("CD thu " + (i + 1)+": ");
                        alb[i] = new Album();
                        nhapAlbum(alb[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-20s %-20s %-10s %-20s \n", "007", "2001", "Chuyen bay ki niem", "Doan duong thanh xuan", "Son Tung M-TP", "Son Tung M-TP",  "48", "50",  "2.500.000", "4.300.000");
                    for (int i = 0; i < n; i++) {
                        alb[i].hienThiAlbum();
                    }
                    break;
                case 3:
                    int tong = 0;
                    for (int i = 0; i < n; i++) {
                        tong += alb[i].getGiaThanh();
                    }
                    System.out.println("" + 
                            "Tong gia thanh la: " + tong);
                    break;
                case 4:
                    System.out.println("Tong so luong CD la: " + n);
                    break;
                case 5:
                    Album temp = alb[0];
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (alb[i].getGiaThanh() < alb[j].getGiaThanh()) {
                                temp = alb[j];
                                alb[j] = alb[i];
                                alb[i] = temp;
                            }
                        }
                    }
                    System.out.println("Sap xep thanh cong, Nhap so 2 đe kiem tra!");
                    break;
                case 6:
                    temp = alb[0];
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (alb[i].getTenCD().compareTo(alb[j].getTenCD())>0) {
                                temp = alb[j];
                                alb[j] = alb[i];
                                alb[i] = temp;
                            }
                        }
                    }
                    System.out.println("Sap xep thanh cong, Nhap so 2 đe kiem tra!");
                    break;
                default:
                    System.out.println("Goodbye");
                    flag = false;
                    break;
            }
        }while (flag) ;
    }
}
