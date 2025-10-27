public class Component {
    protected String nama;
    protected int harga;

    public Component(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public void showInfo() {
        System.out.printf("%-30s Rp%,10d%n", nama, harga);
    }

    public int getHarga() {
        return harga;
    }
}

