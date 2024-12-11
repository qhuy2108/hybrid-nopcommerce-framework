package quan2;

import quan1.NguyenHue;

public class AnPhu extends NguyenHue {
    public void clickTo() {
        // System.out.println(getCafe());  getCafe() là private không gọi được
        // Do kế thừa NguyenHue nên có thể gọi trưc tiếp getCafe()
    }
}
