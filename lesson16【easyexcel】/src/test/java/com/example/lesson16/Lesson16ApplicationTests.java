package com.example.lesson16;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Lesson16ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void writeExcel() throws Exception{
        try(OutputStream outputStream = new FileOutputStream("test.xlsx")){
            ExcelWriter writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLSX, false);
            Sheet sheet = new Sheet(1,0);
            sheet.setSheetName("sheet1");
            List<List<String>> data = new ArrayList<>();
            for(int i=0;i<20; i++){
                List<String> item = new ArrayList<>();
                item.add("item0" + i);
                item.add("item1" + i);
                item.add("item2" + i);
                data.add(item);
            }
            writer.write0(data, sheet);
            writer.finish();
        }
    }

}
