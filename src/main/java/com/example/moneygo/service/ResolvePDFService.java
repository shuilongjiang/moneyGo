package com.example.moneygo.service;


import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;
import org.springframework.stereotype.Service;

@Service
public class ResolvePDFService {
//    public ResolvePDF() {
//        try {
//            // 获取aspose的凭证
//            String license =
//                    "<License>\n" +
//                            "  <Data>\n" +
//                            "    <Products>\n" +
//                            "      <Product>Aspose.Total for Java</Product>\n" +
//                            "      <Product>Aspose.Words for Java</Product>\n" +
//                            "    </Products>\n" +
//                            "    <EditionType>Enterprise</EditionType>\n" +
//                            "    <SubscriptionExpiry>20991231</SubscriptionExpiry>\n" +
//                            "    <LicenseExpiry>20991231</LicenseExpiry>\n" +
//                            "    <SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber>\n" +
//                            "  </Data>\n" +
//                            "  <Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature>\n" +
//                            "</License>";
//            InputStream is = new ByteArrayInputStream(license.getBytes(StandardCharsets.UTF_8));
//            License asposeLic = new License();
//            asposeLic.setLicense(is);
//        } catch (Exception e) {
//
//        }
//    }

    public void pdf2word(){
        Document doc = null;
        try {
            doc = new Document("D:\\file\\input.pdf");
            doc.save("D:\\file\\output.doc", SaveFormat.Doc);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
