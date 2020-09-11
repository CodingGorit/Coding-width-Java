package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *������AlipayConfig
 *���ܣ�����������
 *��ϸ�������ʻ��й���Ϣ������·��
 *�޸����ڣ�2017-04-05
 *˵����
 *���´���ֻ��Ϊ�˷����̻����Զ��ṩ���������룬�̻����Ը����Լ���վ����Ҫ�����ռ����ĵ���д,����һ��Ҫʹ�øô��롣
 *�ô������ѧϰ���о�֧�����ӿ�ʹ�ã�ֻ���ṩһ���ο���
 */

public class AlipayConfig {

//�����������������������������������Ļ�����Ϣ������������������������������

    // Ӧ��ID,����APPID���տ��˺ż�������APPID��Ӧ֧�����˺�
    public static String app_id = "2016102200740071";

    // �̻�˽Կ������PKCS8��ʽRSA2˽Կ
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCKSdVHUv87U9eVxOnqWUqew5+JF9dFNytVxZaPFnE2WX7mYUqllcXnk8+VA27xq5kzn6docu58Vqnucy6nS5DJToxf36xPDsT9741V/u4u5UIGYsf4mt9lJeulv7oEq7cxyWxfa3cUGC+M0gSZuso4bnugKa88I4Jtm1kBpAJgR4pn33uTqVGlbao29/cjhjbCCFx5F7VlghggZspadtOdRgeM1Vjp76ffJVUmNBnKFcKX4nmp8+sAvtLsZETTnyK91G52FAbAqCBx9UCTFjggHFYpJ+NZHKW6w8N5DmoRmlKpz9FQpKZReIbHEhJHa0vqLAn06kMafsbwJrapjdLtAgMBAAECggEAOT6RDCJeRzfQwU2vKvRlgE0oaD63PQ62YJ4XUgoPOVlYv5M8rEjQkKlOP7gZH+9Rzt3jFcil0lCprWx+vn/4YmyijTlxAZTylM+qKRQLktwSNcSEVPP/T8afwpAYN8DBZ9mig+lfdLECVf/GKcD53txVTpqS0Ik+f5LUCGrVFPdMlHZ6Ph2kbjY5pCJbhQ2HbOb+3+9vyTJoKWNorh/fGEtyK4bOfBeRZJRvEsUZaIp5kSpyUZ8C5cIw0LUpZ6O+kTmSjsQvVx7ywoYbBe0g946V4GGegtR4aWeZsUvX6STmEmGm6r19F3APGG0I5oqrAomMo17J37JSz+Q1Bz90IQKBgQC//5VV4IxD/Iaaw8INLs9lWFpd1OE/hTgzJ2tpt5qcdO+Cq2YlawEYDpvY/WnERjIr+Nrpv2oj/WDydOGKaLKOl3INedQR9ajNjeo2tRqPse5WipjmEJnyxFFm51Oh44WoF2+GvD61CpcTikLoIwZE9gb78U+cSf7mNyR7rRq5hQKBgQC4YtgjtmErZ5i2GlRGJ7LSaLQopLz9BKoFBUDY+6Hz/NwAf2ZeW12YZBE7F+0HrYEvQiDKX76bXNA//hB/4rVWCjS1cBpXfD92z4oCcLyHib9j8owX6v77y0GX6ALO2gXqSJ+15WflvKLTP5A9WWcnksi/CqiT0udovw6orhD8SQKBgGitnSrEEVVj0bOBdUQguFxlzmcIEILETD6/iDWML9SLgKX6cueFroQCOwAUMd0b9HC67gexH9pdY8Ts6qa+rFNHyJwGRxQ/nnfrnr2TAddESFCQogoVFQoh9Muo5ZUG6jEaDekkqv+jtXim0hGkPt/MT0R/bUsloL69Y7u2RjLNAoGBAIL1WVQMDfm5C6KTErX9Lin5SbPwRXZjYKpOL9+s4TscpdkIo1lzBQfeUsqo1KX2WmGJUybJV+SayCIbPfbGu0qP1x3isCLg0WZ+QyQ2lACkGjZPp6a5Nj75/u14UL4/5aGf0Sds9x0ZnH/zjmu0Wuqle0UMuey8B7XCtROjBddZAoGBAISghwOwIIoordn4fz3vNeDYObTsIZJXBr3r3A4NzXlnRv+kWr+CjC3rfrHx7/jH1ziNnj6wKrsx9aXkDelU1ZYIlo+cF1qntuPewhSm5RQdt4W567gA+F010WsEVGSoOXInGMZLnzNiR4IIRWyTIxLOquxe5HMG+1WY/DHaHOwe";

    // ֧������Կ,�鿴��ַ��https://openhome.alipay.com/platform/keyManage.htm ��ӦAPPID�µ�֧������Կ��
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiknVR1L/O1PXlcTp6llKnsOfiRfXRTcrVcWWjxZxNll+5mFKpZXF55PPlQNu8auZM5+naHLufFap7nMup0uQyU6MX9+sTw7E/e+NVf7uLuVCBmLH+JrfZSXrpb+6BKu3MclsX2t3FBgvjNIEmbrKOG57oCmvPCOCbZtZAaQCYEeKZ997k6lRpW2qNvf3I4Y2wghceRe1ZYIYIGbKWnbTnUYHjNVY6e+n3yVVJjQZyhXCl+J5qfPrAL7S7GRE058ivdRudhQGwKggcfVAkxY4IBxWKSfjWRylusPDeQ5qEZpSqc/RUKSmUXiGxxISR2tL6iwJ9OpDGn7G8Ca2qY3S7QIDAQAB";

    // �������첽֪ͨҳ��·��  ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
    public static String notify_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // ҳ����תͬ��֪ͨҳ��·�� ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
    public static String return_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // ǩ����ʽ
    public static String sign_type = "RSA2";

    // �ַ������ʽ
    public static String charset = "utf-8";

    // ֧��������
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // ֧��������
    public static String log_path = "C:\\";


//�����������������������������������Ļ�����Ϣ������������������������������
    /**
     * д��־��������ԣ�����վ����Ҳ���ԸĳɰѼ�¼�������ݿ⣩
     * @param sWord Ҫд����־����ı�����
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

