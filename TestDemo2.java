package JXLSProj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import com.google.gson.Gson;

public class TestJXLS
{
  public static void main(String[] args)
  {
    try
    {
      List<MyData> inputList = new ArrayList<>();
      List<test1> testList = new ArrayList<>();
      test1 tes1 = new test1("index", "", "16.667");
      test1 tes2 = new test1("", "Block1>flow>index", "8.333");
      test1 tes3 = new test1("", "Block1>test_(min=1,max=2)>flow>index", "8.333");
      test1 tes4 = new test1("index_2", "", "16.667");
      test1 tes5 = new test1("", "Block1>flow>index_2", "8.333");
      test1 tes6 = new test1("", "Block1>test_(min=1,max=2)>flow>index_2", "8.333");
      test1 tes7 = new test1("index_3", "", "16.667");
      test1 tes8 = new test1("", "Block1>flow>index_3", "8.333");
      test1 tes9 = new test1("", "Block1>test_(min=1,max=2)>flow>index_3", "8.333");
      test1 tes10 = new test1("index_4", "", "16.667");
      test1 tes11 = new test1("", "Block1>flow>index_4", "8.333");
      test1 tes12 = new test1("", "Block1>test_(min=1,max=2)>flow>index_4", "8.333");

      testList.add(tes1);
      testList.add(tes2);
      testList.add(tes3);
      testList.add(tes4);
      testList.add(tes5);
      testList.add(tes6);
      testList.add(tes7);
      testList.add(tes8);
      testList.add(tes9);
      testList.add(tes10);
      testList.add(tes11);
      testList.add(tes12);

      MyData avgRespTime = new MyData("AVG RESPONSE TIME", "2.8");
      MyData avgPageThinkTime = new MyData("AVG PAGE THINK TIME", "1.5");
      MyData avgPageFailureRate = new MyData("AVG PAGE FAILURE RATE", "2%");
      MyData virtualUsers = new MyData("VUSERS", "5000");
      MyData sessPacingTime = new MyData("EXPECTED SESSION PACING TIME", "56");
      inputList.add(avgRespTime);
      inputList.add(avgPageThinkTime);
      inputList.add(avgPageFailureRate);
      inputList.add(virtualUsers);
      inputList.add(sessPacingTime);
      
      

      newClass myData = new newClass(inputList, testList);
      
      Gson gson = new Gson();

      // 1. Java object to JSON, and save into a file

      // 2. Java object to JSON, and assign to a String
      String jsonInString = gson.toJson(myData);
      System.out.println(jsonInString);
      //try (InputStream is = TestJXLS.class.getResourceAsStream("object_collection_template.xls"))
      try (InputStream is = new FileInputStream(new File("C:\\Users\\cavisson-267\\Desktop\\newfile.xls")))
      {
        try (OutputStream os = new FileOutputStream("C:\\Users\\cavisson-267\\Desktop\\output.xls"))
        {
          Context context = new Context();
          context.putVar("listData", testList);
          context.putVar("userData", inputList);
          //context.putVar("myData", myData);
          JxlsHelper.getInstance().processTemplate(is, os, context);
        }
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }

    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
