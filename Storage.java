public class Storage extends Component {
    protected int size;

    public Storage(String nama, int size, int harga) {
        super(nama, harga);
        this.size = size;
    }

    @Override
    public void showInfo() {
        System.out.println(nama + " - " + size + "GB - Rp" + harga);
    }
}

