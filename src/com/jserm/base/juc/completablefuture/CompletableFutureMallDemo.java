package com.jserm.base.juc.completablefuture;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

// CompletableFuture这个类还有很多api，具体可以看文档
// 比如thenApply handle， get， getNow
public class CompletableFutureMallDemo {
    static List<NetMall> list = Arrays.asList(
            new NetMall("JD"),
            new NetMall("DANGDANG"),
            new NetMall("TAOBAO")
    );

    //            String.format(productName + " in %s price is %s"),
//            netMall.getNetMallName(),
//            netMall.calPrice(productName)
    public static List<String> getPriceByCompletableFuture(List<NetMall> list, String productName) {
        return list.stream().map(netMall -> CompletableFuture.supplyAsync(() ->
                        String.format(productName + " in %s price is %.2f",
                                netMall.getNetMallName(),
                                netMall.calPrice(productName)))).collect(Collectors.toList())
                .stream().map(s -> s.join()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(ThreadLocalRandom.current().nextDouble() * 2 + "mysql".charAt(0));
        List<String> jd = getPriceByCompletableFuture(list, "mysql");
        for (String item:
             jd) {
            System.out.println(item);
        }
    }
}


class NetMall {
    private String netMallName;

    public NetMall(String netMallName) {
        this.netMallName = netMallName;
    }

    public String getNetMallName() {
        return netMallName;
    }

    public double calPrice(String productName) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }
}