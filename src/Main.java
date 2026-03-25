import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 필요한 변수 & 객체 선언 및 초기화
        Number num1 = 0;
        Number num2 = 0;
        Number result = 0;
        boolean endPoint = false;
        boolean checkPoint = false;
        int continueYn = 0;
        OperatorType ot = null;
        String input;
        Number searchNum = 0;

        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Number> cal = new ArithmeticCalculator<>();

        // 계산기 시작
        do {
            System.out.println("=== 계산기 시작 ===");

            // 1번째 숫자 입력
            System.out.print("첫번째 숫자를 입력해주세요: ");
            do {
                try {
                    input = scanner.next();
                    num1 = input.contains(".") ? Double.parseDouble(input) : Integer.parseInt(input);
                    if(num1.doubleValue() < 0) {
                        System.out.print("0 이상의 숫자를 입력해주세요.\n다시 입력해주세요: ");
                    } else {
                        checkPoint = true;
                    }
                } catch(InputMismatchException e) {
                    System.out.print("잘못된 입력입니다.\n다시 입력해주세요: ");
                    scanner.nextLine();
                }
            } while(!checkPoint);
            checkPoint = false;

            // 연산자 입력
            System.out.print("연산자를 입력해주세요: ");
            do {
                ot = OperatorType.getSymbol(scanner.next());
                if(ot != null) {
                    checkPoint = true;
                } else {
                    System.out.print("연산자가 아닌 입력입니다.\n다시 입력해주세요: ");
                }
            } while(!checkPoint);
            checkPoint = false;

            // 2번째 숫자 입력
            System.out.print("두번째 숫자를 입력해주세요: ");
            do {
                try {
                    input = scanner.next();
                    num2 = input.contains(".") ? Double.parseDouble(input) : Integer.parseInt(input);
                    if(num2.doubleValue() < 0) {
                        System.out.print("0 이상의 숫자를 입력해주세요.\n다시 입력해주세요: ");
                    } else if(num2.doubleValue() == 0 && ot == OperatorType.DIV) {
                        System.out.print("나눗셈 연산에서 분모로 0은 입력 될 수 없습니다.\n다시 입력해주세요: ");
                    } else {
                        checkPoint = true;
                    }
                } catch(InputMismatchException e) {
                    System.out.print("잘못된 입력입니다.\n다시 입력해주세요: ");
                    scanner.nextLine();
                }
            } while(!checkPoint);
            checkPoint = false;

            //계산
            result = cal.calculate(num1, ot, num2);

            // 결과 출력
            System.out.println(num1 + " " + ot.getSymbol() + " " + num2 + " = " + String.format("%.2f", result));

            // 재계산 여부 확인
            do {
                System.out.print("\n다음 메뉴 중 고르세요\n1. 기록조회\n2. 입력값보다 큰 결과만 조회\n3. 오래된 기록삭제\n4. 다시 계산\n5. 계산기 종료\n입력: ");
                continueYn = scanner.nextInt();

                switch (continueYn) {
                    case 1:
                        if(!cal.getLists().isEmpty()) {
                            System.out.println("\n=== 계산 기록 ===");
                            cal.getLists().forEach(c -> System.out.println(c.getNum1() + " " + c.getOt().getSymbol() + " " + c.getNum2() + " = " + String.format("%.2f", c.getResult())));
                            System.out.println("=== 끝 ===");
                        } else {
                            System.out.println("현재 작성된 기록이 없습니다.\n");
                        }
                        break;
                    case 2:
                        if(!cal.getLists().isEmpty()) {
                            System.out.print("검색 하고싶은 수를 입력하세요: ");
                            do {
                                try {
                                    input = scanner.next();
                                    searchNum = input.contains(".") ? Double.parseDouble(input) : Integer.parseInt(input);
                                    Number finalSearchNum = searchNum;
                                    System.out.println("\n=== 계산 기록 ===");
                                    cal.getLists().stream().filter(c -> c.getResult() > finalSearchNum.doubleValue()).forEach(c -> System.out.println(c.getNum1() + " " + c.getOt().getSymbol() + " " + c.getNum2() + " = " + String.format("%.2f", c.getResult())));
                                    System.out.println("=== 끝 ===");
                                    checkPoint = true;
                                } catch(NumberFormatException e) {
                                    System.out.print("잘못된 입력입니다.\n다시 입력해주세요: ");
                                    scanner.nextLine();
                                }
                            } while(!checkPoint);
                            checkPoint = false;
                        } else {
                            System.out.println("현재 작성된 기록이 없습니다.\n");
                        }
                        break;
                    case 3:
                        cal.removeFirst();
                        System.out.println("삭제되었습니다.\n");
                        break;
                    case 4:
                        System.out.println("다시 계산합니다.\n");
                        checkPoint = true;
                        break;
                    case 5:
                        System.out.println("=== 계산기 종료 ===");
                        endPoint = true;
                        checkPoint = true;
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        break;
                }
            } while(!checkPoint);
            checkPoint = false;

        } while(!endPoint);

        scanner.close();

    }

}
