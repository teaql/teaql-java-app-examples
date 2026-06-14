public class FindSink {
    public static void main(String[] args) {
        System.out.println(new io.teaql.runtime.TeaQLRuntime.Builder().build().getLogSink().getClass().getName());
    }
}
