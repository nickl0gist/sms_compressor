public class Paginator {

    private final int signQty;

    public Paginator(int signQty) {
        this.signQty = signQty;
    }

    public String[] paginate(String text) {
        return text.split("(?<=\\G.{" + signQty + "})");
    }
}
