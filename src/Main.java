import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int satirSayisi, sutunSayisi;

        System.out.print("**************************************\nMayin Tarlasi Oyununa Hos Geldiniz!\n**************************************" +
                "\n\nMayin Tarlasinin Boyutunuz Giriniz\nSatir Sayisini Giriniz : ");
        satirSayisi = scan.nextInt();
        System.out.print("Sutun Sayisini Giriniz : ");
        sutunSayisi = scan.nextInt();
        System.out.println();
        System.out.println("======================================");

        MineSweeper mayinTarlasiOyun = new MineSweeper(satirSayisi, sutunSayisi);

        mayinTarlasiOyun.calistir();

    }
}
