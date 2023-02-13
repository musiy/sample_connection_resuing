package me.musii;

import feign.Feign;
import feign.RequestLine;
import feign.httpclient.ApacheHttpClient;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class App {

    public static void main(String[] args) throws Exception {

        Options options = new Options();
        options.addRequiredOption("u", "url", true, "host url");
        options.addRequiredOption("r", "reuse", true, "reuse connection");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        String url = cmd.getOptionValue("u");
        boolean reuseConnection = Boolean.parseBoolean(cmd.getOptionValue("r"));

        try (CloseableHttpClient closeableHttpClient = HttpClientBuilder.create()
                .setConnectionReuseStrategy((httpResponse, httpContext) -> reuseConnection)
                .build()) {
            AnyHttpApi anyHttpApi = Feign.builder()
                    .client(new ApacheHttpClient(closeableHttpClient))
                    .target(AnyHttpApi.class, url);
            check(url, anyHttpApi);
        }
    }

    public static void check(String url, AnyHttpApi anyHttpApi) {
        System.out.println("Staring with " + url);
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            long t = System.currentTimeMillis();
            anyHttpApi.get();
            System.out.println("req time: " + (System.currentTimeMillis() - t));
        }
        System.out.println("Total time of all requests: " + (System.currentTimeMillis() - t0));
    }

    public interface AnyHttpApi {

        @RequestLine("GET /")
        void get();
    }

}
