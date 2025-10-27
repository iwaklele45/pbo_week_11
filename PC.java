public class PC {
    private String nama;
    private int totalHarga;
    private Component[] components;
    private int number;

    public PC(String nama) {
        this.nama = nama;
        this.components = new Component[20];
        this.number = 0;
        this.totalHarga = 0;
    }

    public void addComponent(Component cp) {
        if (number < components.length) {
            components[number] = cp;
            number++;
            totalHarga += cp.getHarga();
        } else {
            System.out.println("Tidak bisa menambah komponen lagi!");
        }
    }

    public void showComponents() {
        System.out.println("Komponen " + nama + ":");
        for (int i = 0; i < number; i++) {
            components[i].showInfo();
        }
    }

    public void getTotalHarga() {
        System.out.println("Total Harga PC : Rp" + totalHarga);
    }

}

