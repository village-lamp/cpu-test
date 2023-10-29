public class test {
    public static void main(String[] args) {
        String ratioN = "0.869";
        double ratio = Double.parseDouble(ratioN);
        int hitPoint = 422;
        System.out.println((int) Math.floor(hitPoint * (1 + ratio)));
        System.out.println(hitPoint + (int) Math.floor(hitPoint * ratio));
    }
}
