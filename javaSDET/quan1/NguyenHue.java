package quan1;

public class NguyenHue {
    private String cafe;

    private String getCafe() {
        return cafe;
    }

    public static void main(String[] args) {
        NguyenHue nguyenHue = new NguyenHue();
        nguyenHue.cafe = "Espresso";
        System.out.println(nguyenHue.getCafe());
    }
}
