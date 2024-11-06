import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*

        Kreirajte program koji omogućava unos, pregled i analizu podataka o studentima. Svaki student ima svoje ime, prezime, broj indeksa i prosjek ocjena.

        Zahtjevi:
        Kreiranje klase Student:
        Kreirajte klasu Student s privatnim atributima:
        ime (tipa String)
        prezime (tipa String)
        brojIndeksa (tipa String)
        prosjekOcjena (tipa double)
        Dodajte konstruktor koji inicijalizira sve atribute.
        Kreirajte metode getIme(), getPrezime(), getBrojIndeksa(), i getProsjekOcjena() kako bi omogućili dohvaćanje tih vrijednosti.

        Glavna klasa:
        U glavnoj klasi, kreirajte listu ArrayList<Student> kako biste pohranili sve unesene studente.
        Koristite metodu Scanner za unos podataka o studentima.

        Funkcionalnosti programa:
        Unos podataka: Omogućite korisniku unos podataka za više studenata. Nakon unosa svakog studenta, korisnik treba imati opciju da unese još jednog ili završi unos.
        Ispis svih studenata: Nakon unosa svih studenata, ispišite popis sa svim podacima o studentima.
        Analiza podataka:
        Pronađite i ispišite podatke o studentu s najvišim prosjekom.
        Pronađite i ispišite podatke o studentu s najnižim prosjekom.
        Ispišite prosjek ocjena svih studenata.

        2. Zadatak za razmisljanje:
        Imamo klasu Student iz prethodnog zadatka, napravite funkciju promjeniProsjekOcjena koja ce promjeniti prosjek ocjena.
        Kreirajte varijablu i u nju spremite objekt student, nakon toga napravite drugu varijablu u koju spremate vrijednost prve varijable.
        Pozovite funkciju za promjenu prosjeka ocjena iz prve varijable
        provjerite vrijednosti prosjek ocjena obje varijable te u komentar koda obrazlozite zasto su vrijednosti takve kakve jesu medu varijablma

    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studenti = new ArrayList<>();

        boolean unosZavrsen = false;
        while (!unosZavrsen) {

            System.out.println("Unesite podatke o studentu:");

            System.out.print("Ime: ");
            String ime = scanner.nextLine();

            System.out.print("Prezime: ");
            String prezime = scanner.nextLine();

            System.out.print("Broj indeksa: ");
            String brojIndeksa = scanner.nextLine();

            System.out.print("Prosječna ocjena: ");
            double prosjekOcjena = scanner.nextDouble();

            studenti.add(new Student(ime, prezime, brojIndeksa, prosjekOcjena));

            System.out.print("Želite li unijeti još jednog studenta? (da/ne): ");
            String odgovor = scanner.next();


            // ovo mozda popraviti, dodati da vrati na pocetak ako se unese ni ne ni da
            if (odgovor.endsWith("ne") || odgovor.endsWith("NE")) {
                unosZavrsen = true;
            } else if (odgovor.endsWith("da") || odgovor.endsWith("DA")) {
                scanner.nextLine();
            }
        }

        System.out.println("\nPopis svih studenata:");
        for (Student student : studenti) {
            System.out.println(student.getIme() + " " + student.getPrezime() +
                    ", Broj indeksa: " + student.getBrojIndeksa() +
                    ", Prosječna ocjena: " + student.getProsjekOcjena());
        }

        // Pronalazak studenata s najvišim i najnižim prosjekom
        Student studentNajvisiProsjek = pronadjiStudentaSaNajvisimProsjekom(studenti);
        Student studentNajniziProsjek = pronadjiStudentaSaNajnizimProsjekom(studenti);

        System.out.println("\nStudent sa najvišim prosjekom: " + studentNajvisiProsjek.getIme() + " " + studentNajvisiProsjek.getPrezime());
        System.out.println("Student sa najnižim prosjekom: " + studentNajniziProsjek.getIme() + " " + studentNajniziProsjek.getPrezime());

        // Izračunavanje prosjeka ocjena svih studenata
        double prosjekOcjenaSvih = izracunajProsjekOcjena(studenti);

        System.out.printf("\nProsječan prosjek ocjena svih studenata: %.2f", prosjekOcjenaSvih);
    }

    private static Student pronadjiStudentaSaNajvisimProsjekom(List<Student> studenti) {
        Student najvisiProsjek = studenti.get(0);
        for (int i = 1; i < studenti.size(); i++) {
            if (studenti.get(i).getProsjekOcjena() > najvisiProsjek.getProsjekOcjena()) {
                najvisiProsjek = studenti.get(i);
            }
        }
        return najvisiProsjek;
    }

    private static Student pronadjiStudentaSaNajnizimProsjekom(List<Student> studenti) {
        Student najniziProsjek = studenti.get(0);
        for (int i = 1; i < studenti.size(); i++) {
            if (studenti.get(i).getProsjekOcjena() < najniziProsjek.getProsjekOcjena()) {
                najniziProsjek = studenti.get(i);
            }
        }
        return najniziProsjek;
    }

    private static double izracunajProsjekOcjena(List<Student> studenti) {
        double suma = 0;
        for (Student student : studenti) {
            suma += student.getProsjekOcjena();
        }
        return suma / studenti.size();
    }
}
