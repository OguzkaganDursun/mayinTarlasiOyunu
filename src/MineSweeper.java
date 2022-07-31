import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int elemanSayisi, mayinSayisi, secilenSatir, secilenSutun, satirSayisi, sutunSayisi, sayac1;

    String [][] oyunTahtasi;
    String [][] mayinTarlasiYerlesim;
    boolean oyunCalisiyorMu = true;

    Random rnd = new Random();
    Scanner scan = new Scanner(System.in);
    public MineSweeper(int satirSayisi, int sutunSayisi)
    {
        this.satirSayisi = satirSayisi;
        this.sutunSayisi = sutunSayisi;
        this.elemanSayisi = (this.satirSayisi * this.sutunSayisi);
        this.mayinSayisi = (this.elemanSayisi / 4);
        this.oyunTahtasi = new String[satirSayisi][sutunSayisi];
        this.mayinTarlasiYerlesim = new String[satirSayisi][sutunSayisi];
    }

    private void oyunTahtasiElemanlari()
    {
      for (int i = 0; i < this.oyunTahtasi.length; i++)
        {
            for (int j = 0; j < this.oyunTahtasi[0].length; j++)
            {
                if (this.oyunTahtasi[i][j] != "-")
                {
                    this.oyunTahtasi[i][j] = "-";
                    System.out.print(this.oyunTahtasi[i][j] + " ");
                }
                else
                {
                    System.out.print(this.oyunTahtasi[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    private void oyunTahtasiYaz(){
        for (String[] strings : this.oyunTahtasi) {
            for (String str : strings) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
    public void mayinYerlestirme()
    {
        int rastgeleSatir, rastgeleSutun, sayac = 0;
        System.out.println("Mayin Sayisi : " + mayinSayisi);
        for (int i = 0; i < this.mayinSayisi; i++)
        {
            while (sayac != mayinSayisi)
            {
                rastgeleSatir = rnd.nextInt(satirSayisi);
                rastgeleSutun = rnd.nextInt(sutunSayisi);
                if (this.mayinTarlasiYerlesim[rastgeleSatir][rastgeleSutun] != "*")
                {
                    this.mayinTarlasiYerlesim[rastgeleSatir][rastgeleSutun] = "*";
                    sayac++;
                    break;
                }
            }
        }
    }

    public void ekranaYazdirMayinlar(String str)
    {
        System.out.println("Mayinlarin Konumu");

        for (int i = 0; i < this.mayinTarlasiYerlesim.length; i++)
        {
            for (int j = 0; j < this.mayinTarlasiYerlesim[0].length; j++)
            {
                if (this.mayinTarlasiYerlesim[i][j] != "*")
                {
                    this.mayinTarlasiYerlesim[i][j] = "-";
                    System.out.print(this.mayinTarlasiYerlesim[i][j] + " ");
                }
                else
                {
                    System.out.print(this.mayinTarlasiYerlesim[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public int mayinKontrol()
    {
        sayac1 = 0;

        if(this.secilenSutun+1<=this.mayinTarlasiYerlesim[0].length-1)
        {
            if(this.mayinTarlasiYerlesim[this.secilenSatir][this.secilenSutun+1] == "*")
            {
                this.sayac1++;
            }
        }

        if(this.secilenSutun-1>=0)
        {
            if(this.mayinTarlasiYerlesim[this.secilenSatir][this.secilenSutun-1]== "*")
            {
                this.sayac1++;
            }
        }

        if(this.secilenSatir+1<=this.mayinTarlasiYerlesim.length-1)
        {
            if(this.mayinTarlasiYerlesim[this.secilenSatir+1][this.secilenSutun]== "*")
            {
                this.sayac1++;
            }
        }

        if(this.secilenSatir-1>=0)
        {
            if(this.mayinTarlasiYerlesim[this.secilenSatir-1][this.secilenSutun]== "*")
            {
                this.sayac1++;
            }
        }

        if(this.secilenSutun-1>=0 && this.secilenSatir-1>=0)
        {
            if(this.mayinTarlasiYerlesim[this.secilenSatir-1][this.secilenSutun-1]== "*")
            {
                this.sayac1++;
            }
        }

        if(this.secilenSutun-1>=0 && this.secilenSatir+1<=this.mayinTarlasiYerlesim.length-1)
        {
            if(this.mayinTarlasiYerlesim[this.secilenSatir+1][this.secilenSutun-1]== "*")
            {
                this.sayac1++;
            }
        }

        if(this.secilenSutun+1<=this.mayinTarlasiYerlesim[0].length-1 && this.secilenSatir-1>=0)
        {
            if(this.mayinTarlasiYerlesim[this.secilenSatir-1][this.secilenSutun+1]== "*")
            {
                this.sayac1++;
            }
        }

        if(this.secilenSutun+1<=this.mayinTarlasiYerlesim[0].length-1 && this.secilenSatir+1<=this.mayinTarlasiYerlesim.length-1)
        {
            if(this.mayinTarlasiYerlesim[this.secilenSatir+1][this.secilenSutun+1]== "*")
            {
                this.sayac1++;
            }
        }

        return this.sayac1;

    }

    public void oyunTahtasiYenile()
    {
        switch (this.mayinKontrol())
        {
            case 0 ->
            {
                this.oyunTahtasi[this.secilenSatir][this.secilenSutun] = "0";
                this.mayinTarlasiYerlesim[this.secilenSatir][this.secilenSutun] = "0";
            }
            case 1 ->
            {
                this.oyunTahtasi[this.secilenSatir][this.secilenSutun] = "1";
                this.mayinTarlasiYerlesim[this.secilenSatir][this.secilenSutun] = "1";
            }
            case 2 ->
            {
                this.oyunTahtasi[this.secilenSatir][this.secilenSutun] = "2";
                this.mayinTarlasiYerlesim[this.secilenSatir][this.secilenSutun] = "2";
            }
            case 3 ->
            {
                this.oyunTahtasi[this.secilenSatir][this.secilenSutun] = "3";
                this.mayinTarlasiYerlesim[this.secilenSatir][this.secilenSutun] = "3";
            }
            case 4 ->
            {
                this.oyunTahtasi[this.secilenSatir][this.secilenSutun] = "4";
                this.mayinTarlasiYerlesim[this.secilenSatir][this.secilenSutun] = "4";
            }
            case 5 ->
            {
                this.oyunTahtasi[this.secilenSatir][this.secilenSutun] = "5";
                this.mayinTarlasiYerlesim[this.secilenSatir][this.secilenSutun] = "5";
            }
            case 6 ->
            {
                this.oyunTahtasi[this.secilenSatir][this.secilenSutun] = "6";
                this.mayinTarlasiYerlesim[this.secilenSatir][this.secilenSutun] = "6";
            }
            case 7 ->
            {
                this.oyunTahtasi[this.secilenSatir][this.secilenSutun] = "7";
                this.mayinTarlasiYerlesim[this.secilenSatir][this.secilenSutun] = "7";
            }
            case 8 ->
            {
                this.oyunTahtasi[this.secilenSatir][this.secilenSutun] = "8";
                this.mayinTarlasiYerlesim[this.secilenSatir][this.secilenSutun] = "8";
            }
        }
    }

    public boolean devamMi()
    {
        for (String[] strings : this.mayinTarlasiYerlesim)
        {
            for (String str : strings)
            {
                if (str == "-")
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void calistir()
    {
        mayinYerlestirme();
        ekranaYazdirMayinlar(Arrays.toString(mayinTarlasiYerlesim));
        System.out.println("======================================");
        System.out.println("Oyun Basladi!\nBol Sans!");
        System.out.println();
        oyunTahtasiElemanlari();

        while (oyunCalisiyorMu)
        {

            //oyunTahtasiYaz();
            System.out.print("Satir Seciniz : ");
            secilenSatir = scan.nextInt();

            System.out.print("Sutun Giriniz : ");
            secilenSutun = scan.nextInt();


            if ( (this.secilenSatir < 0) || (this.secilenSatir > this.oyunTahtasi.length -1) ||
                    (this.secilenSutun < 0) || (this.secilenSutun > this.oyunTahtasi[0].length - 1) )
            {
                System.out.println("Oyun Alaninin Disinda Kalan Bir Secim Yaptiniz.\nLutfen Degerleri Tekrar Giriniz!");
                System.out.println("======================================");
                System.out.print("Satir Seciniz : ");
                secilenSatir = scan.nextInt();

                System.out.print("Sutun Giriniz : ");
                secilenSutun = scan.nextInt();
                System.out.println("======================================");

            }
            if (mayinTarlasiYerlesim[secilenSatir][secilenSutun] == "*")
            {
                System.out.println("======================================");
                System.out.println("Oyunu Kaybettiniz!");
                ekranaYazdirMayinlar(Arrays.toString(mayinTarlasiYerlesim));
                oyunCalisiyorMu = false;
            }
            else if (mayinTarlasiYerlesim[secilenSatir][secilenSutun] == "-")
            {
                this.mayinKontrol();
                this.oyunTahtasiYenile();
                this.oyunTahtasiYaz();
                if(!this.devamMi())
                {
                    System.out.println("======================================");
                    System.out.println("Tebrikler!\nOyunu Kazandiniz !");
                    oyunCalisiyorMu = false;
                }
            }
        }


    }
}
