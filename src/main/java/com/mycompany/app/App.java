package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
  public static int search(ArrayList<Integer> array,ArrayList<Integer> array2,int input1, int input2) { 
  System.out.println("inside search");
  if (array == null||array2 == null) return -3;
  boolean flag1=false;
  boolean flag2=false;
  int count1=0;
  int count2=0;
 if(array.size()<=input1||array2.size()<=input2) return -3;
  if(array.get(input1)!=null){
      count1=array.get(input1);
      flag1=true;
    
  }
  if(array2.get(input2)!=null){
      flag2=true;
      count2=array.get(input2);
    
  }
  if(flag1==false|| flag2 ==false) return -3;
  if(flag2==true && flag1 == true)
    if(count1>count2){
      return 1;
    }else if(count2>count1){
    return -1;
  }else 
  return 0;

  return -3;
}
    
public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello,, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

        
          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);
          

          String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
          while (sc2.hasNext())
          {
            int value2 = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList.add(value2);
          }
          System.out.println(inputList2);
          
          String input3 = req.queryParams("input3").replaceAll("\\s","");
          int input3AsInt = Integer.parseInt(input3);

          String input4 = req.queryParams("input4").replaceAll("\\s","");
          int input4AsInt = Integer.parseInt(input4);
          
          int result = App.search(inputList, inputList2,input3AsInt,input4AsInt);
   
         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
     return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
