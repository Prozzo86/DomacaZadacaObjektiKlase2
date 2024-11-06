public class Student {
        private String ime;
        private String prezime;
        private String brojIndeksa;
        private double prosjekOcjena;

        public Student(String ime, String prezime, String brojIndeksa, double prosjekOcjena) {
            this.ime = ime;
            this.prezime = prezime;
            this.brojIndeksa = brojIndeksa;
            this.prosjekOcjena = prosjekOcjena;
        }

        public String getIme() {
            return this.ime;
        }

        public String getPrezime() {
            return this.prezime;
        }

        public String getBrojIndeksa() {
            return this.brojIndeksa;
        }

        public double getProsjekOcjena() {
            return this.prosjekOcjena;
        }
}

