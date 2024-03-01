import java.util.Scanner ;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("Şifre kaç karakterden oluşacak?: ");
            int sayiUzunlugu = scanner.nextInt();
            System.out.print("En az kaç rakam olacak?: ");
            int minRakam = scanner.nextInt();
            System.out.print("En az kaç küçük harf olacak?: ");
            int minKucukHarf = scanner.nextInt();
            System.out.print("En az kaç büyük harf olacak?: ");
            int minBuyukHarf = scanner.nextInt();
            System.out.print("En az kaç sembol olacak?: ");
            int minSembol = scanner.nextInt();

            if (minRakam + minKucukHarf + minBuyukHarf + minSembol > sayiUzunlugu) {
                System.out.println("Uyarı: Toplam sayılar, şifre uzunluğundan fazla olamaz.");
                continue;
            }else if (sayiUzunlugu < minRakam + minBuyukHarf+ minKucukHarf + minSembol) {
                System.out.println("Uyarı: Toplam sayılar, şifre uzunluğundan az olamaz.");
                continue;
            }

            StringBuilder password = new StringBuilder();
            for (int i = 0; i < sayiUzunlugu; i++) {
                int tip = random.nextInt(4);

                if (tip == 0 && minRakam > 0) {
                    password.append((char) (random.nextInt(10) + '0'));
                    minRakam--;
                } else if (tip == 1 && minKucukHarf > 0) {
                    password.append((char) (random.nextInt(26) + 'a'));
                    minKucukHarf--;
                } else if (tip == 2 && minBuyukHarf > 0) {
                    password.append((char) (random.nextInt(26) + 'A'));
                    minBuyukHarf--;
                } else if (tip == 3 && minSembol > 0) {
                    int sembolTip = random.nextInt(3);
                    if (sembolTip == 0) {
                        password.append((char) (random.nextInt(15) + 33));
                    } else if (sembolTip == 1) {
                        password.append((char) (random.nextInt(7) + 58));
                    } else {
                        password.append((char) (random.nextInt(6) + 91));
                    }
                    minSembol--;
                } else {
                    i--;
                }
            }

            System.out.println("Oluşturulan Şifre: " + password.toString());
            break;
        }






    }}