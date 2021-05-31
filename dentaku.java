import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class dentaku {
  public static void main(String[] args) {
    System.out.print("式:");
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextLine()){
      String line = sc.nextLine();
      Pattern pattern = Pattern.compile("\\d+|\\D+");
      Matcher  matcher = pattern.matcher(line);
      LinkedList<String> formula = new LinkedList<String>(Arrays.asList());

      while(matcher.find()){
        String matcherGroup = matcher.group();
        formula.add(matcherGroup);
      }

      int divide_FrontNumber = 0;
      int divide_BackNumber = 0;

      while(formula.size() >= 2){
        if (formula.contains("*")){
          int multiply_Search = formula.indexOf("*");
          int multiply_FrontNumber = Integer.parseInt(formula.get(multiply_Search-1));
          int multiply_BackNumber = Integer.parseInt(formula.get(multiply_Search+1));
          int multiply_Answer = multiply_FrontNumber * multiply_BackNumber;
          formula.add(multiply_Search-1,String.valueOf(multiply_Answer));
          formula.remove((formula.get(multiply_Search+1)));
          formula.remove((formula.get(multiply_Search)));
          formula.remove((formula.get(multiply_Search)));

        }else if(formula.contains("/")){
          int divide_Search = formula.indexOf("/");
          divide_FrontNumber = Integer.parseInt(formula.get(divide_Search -1));
          divide_BackNumber = Integer.parseInt(formula.get(divide_Search +1));

          if(formula.contains("/") && divide_BackNumber == 0){
            System.out.println("エラー");
            int divide_Number = 0;
            formula.add(0,String.valueOf(divide_Number));
            break;
          }
          int divide_Answer = divide_FrontNumber / divide_BackNumber;
          formula.add(divide_Search-1,String.valueOf(divide_Answer));
          formula.remove((formula.get(divide_Search+1)));
          formula.remove((formula.get(divide_Search)));
          formula.remove((formula.get(divide_Search)));

        }else if (formula.contains("+")){
          int addition_Search = formula.indexOf("+");
          int addition_FrontNumber = Integer.parseInt(formula.get(addition_Search -1));
          int addition_BackNumber = Integer.parseInt(formula.get(addition_Search +1));
          int addition_Answer = addition_FrontNumber + addition_BackNumber;
          formula.add(addition_Search-1,String.valueOf(addition_Answer));
          formula.remove((formula.get(addition_Search+1)));
          formula.remove((formula.get(addition_Search)));
          formula.remove((formula.get(addition_Search)));

        }else if(formula.contains("-")){
          int subtract_Search = formula.indexOf("-");
          int subtract_FrontNumber = Integer.parseInt(formula.get(subtract_Search -1));
          int subtract_BackNumber = Integer.parseInt(formula.get(subtract_Search +1));
          int subtract_Answer = subtract_FrontNumber - subtract_BackNumber;
          formula.add(subtract_Search-1,String.valueOf(subtract_Answer));
          formula.remove((formula.get(subtract_Search+1)));
          formula.remove((formula.get(subtract_Search)));
          formula.remove((formula.get(subtract_Search)));
        }
      }
        System.out.println("答え:" + formula.get(0));
    }
  }
}