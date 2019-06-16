public class NativeCompressor implements Compressor{

    @Override
    public String compress(String text) {
        String[] strArr = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s: strArr){
            s = s.substring(0, 1).toUpperCase() + s.substring(1);
            sb.append(s);
        }
        return sb.toString();
    }

    @Override
    public String deCompress(String text) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = text.split("(?=\\p{Upper})");
        for (String s: strArr){
            sb.append(s + " ");
        }
        return sb.toString().trim();
    }
}
