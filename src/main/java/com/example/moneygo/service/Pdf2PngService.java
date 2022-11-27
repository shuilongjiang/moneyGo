package com.example.moneygo.service;

import com.aspose.pdf.Document;
import com.aspose.pdf.License;
import com.aspose.pdf.devices.JpegDevice;
import com.aspose.pdf.devices.Resolution;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Pdf2PngService {

        /**
         * 获取license
         *
         * @return
         */
        private static boolean getLicense() {
            boolean result = false;

            try {
                // 凭证
                String license =
                        "<License>\n" +
                                "  <Data>\n" +
                                "    <Products>\n" +
                                "      <Product>Aspose.Total for Java</Product>\n" +
                                "    </Products>\n" +
                                "    <EditionType>Enterprise</EditionType>\n" +
                                "    <SubscriptionExpiry>20991231</SubscriptionExpiry>\n" +
                                "    <LicenseExpiry>20991231</LicenseExpiry>\n" +
                                "    <SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber>\n" +
                                "  </Data>\n" +
                                "  <Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature>\n" +
                                "</License>";
                InputStream is = new ByteArrayInputStream(license.getBytes("UTF-8"));
                License asposeLic = new License();
                asposeLic.setLicense(is);
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }

        /**
         * pfd转图片
         * @param pdf 源文件全路径
         * @param outPath 转后的文件夹路径
         * @param reso 分辨率
         */
        public  void pdfToImage(String pdf, String outPath,int reso){
//         验证License
            if(!getLicense()) {
                return;
            }

            try {
                String pdffullname = pdf.substring(pdf.lastIndexOf("/")).replaceAll("/","");
                System.out.println(pdffullname);
                String pdfname = pdffullname.substring(0,pdffullname.lastIndexOf("."));
                System.out.println(pdfname);
                Document pdfDocument = new Document(pdf);
                //图片宽度：800
                //图片高度：100
                // 分辨率 960
                //Quality [0-100] 最大100
                //例： new JpegDevice(800, 1000, resolution, 90);
                Resolution resolution = new Resolution(reso);
                JpegDevice jpegDevice = new JpegDevice(resolution);
                for (int index=1;index<=pdfDocument.getPages().size();index++) {
                    // 输出路径
                    File file = new File(outPath +"/"+ pdfname+"_"+index+".jpg");
                    FileOutputStream fileOs = new FileOutputStream(file);
                    jpegDevice.process(pdfDocument.getPages().get_Item(index), fileOs);
                    fileOs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        /**
         * 批量pdf转图片
         * @param pdflj 源文件所在目录
         * @param fbl 分辨率
         */
        public  void plpdf2image(String pdflj,int fbl) {
            System.out.println("本次转换"+pdflj+"下的pdf文件");
            File file=new File(pdflj);
            for(File temp:file.listFiles()){
                if(temp.isFile()){
                    String ljfile=temp.toString();
                    System.out.println("本次转换"+ljfile);
                    String suffix = ljfile.substring(ljfile.lastIndexOf(".") + 1);
//                System.out.println(suffix);
//                String suffix2 = ljfile.substring(ljfile.lastIndexOf("/")).replaceAll("/","");
//                System.out.println(suffix2);
//                String suffix3 = suffix2.substring(0,suffix2.lastIndexOf("."));
//                System.out.println(suffix3);
                    int zindex7 = "pdf".indexOf(suffix);
                    if(zindex7 != -1){
                        System.out.println(ljfile+ "开始转换");
                        pdfToImage(ljfile,pdflj+"/out",fbl);
                        System.out.println(ljfile+ "转换完成");

                    }else {
                        System.out.println(ljfile+ "非PDF文件无法转换成pdf");
                    }
                }
            }
            System.out.println("转换完成");
        }
}
