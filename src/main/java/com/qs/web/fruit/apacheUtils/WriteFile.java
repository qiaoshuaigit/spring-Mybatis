package com.qs.web.fruit.apacheUtils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author shuaion 2018/2/9
 **/
public class WriteFile {

    public static void main(String[] args) {
        File file = new File("/Users/shuai/develop/learn/file.txt");
        String value = "在刚刚过去的2017年，雷克萨斯在前一年10万辆基础上又实现了进一步增长，全年累计销售132,864台。从2018年1月的开门红业绩看，这种良好的趋势仍在继续。虽然雷克萨斯至今没有国产，但其在华销量已占全球份额的20%。\n" +
                "纯进口的雷克萨斯在豪华车市场算是一股清流，从1月销量看，智•混动车型已经占到销量的30%，为4095辆，这也是自去年11月份以来，智•混动车型连续3个月销量占比突破30%。截至2018年1月底，我们的智•混动车型在华累计销量已突破15万台。\n" +
                "大竹仁表示，“在油耗限制愈加严格的大趋势下，智•混动车型将是今后的发展关键。”\n" +
                "在1月各个车型的细分市场表现上：ES销量为5,764台，RX为2,679台，NX为2,813台。前段时间上市的全新双旗舰LS、LC已成功获得1247台的订单，远超预期。";
        try {
            FileUtils.writeStringToFile(file,value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
