package   com.example;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        //masukkan siapa namamu
        System.out.println("siapa namamu: ");
        String name = new Scanner(System.in).nextLine();

        // masukkan apa jenis kelaminmu
        System.out.println(" (L/P): ");

        String gender = new Scanner(System.in).nextLine().toUpperCase();
        boolean validasiGender = validateGender(gender);

        if (validasiGender) {
            System.out.println("jenis kelaminmu: " + gender);

        } else {
            System.out.println("gendermu tidak ditemukan. tolong masukkan gender yang benar.");
        }

        // masukkan berapa tanggal lahirmu
        System.out.print("masukkan tanggal lahir (YYYY-MM-DD): ");
        String InputUltah = new Scanner(System.in).nextLine();

        // untuk mengetahui jika format yangdimasukkan salah
        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(InputUltah);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter in YYYY-MM-DD format.");
            return; 
        }

        // untuk menghitung berapa umur yang dimasukkan 
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);

        // memun culkan output seperti contoh
        System.out.println("Namamu adalah: " + name);
        System.out.println("Jenis Kelaminmu adalah: " + gender);
        System.out.println("Umurmu Sekarang adalah: " + age.getYears() + " tahun");

    }

    // untuk memvalidasi apa gender yang kamu pilih
    private static boolean validateGender(String gender) {
        return gender.equals("L") || gender.equals("P") ;
    }
}
