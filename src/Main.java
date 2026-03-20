import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int num1 = 0;
        int num2 = 0;
        String oper = null;
        int result = 0;
        boolean endPoint = false;
        boolean checkPoint = false;
        String continueYn = null;

        Scanner scanner = new Scanner(System.in);

        while(!endPoint) {
            System.out.println("=== 계산기 시작 ===");

            //1번째 숫자 입력
            System.out.print("첫번째 숫자를 입력해주세요: ");
            do {
                try {
                    num1 = scanner.nextInt();
                    if(num1 < 0) {
                        System.out.print("0 이상의 숫자를 입력해주세요.\n다시 입력해주세요: ");
                    } else {
                        checkPoint = true;
                        break;
                    }
                } catch(InputMismatchException e) {
                    System.out.print("잘못된 입력입니다.\n다시 입력해주세요: ");
                    scanner.nextLine();
                }
            } while(!checkPoint);
            checkPoint = false;

            //연산자 입력
            System.out.print("연산자를 입력해주세요: ");
            do {
                oper = scanner.next();

                if(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/")) {
                    checkPoint = true;
                    break;
                } else {
                    System.out.print("잘못된 입력입니다.\n다시 입력해주세요: ");
                }
            } while(!checkPoint);
            checkPoint = false;

            //2번째 숫자 입력
            System.out.print("두번째 숫자를 입력해주세요: ");
            do {
                try {
                    num2 = scanner.nextInt();
                    if(num2 < 0) {
                        System.out.print("0 이상의 숫자를 입력해주세요.\n다시 입력해주세요: ");
                    } else if(num2 == 0 && oper.equals("/")) {
                        System.out.print("나눗셈 연산에서 분모로 0은 입력 될 수 없습니다.\n다시 입력해주세요: ");
                    } else {
                        checkPoint = true;
                        break;
                    }
                } catch(InputMismatchException e) {
                    System.out.print("잘못된 입력입니다.\n다시 입력해주세요: ");
                    scanner.nextLine();
                }
            } while(!checkPoint);
            checkPoint = false;

            switch(oper) {
                case "+":
                    result = num1+num2;
                    break;
                case "-":
                    result = num1-num2;
                    break;
                case "*":
                    result = num1*num2;
                    break;
                case "/":
                    result = num1/num2;
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }

            System.out.println(num1 + " " + oper + " " + num2 + " = " + result);

            while(true) {
                System.out.print("다시 계산하시겠습니까?(yes or exit): ");
                continueYn = scanner.next();

                if(continueYn.equalsIgnoreCase("exit")) {
                    System.out.println("=== 계산기 종료 ===");
                    endPoint = true;
                    break;
                } else if(continueYn.equals("yes")) {
                    System.out.println("다시 계산합니다.\n");
                    break;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }

        }

        scanner.close();

    }

}
