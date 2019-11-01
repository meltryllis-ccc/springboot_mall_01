package com.meltryllis.springbootmall.alipayconf;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Ereshkigal
 * @date 2019/10/30 - 11:17
 */
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101500691004";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCBLCrPP/utcqLjqNJq52Jl893lbdrRGjsBRo/3+uWsBmE0HhJYFJAsCdOY6JGY4o0uDusarydySAHFl2HeLw2UAhcwXFoSk5q1Lp9iToX2ew9JKbgWpoTjjOZpS8CKjJrduRDsyGHh9i8KcN7SivJE11fQJ91MP+5Sam+T20s5ujr1/GoIzopSmoMNMShU8my7C/b5NRKNoFw7oHtDjhJ0KiB/FFnL9oCtMq3bHTYqtchtLH18affhKT0PLgXfCmpWMFe6EBGH7e1Csab5ED9SgWyGRPovic6P95kWGf6jRzh41A5Q4xZDLkzWSxAFmwF7AyHDzTZNtnimURKXeJsZAgMBAAECggEAOeDFacmchpIoBGQfrEDzKQWFNojrk+fx6ldoqM9l25ecNFMJGyhTlTft9MS4gE16vtl2ZKV4wk8bZCK5emmQ5vGs3EF1Jn+2wVobllvi0JdBOSIVVyjTwHXgw+tqYWow9go3WDFNEodRepcqcCJL/aaTtTQ3hzPaIFmKlzCaW0m4W8sywBCX0yuIX5RiO7KRvqN4fDSkoOYsFXms2iRbthq2FTMmmk8nWo8DjGbHwljyT/jdg2Ev/B490q+rtyZlRDFmP53KlDrsY7O6j4c6/umuAvaWQHCgTfu0uzw0oYBbqw55WIXy0KUMldQhZzxQUTjI2IrjDkn1S87dJ3JWAQKBgQD5+C8CI51yTXcQZNTfd9d8+laScpL32l759KotnPnpmmomDj/7OPjZuEHGd1gHEDEgxLpM+xrN/5oOz6vBBotTupyQGiWLUqNhuZteN5bodgm+D8mCz6ZCi2i+ht48w/nuPXmo1TJ34QfFCePEVZ1F3QOz2DqbmDSIxvbZR4LrQQKBgQCESfB23so04xDiAE7yq2OUIFDC5ksO0l8GV3nRcLEaqZ+mnE2yl8mrpkbMzis738eg5MWopNHXVnSDYykd1/I9KWTE7AgKjcglh/Pj06uDxj1ixMxf+cBfYsEh1BrmnuCEBxRe/QaJ+nqYRH6YsqcOGdWH3tRZZug+piuru0fx2QKBgGWe+uVguzpjubrFczEiFE2vrBA/WfY/JYtyZtjCT2sjpnGwK1yjba99U+guTnAYqhBLSf3Pu7bxaZ0J2iZP1caFP+7pYkgAoYEyJrKn4MbCbfWBj4eJiWrWKBAE3kZP2cR744C6o5jOuAznl1wS/iwPzNiJWFI3D2xnjqUIiHXBAoGAUmkpdzQFbfsCmngstnpUt4OGLFSA78PYVMAL8JCuk/iVr5pxwM9UYC1er9nEDzGyUCYUiKHc47RFM1CD3caYbsepsg+EVubKh67xHb3QfG/z7+K/mw6gbAu+Ww+ijobtQPKUGzSvbSdwVgldgEzTSzKG1nTXfrZf+h9U10/9WskCgYAm1sRkCaMNLFcxpPuZa45GIQ9Sw33A9wHlyJ9p2r2Rr3MVYBJidesjKYrY4Pq+pOWyeGPVkDL6X9auEuiTLP9xuBVl+UPGYtQCYmJde44YGQASS7aYXXogHy/ju2A3zmOYUfIO4CuWWTd89dAi9XOrHkyBFqaRCE9SZEBDF3sCBg==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgSwqzz/7rXKi46jSaudiZfPd5W3a0Ro7AUaP9/rlrAZhNB4SWBSQLAnTmOiRmOKNLg7rGq8nckgBxZdh3i8NlAIXMFxaEpOatS6fYk6F9nsPSSm4FqaE44zmaUvAioya3bkQ7Mhh4fYvCnDe0oryRNdX0CfdTD/uUmpvk9tLObo69fxqCM6KUpqDDTEoVPJsuwv2+TUSjaBcO6B7Q44SdCogfxRZy/aArTKt2x02KrXIbSx9fGn34Sk9Dy4F3wpqVjBXuhARh+3tQrGm+RA/UoFshkT6L4nOj/eZFhn+o0c4eNQOUOMWQy5M1ksQBZsBewMhw802TbZ4plESl3ibGQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://kyd.free.idcfengye.com/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
