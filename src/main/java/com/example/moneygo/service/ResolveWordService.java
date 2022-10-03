package com.example.moneygo.service;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

public class ResolveWordService {

    public void word2pdf(){
        Document doc = null;
        try {
            doc = new Document("D:\\file\\output.doc");
            doc.save("D:\\file\\output+.pdf", SaveFormat.PDF);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
