package com.example.moneygo.util.crackaspose;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Crack {
//    https://www.jianshu.com/p/5a90d17852ce?u_atoken=69c82cc3-035a-436d-9d85-d39b1cef8d59&u_asession=017bmONGXZqDlnzhEqmvN2i1rlwr7ekEIVr5mVrVQtEAac5NHwYB3BhzrX3EwqSJEBX0KNBwm7Lovlpxjd_P_q4JsKWYrT3W_NKPr8w6oU7K_cp0MaqXUzGaPi05WpxI_1g0pn3tpfEcqG8HZmzd6q3mBkFo3NEHBv0PZUm6pbxQU&u_asig=05uI-T_Bavjg2Z1FQG6B1Nc3HcXtjkT34iT4egca08bexN7P0CEFulqPYJ1yykTubKlyYBWebazZc4Ybzm9o-G4qjpj0okamQiOrVL751ZKNeAiihTLLf74mzzUcAYq91XAE5N1tqet6ytLE8iscjH5JLrhWCRq9QSOsR8wXjwk5_9JS7q8ZD7Xtz2Ly-b0kmuyAKRFSVJkkdwVUnyHAIJzZrgMtzcHxBCKW0xX-Jjb1VdXSFPZY1ybvheIB7fqJVO6xaDswPo-3_59so9Oh9f1-3h9VXwMyh6PgyDIVSG1W8m1o7qMfoPkgjPO_R05MgEJ2WtvUNG7x_AWHziMPYnF_bFR0CuR6DzN3rT7_o-Hiw496iH0QmQ-eBNTsC6MNZMmWspDxyAEEo4kbsryBKb9Q&u_aref=CrPAri%2FTabeprRNKNxVQ31%2FiL3k%3D
//     替换生成的com里面的文件，然后删掉jar包里面的.RSA和.SF文件
    public void wordCrack(){
//        Aspose-word aspose-words-21.11-jdk17.jar破解
//        <groupId>com.aspose</groupId>
//            <artifactId>aspose-words</artifactId>
//            <version>21.11</version>
//            <classifier>jdk17</classifier>
        try {
            //这一步是完整的jar包路径,选择自己解压的jar目录
            ClassPool.getDefault().insertClassPath("D:\\aspose-words-21.11-jdk17.jar");
            //获取指定的class文件对象
            CtClass zzZJJClass = ClassPool.getDefault().getCtClass("com.aspose.words.zzXDb");
            //从class对象中解析获取指定的方法
            CtMethod[] methodA = zzZJJClass.getDeclaredMethods("zzY0J");
            //遍历重载的方法
            for (CtMethod ctMethod : methodA) {
                CtClass[] ps = ctMethod.getParameterTypes();
                if (ctMethod.getName().equals("zzY0J")) {
                    System.out.println("ps[0].getName==" + ps[0].getName());
                    //替换指定方法的方法体
                    ctMethod.setBody("{this.zzZ3l = new java.util.Date(Long.MAX_VALUE);this.zzWSL = com.aspose.words.zzYeQ.zzXgr;zzWiV = this;}");
                }
            }
            //这一步就是将破译完的代码放在桌面上
            zzZJJClass.writeFile("D:\\");
        } catch (Exception e) {
            System.out.println("错误==" + e);
        }
    }


    public void pdfCrack(){
        //        Aspose-pdf aspose-pdf-18.1.jar.jar破解
        try {
            ClassPool.getDefault().insertClassPath("D:\\aspose-pdf-18.1.jar");
            CtClass c2 =ClassPool.getDefault().getCtClass("com.aspose.pdf.z122");
            CtMethod[] ms =c2.getDeclaredMethods();
            for (CtMethod c: ms){
                CtClass[] ps =c.getParameterTypes();
                if(c.getName().equals("m1") && ps .length ==2
                        && ps[0].getName().equals("org.w3c.dom.Node")
                        && ps[1].getName().equals("org.w3c.dom.Node")){
                    String aaa ="{return;}";
                    System.out.println(aaa);
                    c.setBody(aaa);
                    c2.writeFile("D:\\");
                    System.out.println("done");
                }
            } } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
